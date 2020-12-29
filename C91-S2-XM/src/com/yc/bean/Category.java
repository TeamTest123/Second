package com.yc.bean;

public class Category implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer sid;
	private String bname;
	private Integer fid;
	@Override
	public String toString() {
		return "Sort [sid=" + sid + ", bname=" + bname + ", fid=" + fid + "]";
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
