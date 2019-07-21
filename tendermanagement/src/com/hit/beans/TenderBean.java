package com.hit.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TenderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String type;
	private int price;
	private String desc;
	private Date deadline;
	private String location;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public TenderBean(String id, String name, String type, int price,
			String desc, String stdeadline, String location) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.desc = desc;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date deadline = null;
	
		try {
			deadline=sdf.parse(stdeadline);  
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.deadline = deadline;
		this.location = location;
	}
	public TenderBean() {
		super();
	}
	

}
