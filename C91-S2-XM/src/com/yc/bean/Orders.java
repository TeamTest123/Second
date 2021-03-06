package com.yc.bean;

public class Orders implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private Integer did;
	private Integer uid;
	private String money;
	private String pay;
	private String order_status;
	private String time;
	private String uname;
	private String phone;
	private String address;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "Orders [did=" + did + ", uid=" + uid + ", money=" + money + ", pay=" + pay + ", order_status="
				+ order_status + ", time=" + time + ", uname=" + uname + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
