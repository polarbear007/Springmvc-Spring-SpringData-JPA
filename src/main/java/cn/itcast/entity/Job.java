package cn.itcast.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import cn.itcast.validation.updateValidation;

@Cacheable(true)
@Table(name="jobs" , catalog="sssp")
@Entity
public class Job implements Serializable {
	private static final long serialVersionUID = -141085014389872928L;
	
	@Id
	@Column(name="job_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotBlank(message="工种编号不能为空", groups= {updateValidation.class})
	private String jobId;
	@Column(name="job_title")
	private String jobTitle;
	@Column(name="min_salary")
	private Integer minSalary;
	@Column(name="max_salary")
	private Integer maxSalary;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}
}
