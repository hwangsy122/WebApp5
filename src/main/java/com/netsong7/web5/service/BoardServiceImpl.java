package com.netsong7.web5.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.netsong7.web5.domain.Board;
import com.netsong7.web5.persistence.BoardDao;

@Component("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;

	@Override
	public List getList() throws SQLException {
		return boardDao.getList();
	}

	@Override
	public void write(Board board) throws SQLException {
		boardDao.write(board);
	}

	@Override
	public Board findBySeq(int seq) throws SQLException {
		return boardDao.findBySeq(seq);
	}

	@Override
	public void update(Board board) throws SQLException {
		boardDao.update(board);
	}

	@Override
	public void delete(int seq) throws SQLException {
		// TODO Auto-generated method stub

	}

}
