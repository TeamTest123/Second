package com.yc.bean;

import java.math.BigDecimal;

public class Cart implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer cid;
	private Integer pid;
	private Integer uid;
	private Product product;
	private Integer number;
	private String  count;
	public String getCount() {
		return count;
	}



	public void setCount(String count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", uid=" + uid + ", product=" + product + ", number=" + number
				+ ", count=" + count + "]";
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
