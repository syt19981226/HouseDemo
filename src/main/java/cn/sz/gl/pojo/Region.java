package cn.sz.gl.pojo;

import java.io.Serializable;

public class Region implements Serializable {

	private String code;
	private String countryCode;
	private String regionNameEn;
	private String regionNameCn;
	private String level;
	private String upperRegion;
	private Region region;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getRegionNameEn() {
		return regionNameEn;
	}
	public void setRegionNameEn(String regionNameEn) {
		this.regionNameEn = regionNameEn;
	}
	public String getRegionNameCn() {
		return regionNameCn;
	}
	public void setRegionNameCn(String regionNameCn) {
		this.regionNameCn = regionNameCn;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getUpperRegion() {
		return upperRegion;
	}
	public void setUpperRegion(String upperRegion) {
		this.upperRegion = upperRegion;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
}
