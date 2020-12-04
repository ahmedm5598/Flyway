package com.example.myDemo.repository;

import com.example.myDemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT * FROM employees WHERE last_name=?1 ORDER BY first_name", nativeQuery = true)
    public List<Employee> findEmployeesByLastName(String last_name);

    @Query(
            value = "SELECT * FROM employees ORDER BY id",
            countQuery = "SELECT count(*) FROM employees",
            nativeQuery = true)
    public Page<Employee> findAllUsersWithPagination(Pageable pageable);

    public List<Employee> findByFirstNameStartingWith(String prefix);



}
