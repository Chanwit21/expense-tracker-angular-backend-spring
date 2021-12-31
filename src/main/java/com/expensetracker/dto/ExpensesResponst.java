package com.expensetracker.dto;

import java.util.List;

import com.expensetracker.entity.Expense;

public class ExpensesResponst {
	private List<Expense> expenses;
	private Integer count;

	public ExpensesResponst(List<Expense> expenses, Integer count) {
		super();
		this.expenses = expenses;
		this.count = count;
	}

	public ExpensesResponst() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
