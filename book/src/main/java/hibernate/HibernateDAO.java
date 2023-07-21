package hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import book.vo.BookVO;

public class HibernateDAO implements Hiberinter{
	@Autowired
	Session session;
	GetSession getsession = new GetSession();
	

	@Override
	public int insert(BookVO book) {
		session=getsession.getsesson();
	
		int result = (Integer)session.save(book);
		session.getTransaction().commit();
		return result;
	}

	@Override
	public List<BookVO> findAll() {
		List<BookVO> book = (List<BookVO>) session.get(BookVO.class, session);
		return null;
	}

	@Override
	public BookVO findOneById(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int idx, BookVO book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
