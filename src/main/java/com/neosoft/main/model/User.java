package com.neosoft.main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.neosoft.main.Application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull(message = "Name should not be null")
	private String name;
	@NotNull(message = "Name should not be null")
	private String surname;
	@NotNull(message = "Name should not be null")
	private String city;
	@NotNull(message = "Name should not be empty")
	@Pattern(regexp = "^[0-9]*$")
	private String pincode;
	@NotNull(message = "Mobile should be filled")
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}")
	private String mobileNo;
//	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
//	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;
	@NotNull(message = "pancard should not be null")
	private String panNo;
	@NotNull(message = "salary should be filled")
	@Pattern(regexp = "^[0-9]*$")
	private String salary;
	
	
	private String deleted="No";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	@JsonIgnore
	@JsonIgnoreProperties(value = "deleted")
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
	
}
