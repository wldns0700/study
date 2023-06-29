package replyboard;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardService service=new BoardService();
    
    public BoardController() {
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ�ó��
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//�ܺ��� �����ϴ� url�� �ּҸ� ������ ���ڿ��� �޴��Լ�
		String uri=request.getRequestURI();
		//�⺻������
		String page="pageList.jsp";
		System.out.println(uri);
		
		//pagelist		
		if(uri.equals("/pageList")) {
			int currentPage=1;
			//���޵Ǵ� ���� ���� ��� null�� �߻��Ѵ�.
			System.out.println(request.getParameter("currentPage"));
			
			if(request.getParameter("currentPage")!=null) {
				String _currentPage
				=request.getParameter("currentPage");
				if(!_currentPage.equals("")) {
					currentPage=Integer.parseInt(_currentPage);
				}
			}
			
			int countPerPage=10;
			PageList pagelist
			=service.pageList(currentPage, countPerPage);
			request.setAttribute("pagelist",pagelist);
			page="pageList.jsp";
			
		}else if(uri.equals("/findView")) {
			//location.href="/findView?idx="+idx;
			int idx=Integer.parseInt(request.getParameter("idx"));
			BoardVO board=service.findOneById(idx);
			request.setAttribute("board", board);
			page="findOne.jsp";

		}else if(uri.equals("/write")) {
			page="writeForm.jsp";
		}
	}
}