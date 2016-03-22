/**
 * 
 */
package com.fanjavaid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanjavaid.dao.JobseekerDao;
import com.fanjavaid.model.Jobseeker;

/**
 * @author fanjavaid
 *
 */
@Service
public class JobseekerService {
	@Autowired
	private JobseekerDao jobseekerDao;

	public JobseekerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobseekerService(JobseekerDao jobseekerDao) {
		super();
		this.jobseekerDao = jobseekerDao;
	}
	
	// Service method
	public int insertJobseeker(Jobseeker jobseeker) throws Exception {
		return jobseekerDao.insert(jobseeker);
	}
	
	public int updateJobseeker(Jobseeker jobseeker) throws Exception {
		return jobseekerDao.update(jobseeker);
	}
	
	public int deleteJobseeker(Jobseeker jobseeker) throws Exception {
		return jobseekerDao.delete(jobseeker);
	}
	
	public List<Jobseeker> getAllJobseekers() throws Exception {
		return jobseekerDao.fetchAll();
	}
	
	public Jobseeker getJobseekerById(String id) throws Exception {
		return jobseekerDao.fetchById(id);
	}
}
