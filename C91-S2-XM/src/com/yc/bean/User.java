package com.yc.bean;

public class User implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer uid;
	private String uname;
	private String phone;
	private String email;
	private String upwd;
	private String address;
	private String status;

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", phone=" + phone + ", email=" + email + ", upwd=" + upwd
				+ ", address=" + address + ", status=" + status +"]";
		//
	}
	public User() {
		super();
		this.uid = uid;
		this.uname = uname;
		this.phone = phone;
		this.email = email;
		this.upwd = upwd;
		this.address = address;
		this.status = status;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPassword() {
		return null;

}

	
}
