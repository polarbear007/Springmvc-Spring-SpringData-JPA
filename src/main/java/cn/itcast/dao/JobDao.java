package cn.itcast.dao;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import cn.itcast.entity.Job;

public interface JobDao extends JpaRepository<Job, String> {
	@QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
	@Query("from Job")
	public List<Job> findJobs();
}
