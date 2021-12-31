package com.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.expensetracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	@Query(value = " SELECT * FROM `expense` AS `e` LEFT OUTER JOIN `category` AS `c` ON `e`.`category_id` = `c`.`id` WHERE (`e`.`payee` LIKE %?1% OR `c`.`title` LIKE %?1%) AND (month(`date`) = ?2 AND year(`date`) = ?3) LIMIT ?4, ?5", nativeQuery = true)
	List<Expense> findByQueryAll(String search, String month, String year, Integer offset, Integer limit);

	@Query(value = " SELECT COUNT(*) AS count FROM `expense` AS `e` LEFT OUTER JOIN `category` AS `c` ON `e`.`category_id` = `c`.`id` WHERE (`e`.`payee` LIKE %?1% OR `c`.`title` LIKE %?1%) AND (month(`date`) = ?2 AND year(`date`) = ?3)", nativeQuery = true)
	Integer countFindByQueryAll(String search, String month, String year);

	@Query(value = " SELECT * FROM `expense` AS `e` LEFT OUTER JOIN `category` AS `c` ON `e`.`category_id` = `c`.`id` WHERE (`e`.`payee` LIKE %?1% OR `c`.`title` LIKE %?1%) AND (month(`date`) = ?2) LIMIT ?3, ?4", nativeQuery = true)
	List<Expense> findByQueryMonth(String search, String month, Integer offset, Integer limit);

	@Query(value = " SELECT COUNT(*) AS count FROM `expense` AS `e` LEFT OUTER JOIN `category` AS `c` ON `e`.`category_id` = `c`.`id` WHERE (`e`.`payee` LIKE %?1% OR `c`.`title` LIKE %?1%) AND (month(`date`) = ?2)", nativeQuery = true)
	Integer countFindByQueryMonth(String search, String month);

	@Query(value = " SELECT * FROM `expense` AS `e` LEFT OUTER JOIN `category` AS `c` ON `e`.`category_id` = `c`.`id` WHERE (`e`.`payee` LIKE %?1% OR `c`.`title` LIKE %?1%) AND (year(`date`) = ?2) LIMIT ?3, ?4", nativeQuery = true)
	List<Expense> findByQueryYear(String search, String year, Integer offset, Integer limit);

	@Query(value = " SELECT COUNT(*) AS count FROM `expense` AS `e` LEFT OUTER JOIN `category` AS `c` ON `e`.`category_id` = `c`.`id` WHERE (`e`.`payee` LIKE %?1% OR `c`.`title` LIKE %?1%) AND (year(`date`) = ?2)", nativeQuery = true)
	Integer countFindByQueryYear(String search, String year);

	@Query(value = " SELECT * FROM `expense` AS `e` LEFT OUTER JOIN `category` AS `c` ON `e`.`category_id` = `c`.`id` WHERE (`e`.`payee` LIKE %?1% OR `c`.`title` LIKE %?1%) LIMIT ?2, ?3", nativeQuery = true)
	List<Expense> findByQueryNoMonthNoYear(String search, Integer offset, Integer limit);

	@Query(value = " SELECT COUNT(*) AS count FROM `expense` AS `e` LEFT OUTER JOIN `category` AS `c` ON `e`.`category_id` = `c`.`id` WHERE (`e`.`payee` LIKE %?1% OR `c`.`title` LIKE %?1%)", nativeQuery = true)
	Integer countFindByQueryNoMonthNoYear(String search, Integer offset, Integer limit);
}
