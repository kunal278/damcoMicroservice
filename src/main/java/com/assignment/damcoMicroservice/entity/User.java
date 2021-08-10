package com.assignment.damcoMicroservice.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Kunal
 * User persistent entity
 */
@ApiModel
@Entity
@Table
public class User {
	
	@ApiModelProperty(
			  value = "Auto Generated ID of the user.It is not require while using POST request",
			  name = "id",
			  dataType = "int",
			  example = "0")
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@ApiModelProperty(
			  value = "first name of the user",
			  name = "firstName",
			  dataType = "String",
			  example = "Kunal",
			  required = true)
	@Column
	private String firstName;
	
	@ApiModelProperty(
			  value = "Surname of the user",
			  name = "surName",
			  dataType = "String",
			  example = "Singh",
			  required = true)
	@Column
	private String surName;
	
	@ApiModelProperty(
			  value = "Date of Birth of the user",
			  name = "dob",
			  dataType = "Date",
			  example = "2021-08-09",
			  required = true)
	@Column
	private Date dob;
	
	@ApiModelProperty(
			  value = "Title of the user",
			  name = "title",
			  dataType = "String",
			  example = "Mr",
			  required = true)
	@Column
	private String title;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, firstName=%s, surName=%s, dob=%s, title=%s]", id, firstName, surName, dob,
				title);
	}

	

}
