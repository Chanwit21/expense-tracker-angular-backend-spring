package com.expensetracker.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expensetracker.dto.ExpensesResponst;
import com.expensetracker.entity.Expense;
import com.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	ExpenseRepository repo;

	public Expense findOne(Integer id) {
		return repo.findById(id).get();
	}

	public Expense creatExpense(Expense e) {
		return repo.save(e);
	}

	public Expense updateExpense(Integer id, Expense e) {
		Expense eUpdateExpense = repo.findById(id).get();
		eUpdateExpense.setAmount(e.getAmount());
		eUpdateExpense.setCategory(e.getCategory());
		eUpdateExpense.setComment(e.getComment());
		eUpdateExpense.setDate(e.getDate());
		eUpdateExpense.setId(id);
		eUpdateExpense.setPayee(e.getPayee());
		eUpdateExpense.setUpdateAtDateTime(LocalDateTime.now());
		return repo.save(e);
	}

	public ResponseEntity<?> delExpense(Integer id) {
		repo.deleteById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Delete user successful");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	public ExpensesResponst findByQueryAll(String search, Integer offset, Integer limit, String month, String year) {
		List<Expense> list = repo.findByQueryAll(search, month, year, offset, limit);
		Integer count = repo.countFindByQueryAll(search, month, year);
		System.out.println(count);
		ExpensesResponst expensesReaponst = new ExpensesResponst(list, count);
		return expensesReaponst;
	}

	public ExpensesResponst findByQueryNoMonthNoYear(String search, Integer offset, Integer limit) {
		List<Expense> list = repo.findByQueryNoMonthNoYear(search, offset, limit);
		Integer count = repo.countFindByQueryNoMonthNoYear(search, offset, limit);
		ExpensesResponst expensesReaponst = new ExpensesResponst(list, count);
		System.out.println(expensesReaponst);
		return expensesReaponst;
	}

	public ExpensesResponst findByQueryMonth(String search, Integer offset, Integer limit, String month) {
		List<Expense> list = repo.findByQueryMonth(search, month, offset, limit);
		Integer count = repo.countFindByQueryMonth(search, month);
		ExpensesResponst expensesReaponst = new ExpensesResponst(list, count);
		return expensesReaponst;
	}

	public ExpensesResponst findByQueryYear(String search, Integer offset, Integer limit, String year) {
		List<Expense> list = repo.findByQueryYear(search, year, offset, limit);
		Integer count = repo.countFindByQueryYear(search, year);
		ExpensesResponst expensesReaponst = new ExpensesResponst(list, count);
		return expensesReaponst;
	}

}
