package ezenproject.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ezenproject.dao.MemberDAO;
import ezenproject.dto.MemberDTO;

@Service
@Transactional(propagation = Propagation.REQUIRED)

public class MemberServiceImp implements MemberService{

	
	@Autowired
	private MemberDAO dao;
	
	public MemberServiceImp() {
		
	}
	
	@Override
	public MemberDTO Login(MemberDTO memberDTO) throws Exception {
		return dao.loginMember(memberDTO);
		
	}

//  2번째방법
//	@Override
//	public boolean loginCheck(MemberDTO dto, HttpSession session) {
//		boolean result = dao.loginCheck(dto);
//		if(result) {
//			
//			session.setAttribute("member_id", dto.getMember_id());
//			session.setAttribute("member_pass", dto.getMember_pass());
//		}
//		return result;
//	}
	
}

