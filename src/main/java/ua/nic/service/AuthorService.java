package ua.nic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nic.entity.Author;
import ua.nic.dao.AuthorDao;

import java.util.List;

@Service
@Transactional
public class AuthorService implements BaseService<Author> {

	private AuthorDao authorDao;

	@Autowired
	public AuthorService(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	@Override
	public int save(Author author) {
		return authorDao.save(author);
	}

	@Override
	public Author get(int id) {
		return authorDao.get(id);
	}

	@Override
	public List<Author> getAll() {
		return authorDao.getAll();
	}

	@Override
	public void update(int id, Author author) {
		authorDao.update(id, author);
	}

	@Override
	public void delete(int id) {
		authorDao.delete(id);
	}
}
