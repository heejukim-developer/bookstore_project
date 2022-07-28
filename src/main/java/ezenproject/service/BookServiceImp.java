package ezenproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ezenproject.dao.BookDAO;
import ezenproject.dto.BookDTO;
import ezenproject.dto.PageDTO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImp implements BookService{

	
	
	@Autowired
	private BookDAO dao;
	
public BookServiceImp() {
		
	}
	@Override
	public int countProcess() {
		// TODO Auto-generated method stub
		return dao.count();
	}
	
	@Override
	public BookDTO selectOneProcess(int num) {
		
		
		return dao.selectOne(num);
	}
}
