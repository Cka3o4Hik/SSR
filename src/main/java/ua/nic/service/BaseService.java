package ua.nic.service;

import java.util.List;

public interface BaseService<T> {
	T save(T entity);

	T get(int id);

	List<T> getAll();

	void update(int id, T entity);

	void delete(int id);

}
