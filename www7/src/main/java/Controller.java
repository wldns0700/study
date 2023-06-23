import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.text.AbstractDocument.Content;


//webapp에서 index.jsp파일이 존재할 경우 localhost:8080/접속을 해도
//우선순위가 webapp/index.jsp파일이므로 해당 컨트롤러는 실행이 되지 않음
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Controller() {
    	try {
    		
    //context.xml을 사용하기 위한 설정
       Context inicon = new InitialContext();
       Context envcon = (Context)inicon.lookup("jdbc:/comp/env");
       DataSource ds = (DataSource) envcon.lookup("jdbc/oracle");
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		System.out.println(uri);
		String page="index.jsp";
		HrdDAO dao=new HrdDAO();
		//모든 url주소는 해당 컨트롤러를 통해 접근을 할 수 있다.
		if(uri.equals("/index")) {
			page="index.jsp";
		}else if(uri.equals("/createMember")) {
			int i = dao.lastnum();
			request.setAttribute("last", i);
			page="createMember.jsp";
		}else if(uri.equals("/memberlist")) {
			List<MemberVO> list = dao.findAll();
			request.setAttribute("list", list);
			System.out.println(list.toString());
			page="memberlist.jsp";
		}else if(uri.equals("/sales")) {
			List<SaleVO> salelist = dao.sales();
			request.setCharacterEncoding("utf-8");
			request.setAttribute("sales", salelist);
			System.out.println(salelist.toString());
			page="sales.jsp";
		}else if(uri.equals("/createMember/proc")) {
			request.setCharacterEncoding("utf-8");
			//폼에 대한 입력처리
			//폼에 대한 입력처리는 전달되는 값을 모두 저장한 후 dao처리
			 int custno=Integer.parseInt(request.getParameter("custno"));
			 String custname=request.getParameter("custname");
			 String phone=request.getParameter("phone");
			 String address=request.getParameter("address");
			 String joindate=request.getParameter("joindate");
			 String grade=request.getParameter("grade");
			 String city=request.getParameter("city");
			 MemberVO member
			 =new MemberVO(custno, custname, phone, address, joindate, grade, city);
			 //DB처리를 위해 dao활용
			 int result=dao.insert(member);
			 request.setAttribute("result",result);
			 page="createMemberProc.jsp";
		}
		else if(uri.equals("/memberlist/update")) {
		int custno=Integer.parseInt(request.getParameter("custno"));
		//HrdDAO dao=new HrdDAO();
		MemberVO member=dao.findOne(custno);
		request.setAttribute("member",member);
		page="update.jsp";
		}
		else if(uri.equals("/memberlist/updateProc")) {
			request.setCharacterEncoding("utf-8");
			//폼에 대한 입력처리
			//폼에 대한 입력처리는 전달되는 값을 모두 저장한 후 dao처리
			 int custno=Integer.parseInt(request.getParameter("custno"));
			 String custname=request.getParameter("custname");
			 String phone=request.getParameter("phone");
			 String address=request.getParameter("address");
			 String joindate=request.getParameter("joindate");
			 String grade=request.getParameter("grade");
			 String city=request.getParameter("city");
			 MemberVO member
			 =new MemberVO(custno, custname, phone, address, joindate, grade, city);
			 //DB처리를 위해 dao활용
			 int result=dao.update(member);
			 request.setAttribute("result",result);
			 page="updateProc.jsp";
		}
	
	
		
		
		request.getRequestDispatcher("/WEB-INF/"+page)
		.forward(request, response);
	}

}





