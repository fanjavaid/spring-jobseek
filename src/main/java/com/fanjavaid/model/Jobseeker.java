/**
 * 
 */
package com.fanjavaid.model;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author fanjavaid
 *
 */
@Component
public class Jobseeker {
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	private String pob;
	private Date dob;
	private Position position;
	private String status;
	private Date createdAt;
	private Date updatedAt;
	
	public Jobseeker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jobseeker(String id, String firstName, String lastName,
			String gender, String pob, Date dob, Position position,
			String status, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.pob = pob;
		this.dob = dob;
		this.position = position;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Jobseeker [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", pob="
				+ pob + ", dob=" + dob + ", position=" + position + ", status="
				+ status + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
}
