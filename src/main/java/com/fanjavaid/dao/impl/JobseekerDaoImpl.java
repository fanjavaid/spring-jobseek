/**
 * 
 */
package com.fanjavaid.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fanjavaid.dao.JobseekerDao;
import com.fanjavaid.model.Jobseeker;
import com.fanjavaid.model.Position;

/**
 * @author fanjavaid
 *
 */
@Repository
public class JobseekerDaoImpl implements JobseekerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.fanjavaid.dao.JobseekerDao#insert(com.fanjavaid.model.Jobseeker)
	 */
	public int insert(final Jobseeker jobseeker) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO jobseeker (id, first_name, last_name, gender, pob, dob, position_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, jobseeker.getId());
				ps.setString(2, jobseeker.getFirstName());
				ps.setString(3, jobseeker.getLastName());
				ps.setString(4, jobseeker.getGender());
				ps.setString(5, jobseeker.getPob());
				ps.setDate(6, new Date(jobseeker.getDob().getTime()));
				ps.setString(7, jobseeker.getPosition().getId());
				
				return ps.executeUpdate();
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.fanjavaid.dao.JobseekerDao#update(com.fanjavaid.model.Jobseeker)
	 */
	public int update(final Jobseeker jobseeker) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE jobseeker SET first_name=?, last_name=?, gender=?, pob=?, dob=?, position_id=? WHERE id=?";
		
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, jobseeker.getFirstName());
				ps.setString(2, jobseeker.getLastName());
				ps.setString(3, jobseeker.getGender());
				ps.setString(4, jobseeker.getPob());
				ps.setDate(5, new Date(jobseeker.getDob().getTime()));
				ps.setString(6, jobseeker.getPosition().getId());
				ps.setString(7, jobseeker.getId());
				
				return ps.executeUpdate();
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.fanjavaid.dao.JobseekerDao#delete(com.fanjavaid.model.Jobseeker)
	 */
	public int delete(final Jobseeker jobseeker) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM jobseeker WHERE id = ?";
		
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, jobseeker.getId());
				
				return ps.executeUpdate();
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.fanjavaid.dao.JobseekerDao#fetchAll()
	 */
	public List<Jobseeker> fetchAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT a.id as jobseeker_id, a.first_name, a.last_name, a.gender, a.pob, a.dob, a.position_id, b.position_name, b.description"
				+ " FROM jobseeker a"
				+ " LEFT JOIN position b"
				+ " ON a.position_id = b.id";
		return jdbcTemplate.query(sql, new RowMapper<Jobseeker>() {

			public Jobseeker mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				Jobseeker js = new Jobseeker();
				js.setId(rs.getString("jobseeker_id"));
				js.setFirstName(rs.getString("first_name"));
				js.setLastName(rs.getString("last_name"));
				js.setGender(rs.getString("gender"));
				js.setPob(rs.getString("pob"));
				js.setDob(rs.getDate("dob"));
				
				Position p = new Position();
				p.setId(rs.getString("position_id"));
				p.setPositionName(rs.getString("position_name"));
				p.setDescription(rs.getString("description"));
				
				js.setPosition(p);
				
				return js;
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.fanjavaid.dao.JobseekerDao#fetchById(java.lang.String)
	 */
	public Jobseeker fetchById(final String id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT a.id as jobseeker_id, a.first_name, a.last_name, a.gender, a.pob, a.dob, a.position_id, b.position_name, b.description"
				+ " FROM jobseeker a"
				+ " LEFT JOIN position b"
				+ " ON a.position_id = b.id"
				+ " WHERE a.id = ?";
		
		return jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, id);
				
				ps.executeQuery();
			}
		}, new ResultSetExtractor<Jobseeker>() {

			public Jobseeker extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				Jobseeker js = new Jobseeker();
				if (rs.next()) {
					js.setId(rs.getString("jobseeker_id"));
					js.setFirstName(rs.getString("first_name"));
					js.setLastName(rs.getString("last_name"));
					js.setGender(rs.getString("gender"));
					js.setPob(rs.getString("pob"));
					js.setDob(rs.getDate("dob"));
					
					Position p = new Position();
					p.setId(rs.getString("position_id"));
					p.setPositionName(rs.getString("position_name"));
					p.setDescription(rs.getString("description"));
					
					js.setPosition(p);
				}
				
				return js;
			}
		});
	}

}
