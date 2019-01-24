package cn.itcast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.entity.Employees;

public interface EmployeesDao extends JpaRepository<Employees, Integer> {

}
