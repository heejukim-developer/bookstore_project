package ezenproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ezenproject.dto.OrderDTO;



@Mapper
@Repository
public interface OrderDAO {
	public OrderDTO selectOne(int num);
}
