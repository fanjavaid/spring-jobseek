/**
 * 
 */
package com.fanjavaid.test;

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

import com.fanjavaid.model.Position;
import com.fanjavaid.service.PositionService;

/**
 * @author fanjavaid
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
@Transactional
@Sql(scripts = {"classpath:sql_schema.sql", "classpath:sql_data.sql"})
public class PositionTest {
	@Autowired
	private PositionService positionService;
	
	@Test
	public void insertTest() throws Exception {
		Position p = new Position();
		p.setId(String.valueOf(UUID.randomUUID()));
		p.setPositionName("Web Developer");
		p.setDescription("-");
		
		int retval = positionService.insertPosition(p);
		
		Assert.assertNotNull(p);
		Assert.assertEquals("Web Developer", p.getPositionName());
		Assert.assertEquals(1, retval);
	}
	
	@Test
	public void updateTest() throws Exception {
		Position p = new Position("40f23faa-ef2f-11e5-9ce9-5e5517507c66", "Project Manager", "-");
		
		int retval = positionService.updatePosition(p);
		
		Assert.assertNotNull(p);
		Assert.assertEquals("Project Manager", p.getPositionName());
		Assert.assertEquals(1, retval);
	}
	
	@Test
	public void deleteTest() throws Exception {
		Position p = new Position("40f55faa-ef2f-11e5-9ce9-5e5517507c66", null, null);
		
		int retval = positionService.deletePosition(p);
		
		Assert.assertEquals(1, retval);
	}
	
	@Test
	public void getAllTest() throws Exception {
		List<Position> results = positionService.getAllPositions();
		
		Assert.assertNotNull(results);
		Assert.assertTrue(results.size() > 0);
		Assert.assertEquals("Position", results.get(0).getClass().getSimpleName());
	}
	
	@Test
	public void getPositionByIdTest() throws Exception {
		String id = "35910510-ef2f-11e5-9ce9-5e5517507c66";
		Position p = positionService.getPositionById(id);
		
		Assert.assertNotNull(p);
		Assert.assertEquals("Programmer", p.getPositionName());
	}
}