package ua.nic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nic.entity.Book;
import ua.nic.dao.BookDao;

import java.util.Set;

@Service
@Transactional
public class BookService implements BaseService<Book> {


	private BookDao bookDao;

	@Autowired
	public BookService(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	/*@Autowired
	private BookDao bookDao;*/

	@Transactional
	@Override
	public Book save(Book book) {
		return bookDao.save(book);
	}

	@Override
	public Book get(Long id) {
		return bookDao.get(id);
	}

	@Override
	public Set<Book> getAll() {
		return bookDao.getAll();
	}

	@Transactional
	@Override
	public void update(Long id, Book book) {
		bookDao.update(id, book);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		bookDao.delete(id);
	}
}
