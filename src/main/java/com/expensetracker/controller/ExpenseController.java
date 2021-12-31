package com.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.dto.ExpensesResponst;
import com.expensetracker.entity.Expense;
import com.expensetracker.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService service;

	@GetMapping("/{id}")
	public Expense getOne(@PathVariable Integer id) {
		return service.findOne(id);
	}

	@PostMapping("")
	public Expense creatExpense(@RequestBody Expense e) {
		System.out.println(e.getPayee());
		return service.creatExpense(e);
	}

	@PutMapping("/{id}")
	public Expense updateExpense(@PathVariable Integer id, @RequestBody Expense e) {
		return service.updateExpense(id, e);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delExpense(@PathVariable Integer id) {
		return service.delExpense(id);
	}

	@GetMapping("/query")
	public ExpensesResponst getQuery(@RequestParam String search, Integer offset, Integer limit, String month,
			String year) {
		boolean isNotHaveYear = year == "";
		boolean isNotHaveMonth = month == "";
		if (isNotHaveMonth && isNotHaveYear) {
			return service.findByQueryNoMonthNoYear(search, offset, limit);
		} else if (!isNotHaveYear && isNotHaveMonth) {
			return service.findByQueryYear(search, offset, limit, year);
		} else if (!isNotHaveMonth && isNotHaveYear) {
			return service.findByQueryMonth(search, offset, limit, month);
		} else {
			return service.findByQueryAll(search, offset, limit, month, year);
		}

	}
}
