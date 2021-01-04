package com.yc.bean;

public class Orders implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer did;
	private Integer uid;
	private String money;
	private String pay;//支付方式
	private String order_status;
	private String time;//下单时间
	@Override
	public String toString() {
		return "Dingdan [did=" + did + ", uid=" + uid + ", money=" + money + ", pay=" + pay + ", order_status="
				+ order_status + ", time=" + time + "]";
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
