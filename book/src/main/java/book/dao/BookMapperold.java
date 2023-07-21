package book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import book.vo.BookVO;


public class BookMapperold implements RowMapper {


	@Override
	public BookVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookVO book = new BookVO();
		book.setIdx(rs.getInt("idx"));
		book.setTitle(rs.getString("title"));
		book.setContent(rs.getString("content"));
		book.setPrice(rs.getInt("price"));
		return book;
	}
	
}
