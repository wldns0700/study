package book.service;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import book.dao.BookMapperser;
import book.dao.JdbcTempDAO;
import book.dao.OracleBookDAO;
import book.vo.BookVO;
import mapper.BookMapper;

public class BookService implements BookMapperser{
	

	BookMapper mapper;


	public int insert(@Param("book")BookVO book) {
		int result = mapper.insert(book);
		return result;
	}


	public List<BookVO> findAll() {
		List<BookVO> list = mapper.findAll();
		return list;
	}


	public BookVO findOneById(int idx) {
		
		return mapper.findOne(idx);
	}

	public int update(int idx, @Param("book")BookVO book) {
		int result = mapper.update(idx,book);
		return result;
	}


	public int delete(int idx) {
		int result = mapper.delete(idx);
		return result;
	}

	
}
