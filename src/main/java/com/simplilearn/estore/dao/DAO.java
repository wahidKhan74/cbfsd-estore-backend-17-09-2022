package com.simplilearn.estore.dao;

import java.util.List;

public interface DAO<T> {
	
	// Get all records
	List<T> getAll();
	
	// Get one record
	T getOne(long id);
	
	// Create a record
	void save(T obj);
	
	// Update a record
	void update(T obj);
	
	// Delete a record
	void delete(long id);
}
