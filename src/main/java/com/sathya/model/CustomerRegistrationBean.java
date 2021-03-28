package com.sathya.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerRegistrationBean {
	@NotEmpty
	@Size(min=4,max=10)
	private String firstName;
	@NotEmpty
	@Size(min=6,max=10)
	private String lastName;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size
	@Pattern(regexp="^[a-z][a-z0-9-@#$!]*")
	private String password;
	@NotNull
	private Gender gender;
	@NotEmpty
	private int age;
	@NotEmpty
	private String country;
	

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	/*
	 * @NotEmpty private long mobile;
	 */public String getFirstName() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*
	 * public int getAge() { return age; } public void setAge(int age) { this.age =
	 * age; }
	 */
	/*
	 * public long getMobile() { return mobile; } public void setMobile(long mobile)
	 * { this.mobile = mobile; }
	 */
	/*
	 * @Override public String toString() { return
	 * "CustomerRegistrationBean [firstName=" + firstName + ", lastName=" + lastName
	 * + ", email=" + email + ", age=" + age + ", mobile=" + mobile + "]"; }
	 */

}
