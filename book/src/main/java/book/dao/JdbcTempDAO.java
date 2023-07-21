package book.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import book.dao.BookMapperser;
import book.vo.BookVO;



public class JdbcTempDAO implements BookMapperser{
	ApplicationContext app = new ClassPathXmlApplicationContext("book/dao/dbconfig.xml");
	JdbcTemplate jt=(JdbcTemplate) app.getBean("jdbcTemplate");
	String sql;
	@Override
	public int insert(BookVO book) {
		sql="insert into book values(book_idx_seq.nextval,?,?,?)";
		int result = jt.update(sql,book.getTitle(),book.getContent(),book.getPrice());
		return result;
	}

	@Override
	public List<BookVO> findAll() {
		sql="select *from book";
		List<BookVO>list = jt.query(sql,new BookMapperold());
		return list;
	}

	@Override
	public BookVO findOneById(int idx) {
		sql="select *from book where idx=?";
		BookVO book= new BookVO();
		book=(BookVO) jt.queryForObject(sql,new Object[] {idx},new BookMapperold());
		
		return book;
	}

	@Override
	public int update(int idx, BookVO book) {
		sql="update book set title =?,content=?,price=? where idx=?";
		int result = jt.update(sql,book.getTitle(),book.getContent(),book.getPrice(),idx);
		return result;
	}

	@Override
	public int delete(int idx) {
		sql="delete book where idx = ?";
		int result = jt.update(sql,idx);
		return result;
	}

}
