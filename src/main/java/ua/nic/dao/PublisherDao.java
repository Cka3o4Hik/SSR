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
import java.util.List;

@Repository
public class PublisherDao implements BaseDao<Publisher> {

	private SessionFactory sessionFactory;

	@Autowired
	public PublisherDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int save(Publisher publisher) {
		sessionFactory.getCurrentSession().save(publisher);
		return publisher.getId();
	}

	@Override
	public Publisher get(int id) {
		return sessionFactory.getCurrentSession().get(Publisher.class, id);
	}

	@Override
	public List<Publisher> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Publisher> cq = cb.createQuery(Publisher.class);
		Root<Publisher> root = cq.from(Publisher.class);
		cq.select(root);
		Query<Publisher> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(int id, Publisher publisher) {
		Session session = sessionFactory.getCurrentSession();
		Publisher publisher2 = session.byId(Publisher.class).load(id);
		publisher2.setName(publisher.getName());
		publisher2.setCity(publisher.getCity());
		session.flush();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Publisher publisher = session.byId(Publisher.class).load(id);
		session.delete(publisher);
	}
}
