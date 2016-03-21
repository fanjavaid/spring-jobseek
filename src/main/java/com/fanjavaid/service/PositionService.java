/**
 * 
 */
package com.fanjavaid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanjavaid.dao.PositionDao;
import com.fanjavaid.model.Position;

/**
 * @author fanjavaid
 *
 */
@Service
public class PositionService {
	@Autowired
	private PositionDao dao;

	public PositionService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PositionService(PositionDao dao) {
		super();
		this.dao = dao;
	}
	
	// Service Method
	public int insertPosition(Position position) throws Exception {
		return dao.insert(position);
	}
	
	public int updatePosition(Position position) throws Exception {
		return dao.update(position);
	}
	
	public int deletePosition(Position position) throws Exception {
		return dao.delete(position);
	}
	
	public List<Position> getAllPositions() throws Exception {
		return dao.fetchAll();
	}
	
	public Position getPositionById(String id) throws Exception {
		return dao.fetchById(id);
	}
}
