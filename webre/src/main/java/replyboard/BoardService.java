package replyboard;

import java.util.List;

public class BoardService {
	OracleBoardDAO dao=new OracleBoardDAO();
	public PageList pageList(int currentPage, int countPerPage) {
		/**********전체게시물수(dao), 페이지당 글의 수(전달값) *****/		
		int totalCount = dao.totalCount(); //전체 게시물 수
		//int countPerPage = 10; //페이지당 글의 수 (전달받은값에 있음)
		/**********전체페이지수(연산)**********/
		int totalPage = 0; //전체페이지 수
		if(totalCount%countPerPage!=0) {
			totalPage=totalCount/countPerPage+1;
		}else {
			totalPage=totalCount/countPerPage;
		}
		/*********시작페이지, 끝페이지(연산)******/
		int startPage = 0; //시작페이지
		int endPage = 0; //끝페이지
		if ((currentPage / 5) < 2) {
		    startPage = 1;
		    endPage = startPage + 4;
		    if ((currentPage % 5) != 0) {
		        startPage = (currentPage / 5) * 5 + 1;
		        endPage = Math.min(startPage + 4, totalPage);
		    }
		} else {
		    startPage = (currentPage / 5) * 5 + 1;
		    endPage = Math.min(startPage + 4, totalPage);
		}
		/*********현재페이지(전달값), 글의시작번호, 글의끝번호(연산)*********/
		//int currentPage = 1; //현재페이지
		int startRow = (currentPage - 1) * countPerPage + 1;//글의 시작번호
		int endRow = currentPage * countPerPage;//글의 끝번호
		/*********게시글목록(dao)***********/
		List<BoardVO> list=dao.pageList(currentPage, countPerPage);
		/***************************/
		//위에서 구한 내용을 PageList객체에 담아서 전송
		PageList pagelist=new PageList();
		pagelist.setTotalCount(totalCount);
		pagelist.setCountPerPage(countPerPage);
		pagelist.setTotalPage(totalPage);
		pagelist.setStartPage(startPage);
		pagelist.setEndPage(endPage);
		pagelist.setCurrentPage(currentPage);
		pagelist.setStartRow(startRow);
		pagelist.setEndRow(endRow);
		pagelist.setList(list);
		
		return pagelist;
	}
	public BoardVO findone(int idx) {
		dao.findOneById(idx);
		return dao.findOneById(idx);
	}
	public PageList serpage(String kind, String ser,int currentPage, int countPerPage) {
		/**********전체게시물수(dao), 페이지당 글의 수(전달값) *****/		
		int totalCount = dao.totalCount(); //전체 게시물 수
		//int countPerPage = 10; //페이지당 글의 수 (전달받은값에 있음)
		/**********전체페이지수(연산)**********/
		int totalPage = 0; //전체페이지 수
		if(totalCount%countPerPage!=0) {
			totalPage=totalCount/countPerPage+1;
		}else {
			totalPage=totalCount/countPerPage;
		}
		/*********시작페이지, 끝페이지(연산)******/
		int startPage = 0; //시작페이지
		int endPage = 0; //끝페이지
		if ((currentPage / 5) < 2) {
		    startPage = 1;
		    endPage = startPage + 4;
		    if ((currentPage % 5) != 0) {
		        startPage = (currentPage / 5) * 5 + 1;
		        endPage = Math.min(startPage + 4, totalPage);
		    }
		} else {
		    startPage = (currentPage / 5) * 5 + 1;
		    endPage = Math.min(startPage + 4, totalPage);
		}
		/*********현재페이지(전달값), 글의시작번호, 글의끝번호(연산)*********/
		//int currentPage = 1; //현재페이지
		int startRow = (currentPage - 1) * countPerPage + 1;//글의 시작번호
		int endRow = currentPage * countPerPage;//글의 끝번호
		/*********게시글목록(dao)***********/
		List<BoardVO> list=dao.find(kind, ser,currentPage, countPerPage);
		/***************************/
		//위에서 구한 내용을 PageList객체에 담아서 전송
		PageList pagelist=new PageList();
		pagelist.setTotalCount(totalCount);
		pagelist.setCountPerPage(countPerPage);
		pagelist.setTotalPage(totalPage);
		pagelist.setStartPage(startPage);
		pagelist.setEndPage(endPage);
		pagelist.setCurrentPage(currentPage);
		pagelist.setStartRow(startRow);
		pagelist.setEndRow(endRow);
		pagelist.setList(list);
		pagelist.setSer(ser);
		pagelist.setKind(kind);
		
		return pagelist;
	}
	public void readcountup(int idx) {
		dao.readcountup(idx);
		
	}
	public int insert(BoardVO vo) {
		return dao.insert(vo);
		
		
		
		// TODO Auto-generated method stub
		
	}
	
}


