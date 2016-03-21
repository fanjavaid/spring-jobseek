/**
 * 
 */
package com.fanjavaid.model;

import org.springframework.stereotype.Component;

/**
 * @author fanjavaid
 *
 */
@Component
public class Position {
	private String id;
	private String positionName;
	private String description;
	
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(String id, String positionName, String description) {
		super();
		this.id = id;
		this.positionName = positionName;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", positionName=" + positionName
				+ ", description=" + description + "]";
	}
	
}
