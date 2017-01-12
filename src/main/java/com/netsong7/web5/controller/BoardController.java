package com.netsong7.web5.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netsong7.web5.domain.Board;
import com.netsong7.web5.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/list.board")
	public ModelAndView listAll() throws SQLException{
		ModelAndView mv = new ModelAndView("board/list");
		mv.addObject("board", boardService.getList());
		System.out.println(boardService.getList().size());
		return mv;
	}
	
	@RequestMapping(value="/write.board", method=RequestMethod.GET)
	public String write(){
		return "board/write";
	}
	
	@RequestMapping(value="/write.board", method=RequestMethod.POST)
	public String write_complete(Board board) throws SQLException{
		boardService.write(board);
		return "redirect:list.board";
	}
	
	@RequestMapping("/read.board")
	public ModelAndView read(int seq) throws SQLException{
		ModelAndView mv = new ModelAndView("board/read");
		Board board = boardService.findBySeq(seq);
		mv.addObject("board", board);
		return mv;
	}
	
	@RequestMapping(value="/update.board", method=RequestMethod.GET)
	public ModelAndView update(int seq) throws SQLException{
		ModelAndView mv = new ModelAndView("board/update");
		Board board = boardService.findBySeq(seq);
		mv.addObject("board", board);
		return mv;
	}
	
	@RequestMapping(value="/update.board", method=RequestMethod.POST)
	public String update_complete(Board board) throws SQLException{
		boardService.update(board);
		return "redirect:list.board";
	}
}







