package cn.sz.gl.pojo;

import java.io.Serializable;
import java.util.Date;

public class House implements Serializable {

	private Integer houseid;
	private String picpath;
	private String title;
	private Integer houseArea;
	private Double price;
	private Date houseDate;
	private String phone;
	private String summary;
	private Date publicDate;
	private HouseStyle houseStyle;
	private Region region;
	public Integer getHouseid() {
		return houseid;
	}
	public void setHouseid(Integer houseid) {
		this.houseid = houseid;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(Integer houseArea) {
		this.houseArea = houseArea;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getHouseDate() {
		return houseDate;
	}
	public void setHouseDate(Date houseDate) {
		this.houseDate = houseDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getPublicDate() {
		return publicDate;
	}
	public void setPublicDate(Date publicDate) {
		this.publicDate = publicDate;
	}
	public HouseStyle getHouseStyle() {
		return houseStyle;
	}
	public void setHouseStyle(HouseStyle houseStyle) {
		this.houseStyle = houseStyle;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}

	
	
}
