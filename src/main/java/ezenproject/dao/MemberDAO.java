package ezenproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ezenproject.dto.MemberDTO;



@Mapper
@Repository
public interface MemberDAO {

	public MemberDTO selectOne(int num);
	public MemberDTO loginCheck(MemberDTO dto) throws DataAccessException;
}
