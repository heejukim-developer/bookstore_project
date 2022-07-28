package ezenproject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ezenproject.dto.BookDTO;


@Mapper
@Repository
public interface BookDAO {
	public int count();
	public BookDTO selectOne(int num);
	public List<BookDTO> list();
}
