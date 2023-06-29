import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//webapp에서 index.jsp파일이 존재할 경우 localhost:8080/접속을 해도
//우선순위가 webapp/index.jsp파일이므로 해당 컨트롤러는 실행이 되지 않음
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Controller() {
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		System.out.println(uri);
		String page="index.jsp";
		//모든 url주소는 해당 컨트롤러를 통해 접근을 할 수 있다.
		if(uri.equals("/index")) {
			page="index.jsp";
		}else if(uri.equals("/member")) {
			page="member.jsp";
		}else if(uri.equals("/memberlist")) {
			page="memberlist.jsp";
		}else if(uri.equals("/sales")) {
			page="sales.jsp";
		}else if(uri.equals("/createMember/proc")) {
			page="createMemberProc.jsp";
		}else if(uri.equals("/view/update")) {
			int custno=Integer.parseInt(request.getParameter("custno"));
			HrdDAO dao=new HrdDAO();
			dao.findOne(custno);
			
			request.setAttribute("custno",custno);
			page="update.jsp";
		}
		
		request.getRequestDispatcher("/WEB-INF/"+page)
		.forward(request, response);
	}

}





