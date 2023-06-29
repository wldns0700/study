package replyboard;

import java.util.List;

public class BoardService {
	OracleBoardDAO dao=new OracleBoardDAO();
	public PageList pageList(int currentPage, int countPerPage) {
		/**********��ü�Խù���(dao), �������� ���� ��(���ް�) *****/		
		int totalCount = dao.totalCount(); //��ü �Խù� ��
		//int countPerPage = 10; //�������� ���� �� (���޹������� ����)
		/**********��ü��������(����)**********/
		int totalPage = 0; //��ü������ ��
		if(totalCount%countPerPage!=0) {
			totalPage=totalCount/countPerPage+1;
		}else {
			totalPage=totalCount/countPerPage;
		}
		/*********����������, ��������(����)******/
		int startPage = 0; //����������
		int endPage = 0; //��������
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
		/*********����������(���ް�), ���ǽ��۹�ȣ, ���ǳ���ȣ(����)*********/
		//int currentPage = 1; //����������
		int startRow = (currentPage - 1) * countPerPage + 1;//���� ���۹�ȣ
		int endRow = currentPage * countPerPage;//���� ����ȣ
		/*********�Խñ۸��(dao)***********/
		List<BoardVO> list=dao.pageList(currentPage, countPerPage);
		/***************************/
		//������ ���� ������ PageList��ü�� ��Ƽ� ����
		//��ü �Խù� ��, ����������Ǽ�, 
		//��ü������, ����������, ��������, ����������,
		//���ǽ��۹�ȣ,���ǳ���ȣ,�۸��
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
		return  pagelist;
	}
	public BoardVO findOneById(int idx) {
		dao.readcountUP(idx); //��ȸ��1����
		return dao.findOneById(idx);
	}
	public int insert(BoardVO board) {
		return dao.insert(board);
		
	}

}
