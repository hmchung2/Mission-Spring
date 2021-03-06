package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	public MemberVO login(MemberVO member) {
		// TODO Auto-generated method stub
		MemberVO userVO = memberDAO.login(member);
		return userVO;
	}

}
