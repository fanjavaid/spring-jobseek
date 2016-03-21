/**
 * 
 */
package com.fanjavaid.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fanjavaid.dao.PositionDao;
import com.fanjavaid.model.Position;

/**
 * @author fanjavaid
 *
 */
@Repository
public class PositionDaoImpl implements PositionDao {
	private Logger log = Logger.getLogger(PositionDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PositionDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PositionDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(final Position position) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO position (id, position_name, description) VALUES (?, ?, ?)";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, position.getId());
				ps.setString(2, position.getPositionName());
				ps.setString(3, position.getDescription());
				
				return ps.executeUpdate();
			}
		});
	}
	
	public int delete(final Position position) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM position WHERE id = ?";
		
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, position.getId());
				
				return ps.executeUpdate();
			}
		});
	}

	public int update(final Position position) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE position SET position_name = ?, description = ? WHERE id = ?";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, position.getPositionName());
				ps.setString(2, position.getDescription());
				ps.setString(3, position.getId());
				
				return ps.executeUpdate();
			}
			
		});
	}

	public List<Position> fetchAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM position ORDER BY position_name ASC";
		
		return jdbcTemplate.query(sql, new RowMapper<Position>() {

			public Position mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				Position p = new Position();
				p.setId(rs.getString("id"));
				p.setPositionName(rs.getString("position_name"));
				p.setDescription(rs.getString("description"));
				
				return p;
			}
		});
	}

	public Position fetchById(final String id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM position WHERE id = ?";
		
		return jdbcTemplate.query(sql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, id);
			}
		}, new ResultSetExtractor<Position>() {

			public Position extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				Position p = new Position();
				if (rs.next()) {
					p.setId(rs.getString("id"));
					p.setPositionName(rs.getString("position_name"));
					p.setDescription(rs.getString("description"));
				}
				
				return p;
			}
		});
	}

}
