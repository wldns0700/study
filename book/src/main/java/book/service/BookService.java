package book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.dao.BookDAO;
import book.dao.OracleBookDAO;
import book.vo.BookVO;

@Service
public class BookService {
	
	@Autowired
	OracleBookDAO dao;

	public int insert(BookVO bookVO) {
		return dao.insert(bookVO);
	}

	public List<BookVO> findAll() {
		return dao.findAll();
	}

	public BookVO findOne(int idx) {
		
		return dao.findOneById(idx);
	}

	public int update(int idx,BookVO bookVO) {
		
		return dao.update(idx,bookVO);
	}

	public int del(int idx) {
		
		return dao.delete(idx);
	}
	
}
