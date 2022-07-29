package ezenproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ezenproject.dao.OrderDAO;
import ezenproject.dto.OrderDTO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImp implements OrderService{

	
	@Autowired
	private OrderDAO dao;
	

	public OrderServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public OrderDTO selectOneProcess(int num) {
		
		
		return dao.selectOne(num);
	}
	
	@Override
	public void addOrderProcess(OrderDTO dto) {
	
		dao.addOrder(dto);
	}
}
