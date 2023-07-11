package book.dao;

import java.util.List;

import book.vo.BookVO;

public interface BookDAO {
	public int insert(BookVO book);
	public List<BookVO> findAll();
	public BookVO findOneById(int idx);
	public int update(int idx, BookVO book);
	public int delete(int idx);
}
