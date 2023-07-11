package book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.dao.BookDAO;
import book.vo.BookVO;

@Service
public class BookService {
	
	@Autowired
	BookDAO dao;

	public int insert(BookVO bookVO) {
		return dao.insert(bookVO);
	}

	public List<BookVO> findAll() {
		return dao.findAll();
	}
	
}
