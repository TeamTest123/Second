package com.yc.bean;

public class Product implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer pid;
	private String product_type;
	private String image;
	private String pname;
	private String price;
	private String color;
	private String content;
	private Integer number;
	@Override
	public String toString() {
		return "product [pid=" + pid + ", product_type=" + product_type + ", image=" + image 
				+ ", pname=" + pname + ", price=" + price + ", color=" + color + ", content=" + content + ", number="
				+ number + "]";
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String setNumber(String parameter) {
		return parameter;
		
	}
	
	
	
}
