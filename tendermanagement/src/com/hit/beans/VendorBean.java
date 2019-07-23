package com.hit.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VendorBean implements Serializable{
	private String id;
	private String name;
	private String mobile;
	private String email;
	private String address;
	private String company;
	private String password;
	public VendorBean(){}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public VendorBean(String id,String name, String mobile, String email, String address,
			String company, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.company = company;
		this.password = password;
		//generateId();
	}
	
	/*public void generateId(){
		String vid = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		vid=sdf.format(new Date());
		vid = "V"+vid;
		this.id = vid;
	}*/
	
}
