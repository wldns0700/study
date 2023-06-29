import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HrdDAO {
Connection  con;

public HrdDAO() {
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	con = DriverManager.getConnection
	 ("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
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





}
