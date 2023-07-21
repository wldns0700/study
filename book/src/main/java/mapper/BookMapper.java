package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import book.vo.BookVO;

//MemberMapper.java 인터페이스 파일은 MemberMapper.xml파일 이름이 동일한 xml을 만들어야함.
//@Param은 xml에 인자값을 전달하기 위한 수단이고 처음에만 정의하면 다시 정의할 필요 없음
public interface BookMapper {
	public int insert(@Param("book")BookVO book);
	public List<BookVO> findAll();
	public BookVO findOne(@Param("idx")int idx);
	public int update(@Param("idx")int idx, @Param("book")BookVO book);
	public int delete(int idx);
}
