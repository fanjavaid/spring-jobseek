/**
 * 
 */
package com.fanjavaid.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fanjavaid.model.Jobseeker;
import com.fanjavaid.model.Position;
import com.fanjavaid.service.JobseekerService;
import com.fanjavaid.service.PositionService;

/**
 * @author fanjavaid
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
@Transactional
@Sql(scripts={"classpath:sql_schema.sql", "classpath:sql_data.sql"})
public class JobseekerTest {
	
	@Autowired
	private JobseekerService jobseekerService;
	
	@Autowired
	private PositionService positionService;
	
	@Test
	public void insertJobseekerTest() throws Exception {
		Jobseeker js = new Jobseeker();
		js.setId(String.valueOf(UUID.randomUUID()));
		js.setFirstName("Jonathan");
		js.setLastName("Doe");
		js.setGender("M");
		js.setPob("Tokyo");
		js.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1989-11-23"));
		
		Position p = positionService.getPositionById("35910510-ef2f-11e5-9ce9-5e5517507c66");
		js.setPosition(p);
		
		int retval = jobseekerService.insertJobseeker(js);
		
		Assert.assertNotNull(p);
		Assert.assertEquals(1, retval);
	}
	
	@Test
	public void updateJobseekerTest() throws Exception {
		Jobseeker js = new Jobseeker();
		js.setId("a20f5e38-ef22-11e5-9ce9-5e5517507c66");
		js.setFirstName("One");
		js.setLastName("Chan");
		js.setGender("F");
		js.setPob("Tokyo");
		js.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1992-08-11"));
		
		Position p = positionService.getPositionById("35910510-ef2f-11e5-9ce9-5e5517507c66");
		js.setPosition(p);
		
		int retval = jobseekerService.updateJobseeker(js);
		
		Assert.assertNotNull(p);
		Assert.assertEquals(1, retval);
	}
	
	@Test
	public void getAllJobseekerTest() throws Exception {
		List<Jobseeker> jobseekers = jobseekerService.getAllJobseekers();
		
		Assert.assertNotNull(jobseekers);
		Assert.assertTrue(jobseekers.size() > 0);
		Assert.assertEquals("Jobseeker", jobseekers.get(0).getClass().getSimpleName());
	}
	
	@Test
	public void getJobseekerById() throws Exception {
		String id = "b4f59076-ef22-11e5-9ce9-5e5517507c66";
		Jobseeker jobseeker = jobseekerService.getJobseekerById(id);
		
		Assert.assertNotNull(jobseeker);
		Assert.assertNotNull(jobseeker.getPosition());
		Assert.assertEquals("Erika", jobseeker.getFirstName());
		Assert.assertEquals("277cc5ae-ef2f-11e5-9ce9-5e5517507c66", jobseeker.getPosition().getId());
	}
}
