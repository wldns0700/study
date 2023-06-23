import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HrdDAO {
Connection  con;

public HrdDAO() {
	try {
	//Class.forName("oracle.jdbc.OracleDriver");
	//con = DriverManager.getConnection
	// ("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		Connection conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:/pool");
	}catch(Exception e) {
		e.printStackTrace();
	}	
}

public MemberVO findOne(int custno) {
	try {
	String sql="select * from member_tbl_02 where custno=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, custno); //전달받은 값은 입력값으로 사용
	ResultSet rs=ps.executeQuery();

	//int custno=0;
	String custname=null;
	String phone=null;
	String address=null;
	String joindate=null;
	String grade=null;
	String city=null;

	if(rs.next()){
		custname=rs.getString("custname");
		phone=rs.getString("phone");
		address=rs.getString("address");
		joindate=rs.getString("joindate");
		grade=rs.getString("grade");
		city=rs.getString("city");
	}
	MemberVO member
	=new MemberVO(custno, custname, phone, address, joindate, grade, city);
	
	System.out.println(custname);
	rs.close();
	ps.close();
	//con.close();
	return member;
	}catch(Exception e) {
		e.printStackTrace();
	}
	return null;
	
}
	public List<SaleVO> sales(){
		try {
			String cno = null;
			String cname = null;
			String g = null;
			String s = null;
		String sql="select a.custno cno, a.custname cname, a.grade g,sum(b.price) s ";
		sql+="from member_tbl_02 a, money_tbl_02 b ";
		sql+="where a.custno=b.custno "; 
		sql+="group by (a.custno,a.custname,a.grade) order by s desc";
		List<SaleVO> list = new ArrayList<>();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			 if(rs.getString("g").charAt(0)=='A'){
				 g="VIP" ;
			 }
			 else if(rs.getString("g").charAt(0)=='B') {
				 g="일반" ;
			 }
			 else {
				 g="직원" ;
			 }
			SaleVO sale = new SaleVO(
			rs.getInt("cno"),
			rs.getString("cname"),
			g,
			rs.getInt("s")
			);
			list.add(sale);
		}
		
		return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MemberVO> findAll() {
		
		try {
			int custno = 0;
			String custname=null;
			String phone=null;
			String address=null;
			String joindate=null;
			String grade=null;
			String city=null;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		//custno,custname,phone,address,joindate,grade,city
		String sql="select * from member_tbl_02";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<MemberVO> list = new ArrayList<MemberVO>();
		while(rs.next()){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(rs.getString("joindate"));
			System.out.println(sdf.format(date));
			 if(rs.getString("grade").charAt(0)=='A'){
				 grade="VIP" ;
			 }
			 else if(rs.getString("grade").charAt(0)=='B') {
				 grade="일반" ;
			 }
			 else {
				 grade="직원" ;
			 }
			 
			 MemberVO member
				=new MemberVO(
			 rs.getInt("custno"),
			 rs.getString("custname"),
			 rs.getString("phone"),
			rs.getString("address"),
			rs.getString("joindate"),
			grade,
			rs.getString("city"));
			 list.add(member);
		}
		
				return list;
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public int insert(MemberVO member) {
		try {
		String sql="insert into member_tbl_02 values(?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,member.getCustno());
		ps.setString(2, member.getCustname());
		ps.setString(3, member.getPhone());
		ps.setString(4, member.getAddress());
		ps.setString(5, member.getJoindate());
		ps.setString(6, member.getGrade());
		ps.setString(7, member.getCity());
		int result=ps.executeUpdate();
		return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int lastnum() {
		try {
		String sql="select max(custno) from member_tbl_02";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		int custno=0; //마지막회번호
		if(rs.next()){
			custno=rs.getInt("max(custno)");
		}
		return custno;
		}catch (Exception e) {
				e.printStackTrace();
			
		}
		return 0;
	}

	public int update(MemberVO member) {
		try {
			String sql="update member_tbl_02 set custname=?,phone=?,address=?,joindate=?,grade=?,city=? where custno=?";
			PreparedStatement ps=con.prepareStatement(sql);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
			ps.setString(1, member.getCustname());
			ps.setString(2, member.getPhone());
			ps.setString(3, member.getAddress());
			ps.setString(4, member.getJoindate());
			ps.setString(5, member.getGrade());
			ps.setString(6, member.getCity());
			ps.setInt(7,member.getCustno());
			int result=ps.executeUpdate();
			ps.close();
			//con.close();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
		
	}

