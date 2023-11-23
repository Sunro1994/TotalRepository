package com.TravelMaker.model;

public class CouponDTO {
	private int coupon_idx;
	private String coupon_name;
	private String coupon_Validdate;
	private int coupon_SalePrice;
	private String coupon_content;
	private int coupon_Type;
	public int getCoupon_idx() {
		return coupon_idx;
	}
	public void setCoupon_idx(int coupon_idx) {
		this.coupon_idx = coupon_idx;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public String getCoupon_Validdate() {
		return coupon_Validdate;
	}
	public void setCoupon_Validdate(String coupon_Validdate) {
		this.coupon_Validdate = coupon_Validdate;
	}
	public int getCoupon_SalePrice() {
		return coupon_SalePrice;
	}
	public void setCoupon_SalePrice(int coupon_SalePrice) {
		this.coupon_SalePrice = coupon_SalePrice;
	}
	public String getCoupon_content() {
		return coupon_content;
	}
	public void setCoupon_content(String coupon_content) {
		this.coupon_content = coupon_content;
	}
	public int getCoupon_Type() {
		return coupon_Type;
	}
	public void setCoupon_Type(int coupon_Type) {
		this.coupon_Type = coupon_Type;
	}

}