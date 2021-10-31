package ua.nic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nic.entity.Author;
import ua.nic.dao.AuthorDao;

import java.util.Set;

@Service
@Transactional
public class AuthorService implements BaseService<Author> {

	private AuthorDao authorDao;

	@Autowired
	public AuthorService(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	@Override
	public Author save(Author author) {
		return authorDao.save(author);
	}

	@Override
	public Author get(Long id) {
		return authorDao.get(id);
	}

	@Override
	public Set<Author> getAll() {
		return authorDao.getAll();
	}

	@Override
	public void update(Long id, Author author) {
		authorDao.update(id, author);
	}

	@Override
	public void delete(Long id) {
		authorDao.delete(id);
	}
}
