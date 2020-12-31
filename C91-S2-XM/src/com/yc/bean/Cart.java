package com.yc.bean;



public class Cart implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer cid;
	private Integer pid;
	private Integer uid;
	private Integer number;

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", uid=" + uid  + ", number=" + number
				+ "]";
	}
	
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
