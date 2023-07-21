package hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import book.vo.BookVO;

public interface Hiberinter {
	public int insert(BookVO book);
	public List<BookVO> findAll();
	public BookVO findOneById(int idx);
	public int update(int idx, BookVO book);
	public int delete(int idx);
}
