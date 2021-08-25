package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
		
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardVO> SelectAllBoard() {
		// TODO Auto-generated method stub
		List<BoardVO> list = sqlSessionTemplate.selectList("board.BoardDAO.selectAll");		
		return list;
	}

}
