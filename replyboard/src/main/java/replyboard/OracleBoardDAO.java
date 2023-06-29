package replyboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OracleBoardDAO implements BoardDAOInter{
	//������ �����ؾ��� ����:
	//1.�����ͺ��̽� ���� �� pool �Ǵ� �̱����� ����
	//2.���̺귯�� �߰�(maven�� ���� ���̺귯�� ����)
	//3.@AutoWire�� �̿��Ͽ� ��ü����-spring���� ó��
	
	Connection conn; 

	public OracleBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* 
			 *�����߿�
			 */
			conn
			=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","test","1111");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	@Override
	//����� �ƴ� �۾���
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
					+ "?,0,'�ϹݰԽ���')";
			*/
			StringBuffer sql=new StringBuffer();
			sql.append("insert into board(idx,title,content,readcount,");
			sql.append("parentid, tab,");
			sql.append("writeid,writename,writeday,");
			sql.append("filename,isdel,kind)");
			sql.append(" values(board_idx_seq.nextval,?,?,0,");
			sql.append("0,0,");
			sql.append("?,?,sysdate,");
			sql.append("?,0,'�ϹݰԽ���')");
			
			PreparedStatement ps=conn.prepareStatement(sql.toString());
			ps.setString(1,board.getTitle());
			ps.setString(2,board.getContent());
			ps.setString(3,board.getWriteid());
			ps.setString(4,board.getWritename());
			ps.setString(5,board.getFilename()); //full��� or ���ϸ� ����
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

	@Override //BoardVO �ܺο� ��������, ����ó��, while->if, idx���޹��� �� ���, list�ʿ���»���
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
	//����Է�
	@Override //��Ʈ:����� parentid, tab(�θ��, ��۱���)�߿��� �κ�
	public int replyInsert(BoardVO board) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append("insert into board(idx,title,content,readcount,");
			sql.append("parentid, tab,");
			sql.append("writeid,writename,writeday,");
			sql.append("filename,isdel,kind)");
			sql.append(" values(board_idx_seq.nextval,?,?,0,");
			sql.append("?,?,");
			sql.append("?,?,sysdate,");
			sql.append("?,0,'�ϹݰԽ���')");
			
			PreparedStatement ps=conn.prepareStatement(sql.toString());
			ps.setString(1,board.getTitle());
			ps.setString(2,board.getContent());
			ps.setInt(3,board.getParentid());
			ps.setInt(4,board.getTab());
			ps.setString(5,board.getWriteid());
			ps.setString(6,board.getWritename());
			ps.setString(7,board.getFilename()); //full��� or ���ϸ� ����
			int result=ps.executeUpdate();
			ps.close();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<BoardVO> pageList(int currentPage,int countPerPage){
		try {
		int startRow = (currentPage - 1) * countPerPage + 1;//���� ���۹�ȣ
		int endRow = currentPage * countPerPage;//���� ����ȣ
		
		StringBuffer sql=new StringBuffer();
			sql.append("select rownum, t.* from ");
			sql.append("(select rownum r, t1.* from ");
			sql.append("(select * from board start with parentid=0 connect ");
			sql.append("by prior idx=parentid order siblings by idx desc) t1 ");
			sql.append("where rownum<=? order by rownum desc) t ");
			sql.append("where rownum<=? order by r asc");
		
		PreparedStatement ps=conn.prepareStatement(sql.toString());
		//ù��° ?�� �Խñ��� ������ ��ȣ�� �ǹ̸� �ϰ�
		//����� 10���� �Խù��� ������ �ǹǷ� �ι�° ?�� �������� �Խù��� �Է�
		ps.setInt(1, endRow);
		//�ι�° ?�� 10���ù��� 1page�̹Ƿ� ����� 10���� ���
		ps.setInt(2, countPerPage); 
		//Q.�������������� �Խù��� 10�� ���� �ʴ� ��� �ش�Խù��� ����ŭ �Է°��� ����
		//��)86���� �Խù��� �ִ� ���(��û�� �������� 9������ ��û, ���������� 9������)
		//2��° �Է��ϴ� ���� 6���� ���
		
		int totalPage=0;
		if(totalCount()%countPerPage!=0) {
			totalPage=totalCount()/countPerPage+1;
		}else {
			totalPage=totalCount()/countPerPage;
		}
		
		if(totalPage==currentPage) {
			ps.setInt(2, totalCount()%countPerPage);
		}
			
			
			
			
		ResultSet rs = ps.executeQuery();

		//*****BoardVO�� ����Ʈ�� ������ �� �ִ� ��ü(���ϰ�ü vo����)
		List<BoardVO> list=new ArrayList<BoardVO>();
		int i=0;
		while(rs.next()){
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
			list.add(new BoardVO(idx, title, content, readcount, parentid, tab, writeid, writename, writeday, filename, isdel, kind));
			System.out.println(i++);
		}
		ps.close();
		rs.close();
		return list;
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	//��ü�Խù��� Ȯ���ϴ� �Լ�
		public int totalCount() {
			int totalCount=0;
			//��ü�Խù� ��
			String sql = "select count(*) from board";
			try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				totalCount = rs.getInt("count(*)");
			}
			rs.close();
			ps.close();
			return totalCount;
			}catch(Exception e) {
				e.printStackTrace();
			}

			return totalCount;
		}

		@Override
		//��ȸ�� 1�����ϴ� �Լ�
		public int readcountUP(int idx) {
		try {
			
		String sql="update board set readcount=readcount+1 where idx=?";
			
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,idx);
		int result=ps.executeUpdate();
		ps.close();
		return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
			return 0;
	  }
}
