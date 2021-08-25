package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

	@RequestMapping("/board")
	public ModelAndView selectAll() {
		System.out.println("전체게시글 조회 ... ");
		List<BoardVO> boardList =  service.selectAllBoard();
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list" , boardList);
		return mav;				
	}
	
	//public void selectByNo(HttpServletRequest request) {
	@RequestMapping("/board/detail")	
	public void selectByNo(@RequestParam("no") int no) {		
		System.out.println("no : " + no);		
	}
	
	@RequestMapping("/board/{no}")
	public ModelAndView selectByNo2(@PathVariable("no") int no) {
		System.out.println("no : "  + no);
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board" , new BoardVO() );
		return mav;
	}
	
	@GetMapping("/board/write")
	public String writeForm(Model model) {		
		model.addAttribute("boardVO", new BoardVO());		
		return "board/write";
	}
	
	@PostMapping("/board/write")
	//BoardVO 로 받아 오면 알아서 request 영역에 boardVO 로 등록이 된다
	public String write(@Valid BoardVO board , Errors error){
		System.out.println(error.hasErrors());

		System.out.println("post /board/write");
		System.out.println(board);
		
		if(error.hasErrors()) {
			
			System.out.println("오류 발생");
			return "board/write";
		}
		return "redirect:/board";		
	}
	
	
	
//	//@RequestMapping(value="/board/write", method = RequestMethod.GET)
//	@GetMapping("/board/write")
//	public String writeForm() {
//		return "board/write";
//	}
//	
//	//@RequestMapping(value="/board/write" , method=RequestMethod.POST)
//	@PostMapping("/board/write")
//	public String write(BoardVO board, Model model){
//		System.out.println("post /board/write");
//		System.out.println(board);
//		if(board.getTitle() == null || board.getTitle().equals("") ) {
//			model.addAttribute("board" , board);
//			return "board/write";
//		}
//		return "redirect:/board";		
//	}
	
	
	
	
}
