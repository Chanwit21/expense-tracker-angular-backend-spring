package com.expensetracker.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String payee;
	private Double amount;
	private Date date;
	private String comment;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createDate;
	@UpdateTimestamp
	private LocalDateTime updateAtDateTime;

//	ForeignKey
	@ManyToOne
	private Category category;
}
