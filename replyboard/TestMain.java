package replyboard;

import java.util.List;

public class TestMain {
	//주의사항: main함수를 실행할 때 lib에 라이브러리를 넣는다.
	public static void main(String[] args) {
		//board 입력테스트
		/*
		BoardVO board=new BoardVO();
		board.setTitle("dao test중");
		board.setContent("dao를 작성중에 있습니다.");
		board.setWriteid("admin");
		board.setWritename("길동이");
		board.setFilename("a.txt");
		int result=new OracleBoardDAO().insert(board);
		System.out.println(result);
		
		
		StringBuffer sql=new StringBuffer();
		sql.append("insert into board(idx,title,content,readcount,");
		sql.append("parentid, tab,");
		sql.append("filename,isdel,kind)");
		sql.append(" values(board_idx_seq.nextval,?,?,0,");
		sql.append("0,0,");
		sql.append("?,?,sysdate,");
		sql.append("?,0,'일반게시판')");
		
		System.out.println(sql);
		*/
		
		//List<BoardVO> list=new OracleBoardDAO().findAll();
		//System.out.println(list);
		
		System.out.println(new OracleBoardDAO().findOneById(1));
		
		
	}

}
