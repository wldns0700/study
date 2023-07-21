package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import book.vo.BookVO;

public interface BookMapperser {
	public int insert(@Param("book")BookVO book);
	public List<BookVO> findAll();
	public BookVO findOneById(@Param("idx")int idx);
	public int update(int idx, BookVO book);
	public int delete(int idx);
}
