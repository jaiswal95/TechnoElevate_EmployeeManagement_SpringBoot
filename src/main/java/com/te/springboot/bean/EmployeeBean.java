package com.te.springboot.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table
@XmlRootElement(name = "employee-info")
@JsonRootName("employee-info")
@JsonPropertyOrder({ "emp_id", "firstName", "lastName", "email", "dob" })
public class EmployeeBean implements Serializable {

	@Id
	@Column
	@JsonProperty("emp_id")
	private Integer empid;

	@Column
	private String firstName;

	@Column
	private String LastName;

	@Column
	private Date dob;

	@Column
	private String email;

	@Column
	private String password;

}// end of EmployeeBean