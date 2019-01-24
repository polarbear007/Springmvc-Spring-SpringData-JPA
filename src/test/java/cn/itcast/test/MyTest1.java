package cn.itcast.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.controller.EmployeesHandler;
import cn.itcast.dao.EmployeesDao;
import cn.itcast.entity.Employees;
import cn.itcast.service.EmployeesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest1 {
	@Autowired
	private EmployeesDao employeesDao;
	
	@Autowired
	private EmployeesService employeesService;
	
	@Autowired
	private EmployeesHandler employeesHandler;
	
	// 测试一下这些对象能不能正常创建
	@Test
	public void test() {
		System.out.println(employeesDao.getClass().getName());
		System.out.println(employeesService.getClass().getName());
		System.out.println(employeesHandler.getClass().getName());
	}
	
	// 测试能不能从数据库查询数据
	@Test
	public void test2() {
		Employees employees = employeesDao.findOne(100);
		System.out.println(employees);
	}
	
}
