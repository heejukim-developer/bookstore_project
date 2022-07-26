package ezenproject.service;

import java.util.List;

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
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public MemberDTO memberLogin(MemberDTO dto) throws Exception {
		
		return dao.loginCheck(dto);
	}
	
	
	
	
}

