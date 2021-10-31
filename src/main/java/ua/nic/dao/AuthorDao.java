package ua.nic.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.nic.entity.Author;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Set;

@Repository
public class AuthorDao implements BaseDao<Author> {

	private SessionFactory sessionFactory;

	@Autowired
	public AuthorDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Author save(Author author) {
		sessionFactory.getCurrentSession().save(author);
		return author;
	}

	@Override
	public Author get(Long id) {
		return sessionFactory.getCurrentSession().get(Author.class, id);
	}

	@Override
	public Set<Author> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Author> cq = cb.createQuery(Author.class);
		Root<Author> root = cq.from(Author.class);
		cq.select(root);
		Query<Author> query = session.createQuery(cq);
		return new HashSet<>(query.getResultList());
	}

	@Override
	public void update(Long id, Author author) {
		Session session = sessionFactory.getCurrentSession();
		Author author2 = session.byId(Author.class).load(id);
		author2.setFirstName(author.getFirstName());
		author2.setLastName(author.getLastName());
		author2.setBirth(author.getBirth());
		author2.setCreatedDate(author.getCreatedDate());
		author2.setEmail(author.getEmail());
		author2.setBooks(author.getBooks());
		session.flush();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Author author = session.byId(Author.class).load(id);
		session.delete(author);
	}
}
