package com.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.entity.Category;
import com.expensetracker.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository repo;

	public List<Category> findAll() {
		return repo.findAll();
	}

}
