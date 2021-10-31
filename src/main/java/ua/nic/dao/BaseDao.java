package ua.nic.dao;

import ua.nic.entity.Book;

import java.util.Set;

public interface BaseDao<T> {
	T save(T entity);

	T get(Long id);

	Set<T> getAll();

	void update(Long id, T entity);

	void delete(Long id);
}
