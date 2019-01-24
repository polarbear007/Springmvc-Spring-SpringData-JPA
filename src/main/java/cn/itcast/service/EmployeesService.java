package cn.itcast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.EmployeesDao;
import cn.itcast.entity.Employees;

@Service
public class EmployeesService {
	@Autowired
	private EmployeesDao employeesDao;

	public Page<Employees> findAll(Integer currentPage) {
		PageRequest page = new PageRequest(currentPage, 10);
		return employeesDao.findAll(page);
	}

	public Employees findOne(Integer employeeId) {
		return employeesDao.findOne(employeeId);
	}
	
	@Transactional
	public void updateEmployees(Employees employees) {
		employeesDao.save(employees);
	}
	
	@Transactional
	public void deleteEmployees(Integer employeeId) {
		employeesDao.delete(employeeId);
	}

	public void saveEmployees(Employees emp) {
		employeesDao.save(emp);
	}
	
}
