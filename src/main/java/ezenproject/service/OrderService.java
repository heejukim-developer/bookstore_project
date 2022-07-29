package ezenproject.service;

import java.util.List;

import ezenproject.dto.OrderDTO;

public interface OrderService {
	public OrderDTO selectOneProcess(int num);
	public void addOrderProcess(OrderDTO dto);

}
