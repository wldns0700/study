package replyboard;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



@WebServlet("/")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardService service=new BoardService();
    OracleBoardDAO dao = new OracleBoardDAO();
    public BoardController() {
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//외부의 접속하는 url중 주소를 제외한 문자열을 받는함수
		String uri=request.getRequestURI();
		int currentPage= 1;
		String kind=request.getParameter("kind");
		String ser = request.getParameter("search");
		//기본페이지
		
		if(request.getParameter("currentPage")!=null) {
			String  _currentPage=request.getParameter("currentPage");
			if(!_currentPage.equals("")) {
			currentPage=Integer.parseInt(_currentPage);
			}
		}
		String page="pageList.jsp";
		System.out.println(uri);
				
		if(uri.equals("/pageList")) {
			int countPerPage=10;
			PageList pagelist=service.pageList(currentPage, countPerPage);
			request.setAttribute("pagelist", pagelist);
			page="pageList.jsp";
		}
		else if (uri.equals("/findOne")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			BoardVO findone = service.findone(idx); 
			service.readcountup(idx);
			request.setAttribute("findone", findone);
			page="findOne.jsp";
		}
		else if (uri.equals("/writeForm")) {
			page="writeForm.jsp";
		}
		else if (uri.equals("/serlist")) {
			int countPerPage=10;
			switch (kind) {
			case "제목": {
				kind = "title";
			break;	
			}
			case "글쓴이":{
				kind = "writename";
				break;
			}
			case "날짜":{
				kind = "writdat";
				break;
			}
			}
			System.out.println(kind);
			PageList pagelist = service.serpage(kind,ser,currentPage,countPerPage); 
			
			request.setAttribute("pagelist", pagelist);
			page="serlist.jsp";
		}
			else if (uri.equals("/write")) {
				BoardVO insert = new BoardVO();
			MultipartRequest multi=new MultipartRequest(
						request,
						"C:\\Users\\admin\\eclipse-workspace\\Testweb\\src\\main\\webapp\\img",
						1024*1024*5,
						new DefaultFileRenamePolicy()
						); 
			Enumeration<?> files=multi.getFileNames();
			String orginfilename = null;
			while(files.hasMoreElements()){
			String tagname=(String)files.nextElement();
			orginfilename=multi.getOriginalFileName(tagname);
			}
			String writename = multi.getParameter("writeName");
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			insert.setWritename(writename);
			insert.setTitle(title);
			insert.setContent(content);
			insert.setFilename(orginfilename);
			insert.setWriteid("user552");
			service.insert(insert);
			page = "pageList.jsp";
			}
				
			
		
		
		
		
		//Dispatcher:보내기,발송
		//request:요청한데이터를 저장하는 공간(객체)
		//입력값인 page로 보내겠다.
		//request객체에 저장된내용과 response객체에 담긴 내용을 같이 보내겠다.
		request.getRequestDispatcher("/WEB-INF/"+page)
		.forward(request, response);
		
	}

}
