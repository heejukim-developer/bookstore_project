package ezenproject.service;

import ezenproject.dto.MemberDTO;

public interface MemberService {

	public MemberDTO selectOneProcess(int num);
	public MemberDTO memberLogin(MemberDTO dto) throws Exception;
}
