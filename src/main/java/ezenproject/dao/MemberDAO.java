package ezenproject.dao;

import org.apache.ibatis.annotations.Mapper;


import org.springframework.stereotype.Repository;
import ezenproject.dto.MemberDTO;



@Mapper
@Repository
public interface MemberDAO {

	
	public MemberDTO loginMember(MemberDTO memberDTO)throws Exception;
	//public boolean loginCheck(MemberDTO dto);
}
