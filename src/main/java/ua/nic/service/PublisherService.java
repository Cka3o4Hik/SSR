package ua.nic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nic.dao.BaseDao;
import ua.nic.entity.Publisher;

import java.util.Set;


@Service
@Transactional
public class PublisherService implements BaseService<Publisher> {

	private BaseDao<Publisher> publisherDao;

	@Autowired
	public PublisherService(BaseDao<Publisher> publisherDao) {
		this.publisherDao = publisherDao;
	}


	@Override
	public Publisher save(Publisher publisher) {
		return publisherDao.save(publisher);
	}

	@Override
	public Publisher get(Long id) {
		return publisherDao.get(id);
	}

	@Override
	public Set<Publisher> getAll() {
		return publisherDao.getAll();
	}

	@Override
	public void update(Long id, Publisher publisher) {
		publisherDao.update(id, publisher);
	}

	@Override
	public void delete(Long id) {
		publisherDao.delete(id);
	}
}
