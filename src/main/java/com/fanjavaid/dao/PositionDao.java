/**
 * 
 */
package com.fanjavaid.dao;

import java.util.List;

import com.fanjavaid.model.Position;

/**
 * @author fanjavaid
 *
 */
public interface PositionDao {
	int insert(Position position) throws Exception;
	int update(Position position) throws Exception;
	int delete(Position position) throws Exception;
	List<Position> fetchAll() throws Exception;
	Position fetchById(String id) throws Exception;
}
