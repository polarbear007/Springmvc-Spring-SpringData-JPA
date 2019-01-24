package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.entity.Department;
import cn.itcast.entity.Employees;
import cn.itcast.entity.Job;
import cn.itcast.service.DepartmentService;
import cn.itcast.service.EmployeesService;
import cn.itcast.service.JobService;

@Controller
@RequestMapping("/employees")
public class EmployeesHandler {
	@Autowired
	private EmployeesService employeesService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private JobService jobService;

	@GetMapping("/emp/{currentPage}")
	public String findAll(@PathVariable("currentPage") Integer currentPage, Model model) {
		Page<Employees> page = employeesService.findAll(currentPage);
		model.addAttribute("page", page);
		return "listAllEmployees";
	}
	
	@PostMapping("/emp")
	public String updateEmployees(Employees employees) {
		employeesService.updateEmployees(employees);
		return "redirect:/employees/emp/0";
	}
	
	@GetMapping("/updateEmployeesPage/{employeeId}")
	public String updateEmployeesPage(@PathVariable("employeeId") Integer employeeId, Model model) {
		List<Department> deptList = departmentService.findAll();
		List<Job> jobList = jobService.findAll();
		Employees employees = employeesService.findOne(employeeId);
		if(employees != null) {
			model.addAttribute("employees", employees);
			model.addAttribute("deptList", deptList);
			model.addAttribute("jobList", jobList);
			return "udpateEmployeePage";
		}else {
			model.addAttribute("message", "不存在此员工ID");
			return "error";
		}
	}
	
	@DeleteMapping("/emp/{employeeId}")
	public String deleteEmployees(@PathVariable("employeeId") Integer employeeId) {
		employeesService.deleteEmployees(employeeId);
		return "redirect:/employees/emp/0";
	}
	
	@GetMapping("/addEmployeePage")
	public String addEmployeePage(Model model) {
		List<Department> deptList = departmentService.findAll();
		List<Job> jobList = jobService.findAll();
		model.addAttribute("deptList", deptList);
		model.addAttribute("jobList", jobList);
		return "addEmployeePage";
	}
	
	@PutMapping("/emp")
	public String addEmployee(Employees emp) {
		System.out.println(emp);
		employeesService.saveEmployees(emp);
		return "redirect:/employees/emp/0";
	}
	
}
