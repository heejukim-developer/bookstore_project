package ezenproject.service;

import java.util.List;

import ezenproject.dto.BookDTO;
import ezenproject.dto.PageDTO;

public interface BookService {

	public int countProcess(); 
	public BookDTO selectOneProcess(int num);
	

}
