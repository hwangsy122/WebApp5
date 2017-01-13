package com.netsong7.web5.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.netsong7.web5.domain.Board;
import com.netsong7.web5.mybatis.BoardManager;


@Component("boardDao")
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List getList() throws SQLException {
		/*
		List result = new ArrayList<Board>();
		String sql = "select * from tblSpringBoard order by seq desc";
		
		RowMapper rowmapper = new RowMapper() {
			@Override
			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
				Board board = new Board();
				board.setContent(arg0.getString("content"));
				board.setHitcount(arg0.getInt("hitcount"));
				board.setPassword(arg0.getString("password"));
				board.setRegdate(arg0.getString("regdate"));
				board.setSeq(arg0.getInt("seq"));
				board.setTitle(arg0.getString("title"));
				board.setWriter(arg0.getString("writer"));
				return board;
			}
		};
		
		result = jdbcTemplate.query(sql, rowmapper);
		return result;
		*/
		
		return BoardManager.getList();
	}

	@Override
	public void write(Board board) throws SQLException {
		/*
		String sql = "insert into tblSpringBoard(title, content, "
				+ "writer, regdate, hitcount, "
				+ "password) values(?, ?, ?, now(), 0, '1111')";
		
		//jdbcTemplate.update(sql, new PreparedSetter(board.getTitle(),
		//	board.getContent(), board.getWriter()));
		
		Object[] values = new Object[]{board.getTitle(), 
				board.getContent(), board.getWriter()};
		jdbcTemplate.update(sql, values);
		*/
		
		BoardManager.write(board);
	}
	
	/*
	class PreparedSetter implements PreparedStatementSetter{
		private String title, content, writer;
		
		public PreparedSetter(String t, String c, String w) {
			title = t;
			content = c;
			writer = w;
		}
		
		@Override
		public void setValues(PreparedStatement arg0) throws SQLException {
			arg0.setString(1, title);			
			arg0.setString(2, content);			
			arg0.setString(3, writer);
		}
	}
	*/
	
	@Override
	public Board findBySeq(int seq) throws SQLException {
		String sql = "select * from tblSpringBoard where seq=" + seq;
		
		// ResultSetExtractor
		
		Board board = (Board) jdbcTemplate.query(sql, new ResultSetExtractor(){
			@Override
			public Object extractData(ResultSet arg0) throws SQLException, DataAccessException {
				if(arg0.next()){
					Board board = new Board();
					board.setContent(arg0.getString("content"));
					board.setHitcount(arg0.getInt("hitcount"));
					board.setPassword(arg0.getString("password"));
					board.setRegdate(arg0.getString("regdate"));
					board.setSeq(arg0.getInt("seq"));
					board.setTitle(arg0.getString("title"));
					board.setWriter(arg0.getString("writer"));
					return board;
				}
				throw new DataRetrievalFailureException("해당 데이터 없다.");
			}
		});
		
		return board;
	}

	@Override
	public void update(Board board) throws SQLException {
		String sql = "update tblSpringBoard set title=?, writer=?, "
				+ "content=? where seq=?";
		
		Object[] val = new Object[]{board.getTitle(), 
			board.getWriter(), board.getContent(), board.getSeq()};
		jdbcTemplate.update(sql, val);
	}

	@Override
	public void delete(int seq) throws SQLException {
		// TODO Auto-generated method stub

	}

}
