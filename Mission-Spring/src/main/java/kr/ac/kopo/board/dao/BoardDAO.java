package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
	/*
	 * 전체게시글 조회
	 * @return DB에서 조회된 BoardVO List
	 */
	List<BoardVO> SelectAllBoard();
	
	
}
