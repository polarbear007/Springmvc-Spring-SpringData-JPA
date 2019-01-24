package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.JobDao;
import cn.itcast.entity.Job;

@Service
public class JobService {
	@Autowired
	private JobDao jobDao;

	public List<Job> findAll() {
		return jobDao.findJobs();
	}
}
