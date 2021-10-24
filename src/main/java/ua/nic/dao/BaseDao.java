package ua.nic.dao;

import java.util.List;

public interface BaseDao<T> {
	int save(T entity);

	T get(int id);

	List<T> getAll();

	void update(int id, T entity);

	void delete(int id);
}
