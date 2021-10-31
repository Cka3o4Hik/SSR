package ua.nic.service;

import java.util.Set;

public interface BaseService<T> {
	T save(T entity);

	T get(Long id);

	Set<T> getAll();

	void update(Long id, T entity);

	void delete(Long id);

}
