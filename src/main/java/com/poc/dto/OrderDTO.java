package com.poc.dto;

import java.util.List;

import com.poc.models.Product;

public class OrderDTO {
    private String name;
    private String location;
    private String orderdate;
    private int claimflag;
    private int paymentflag;
    private int payment;
    private List<Product> products;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getClaimflag() {
		return claimflag;
	}
	public void setClaimflag(int claimflag) {
		this.claimflag = claimflag;
	}
	public int getPaymentflag() {
		return paymentflag;
	}
	public void setPaymentflag(int paymentflag) {
		this.paymentflag = paymentflag;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
