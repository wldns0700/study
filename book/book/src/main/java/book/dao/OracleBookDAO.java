package book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import book.vo.BookVO;

@Repository
public class OracleBookDAO implements BookDAO{

	Connection conn;
	
	public OracleBookDAO() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int insert(BookVO book) {
		try {
			String sql="insert into book values(book_idx_seq.nextval,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,book.getTitle());
			ps.setString(2,book.getContent());
			ps.setInt(3,book.getPrice());
			int result=ps.executeUpdate();
			ps.close();
			return result;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return 0;
	}

	@Override
	public List<BookVO> findAll() {
		try {
			String sql="select * from book order by idx desc";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			List<BookVO> list=new ArrayList<BookVO>();
			while(rs.next()) {
				list.add(
				new BookVO(rs.getInt("idx"), 
						   rs.getString("title"), 
						   rs.getString("content"),
						   rs.getInt("price")
						   )
				);
			}
			rs.close();
			ps.close();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BookVO findOneById(int idx) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(int idx, BookVO book) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int idx) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
