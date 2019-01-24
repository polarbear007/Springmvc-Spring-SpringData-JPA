package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.DepartmentDao;
import cn.itcast.entity.Department;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	public List<Department> findAll() {
		return departmentDao.findDepts();
	}
}
