package replyboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OracleBoardDAO implements BoardDAOInter{
	//앞으로 구현해야할 사항:
	//1.데이터베이스 접속 시 pool 또는 싱글톤을 적용
	//2.라이브러리 추가(maven을 통해 라이브러리 관리)
	//3.@AutoWire를 이용하여 객체주입-spring에서 처리
	
	Connection conn; 

	public OracleBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* 
			 *계정중요
			 */
			conn
			=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","test","1111");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	@Override
	//댓글이 아닌 글쓰기
	public int insert(BoardVO board) {
		try {
			/*
			String sql="insert into board(idx,title,content,readcount,"
					+ "parentid, tab,"
					+ "writeid,writename,writeday,"
					+ "filename,isdel,kind)"
					+ " values(board_idx_seq.nextval,?,?,0,"
					+ "0,0,"
					+ "?,?,sysdate,"
					+ "?,0,'일반게시판')";
			*/
			StringBuffer sql=new StringBuffer();
			sql.append("insert into board(idx,title,content,readcount,");
			sql.append("parentid, tab,");
			sql.append("writeid,writename,writeday,");
			sql.append("filename,isdel,kind)");
			sql.append(" values(board_idx_seq.nextval,?,?,0,");
			sql.append("0,0,");
			sql.append("?,?,sysdate,");
			sql.append("?,0,'일반게시판')");
			
			PreparedStatement ps=conn.prepareStatement(sql.toString());
			ps.setString(1,board.getTitle());
			ps.setString(2,board.getContent());
			ps.setString(3,board.getWriteid());
			ps.setString(4,board.getWritename());
			ps.setString(5,board.getFilename()); //full경로 or 파일명 선택
			int result=ps.executeUpdate();
			ps.close();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<BoardVO> findAll() {
		try {
			String sql="select * from board";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			List<BoardVO> list=new ArrayList<BoardVO>();
			while(rs.next()) {
				int idx=rs.getInt("idx");
				String title=rs.getString("title");
				String content=rs.getString("content");;
				int readcount=rs.getInt("readcount");
				int parentid=rs.getInt("parentid");
				int tab=rs.getInt("tab");
				String writeid=rs.getString("writeid");
				String writename=rs.getString("writename");
				Date writeday=rs.getDate("writeday");
				String filename=rs.getString("filename");
				int isdel=rs.getInt("isdel");
				String kind=rs.getString("kind");
				BoardVO board
				=new BoardVO(idx, title, content, readcount, parentid, tab, writeid, writename, writeday, filename, isdel, kind);
				list.add(board);
			}
			rs.close();
			ps.close();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override //BoardVO 외부에 변수설정, 조건처리, while->if, idx전달받은 것 사용, list필요없는사항
	public BoardVO findOneById(int idx) {
		try {
			String sql="select * from board where idx=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, idx);
			ResultSet rs=ps.executeQuery();
			BoardVO board=null;
			if(rs.next()) {
				//int idx=rs.getInt("idx");
				String title=rs.getString("title");
				String content=rs.getString("content");;
				int readcount=rs.getInt("readcount");
				int parentid=rs.getInt("parentid");
				int tab=rs.getInt("tab");
				String writeid=rs.getString("writeid");
				String writename=rs.getString("writename");
				Date writeday=rs.getDate("writeday");
				String filename=rs.getString("filename");
				int isdel=rs.getInt("isdel");
				String kind=rs.getString("kind");
				board
				=new BoardVO(idx, title, content, readcount, parentid, tab, writeid, writename, writeday, filename, isdel, kind);
			}
			rs.close();
			ps.close();
			return board;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(int idx, BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idx) {
		try {
			String sql="delete from board where idx=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, idx);
			int result=ps.executeUpdate();
			ps.close();
			return result;			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//댓글입력
	@Override
	public int replyInsert(BoardVO board) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append("insert into board(idx,title,content,readcount,");
			sql.append("parentid, tab,");
			sql.append("writeid,writename,writeday,");
			sql.append("filename,isdel,kind)");
			sql.append(" values(board_idx_seq.nextval,?,?,0,");
			sql.append("0,0,");
			sql.append("?,?,sysdate,");
			sql.append("?,0,'일반게시판')");
			
			PreparedStatement ps=conn.prepareStatement(sql.toString());
			ps.setString(1,board.getTitle());
			ps.setString(2,board.getContent());
			ps.setString(3,board.getWriteid());
			ps.setString(4,board.getWritename());
			ps.setString(5,board.getFilename()); //full경로 or 파일명 선택
			int result=ps.executeUpdate();
			ps.close();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
