package cn.itcast.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.itcast.validation.insertValidation;
import cn.itcast.validation.updateValidation;

@Table(name = "employees", catalog = "sssp")
@Entity
public class Employees implements Serializable {
	private static final long serialVersionUID = -8037682164700789344L;
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message="员工ID不能为空", groups= {updateValidation.class, insertValidation.class})
	private Integer employeeId;
	@Column(name = "first_name")
	@NotBlank(message="姓不能为空", groups= {updateValidation.class, insertValidation.class})
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message="名不能为空", groups= {updateValidation.class, insertValidation.class})
	private String lastName;
	private String email;
	@Column(name = "phone_number")
	@NotBlank(message="电话不能为空", groups= {updateValidation.class, insertValidation.class})
	private String phoneNumber;
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name = "hire_date")
	@NotNull(message="入职日期不能为空", groups= {updateValidation.class, insertValidation.class})
	private Date hireDate;
	private Double salary;
	@JoinColumn(name="department_id")
	@ManyToOne(targetEntity=Department.class)
	@Valid
	private Department department;
	@JoinColumn(name="job_id")
	@ManyToOne(targetEntity=Job.class)
	@Valid
	private Job job;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", salary=" + salary
				+ ", department=" + department + ", job=" + job + "]";
	}
	
	
}
