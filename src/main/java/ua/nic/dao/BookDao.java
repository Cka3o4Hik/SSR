package ua.nic.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.nic.entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDao implements BaseDao<Book> {

	private SessionFactory sessionFactory;

	@Autowired
	public BookDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int save(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public Book get(int id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public List<Book> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> root = cq.from(Book.class);
		cq.select(root);
		Query<Book> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(int id, Book book) {
		Session session = sessionFactory.getCurrentSession();
		Book book2 = session.byId(Book.class).load(id);
		book2.setName(book.getName());
		book2.setSeries(book.getSeries());
		book2.setIsbn(book.getIsbn());
		book2.setCreatedDate(book.getCreatedDate());
		book2.setPublisher(book.getPublisher());
		session.flush();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
	}


}
