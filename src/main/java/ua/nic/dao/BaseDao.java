package ua.nic.dao;

import ua.nic.entity.Book;

import java.util.List;

public interface BaseDao<T> {
	T save(T entity);

	T get(int id);

	List<T> getAll();

	void update(int id, T entity);

	void delete(int id);
}
