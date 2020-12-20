package com.yc.bean;

public class Dingdan_Detail implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer ddid;
	private Integer did;
	private Integer pid;
	private String pay;
	private Integer number;
	public Integer getDdid() {
		return ddid;
	}
	public void setDdid(Integer ddid) {
		this.ddid = ddid;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
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
	@Override
	public String toString() {
		return "Dingdan_Detail [ddid=" + ddid + ", did=" + did + ", pid=" + pid + ", pay=" + pay + ", number=" + number
				+ "]";
	}
	
	
	
}
