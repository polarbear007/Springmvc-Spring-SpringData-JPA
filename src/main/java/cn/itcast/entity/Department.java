package cn.itcast.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cn.itcast.validation.insertValidation;
import cn.itcast.validation.updateValidation;

@Cacheable(true)
@Table(name = "departments", catalog = "sssp")
@Entity
public class Department implements Serializable {
	private static final long serialVersionUID = 3409765694318315350L;

	@Id
	@Column(name = "department_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message="部门编号不能为空", groups= {updateValidation.class, insertValidation.class})
	private Integer departmentId;
	@Column(name = "department_name")
	private String departmentName;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
