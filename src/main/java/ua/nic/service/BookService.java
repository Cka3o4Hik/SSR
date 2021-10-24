package ua.nic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nic.entity.Book;
import ua.nic.dao.BookDao;

import java.util.List;

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
	public int save(Book book) {
		return bookDao.save(book);
	}

	@Override
	public Book get(int id) {
		return bookDao.get(id);
	}

	@Override
	public List<Book> getAll() {
		return bookDao.getAll();
	}

	@Transactional
	@Override
	public void update(int id, Book book) {
		bookDao.update(id, book);
	}

	@Transactional
	@Override
	public void delete(int id) {
		bookDao.delete(id);
	}
}
