package replyboard;

import java.util.List;

//데이터베이스에서 가장 기본이 되는 명령
//입력, 전체출력, 선택출력, 선택수정, 선택삭제
public interface BoardDAOInter {
	//기본적인 사항
	public int insert(BoardVO board); //입력
	public List<BoardVO> findAll();//전체출력
	public BoardVO findOneById(int idx);//선택출력
	public int update(int idx,BoardVO board);//선택수정
	public int delete(int idx);//선택삭제
	
	//추가적인사항
	public int replyInsert(BoardVO board); //댓글입력
	public int readcountup(int idx);
}

