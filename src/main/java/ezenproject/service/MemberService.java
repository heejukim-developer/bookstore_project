package ezenproject.service;

import javax.servlet.http.HttpSession;

import ezenproject.dto.MemberDTO;

public interface MemberService {

	
	public MemberDTO Login(MemberDTO memberDTO) throws Exception;

	//2번째방법
	//public boolean loginCheck(MemberDTO dto, HttpSession session);
}
