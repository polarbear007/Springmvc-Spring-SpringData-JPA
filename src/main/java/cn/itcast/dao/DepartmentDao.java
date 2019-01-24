package cn.itcast.dao;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import cn.itcast.entity.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
	@QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
	@Query("from Department")
	public List<Department> findDepts();
}
