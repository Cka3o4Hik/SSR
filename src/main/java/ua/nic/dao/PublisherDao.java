package ua.nic.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.nic.entity.Publisher;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Set;

@Repository
public class PublisherDao implements BaseDao<Publisher> {

	private SessionFactory sessionFactory;

	@Autowired
	public PublisherDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Publisher save(Publisher publisher) {
		sessionFactory.getCurrentSession().save(publisher);
		return publisher;
	}

	@Override
	public Publisher get(Long id) {
		return sessionFactory.getCurrentSession().get(Publisher.class, id);
	}

	@Override
	public Set<Publisher> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Publisher> cq = cb.createQuery(Publisher.class);
		Root<Publisher> root = cq.from(Publisher.class);
		cq.select(root);
		Query<Publisher> query = session.createQuery(cq);
		return new HashSet<>(query.getResultList());
	}

	@Override
	public void update(Long id, Publisher publisher) {
		Session session = sessionFactory.getCurrentSession();
		Publisher publisher2 = session.byId(Publisher.class).load(id);
		publisher2.setName(publisher.getName());
		publisher2.setCity(publisher.getCity());
		session.flush();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Publisher publisher = session.byId(Publisher.class).load(id);
		session.delete(publisher);
	}
}
