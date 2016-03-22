/**
 * 
 */
package com.fanjavaid.dao;

import java.util.List;

import com.fanjavaid.model.Jobseeker;

/**
 * @author fanjavaid
 *
 */
public interface JobseekerDao {
	int insert(Jobseeker jobseeker) throws Exception;
	int update(Jobseeker jobseeker) throws Exception;
	int delete(Jobseeker jobseeker) throws Exception;
	List<Jobseeker> fetchAll() throws Exception;
	Jobseeker fetchById(String id) throws Exception;
}
