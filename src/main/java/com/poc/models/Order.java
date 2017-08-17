package com.poc.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="ordertable")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
    private String name;
    private String location;
    private String orderdate;
    private int claimflag;
    private int paymentflag;
    private int payment;
    
    public Order(String name,String location,List<Product> products){
    	this.name = name;
    	this.location = location;
    	this.products = products;
    }
    //claimed = 1 not claimed = 0
    //paid = 1 not paid = 0
    public Order(String name,String location,List<Product> products,int claimflag,int paymentflag,int payment){
    	this.name = name;
    	this.location = location;
    	this.products = products;
    	this.setClaimflag(claimflag);
    	this.setPaymentflag(paymentflag);
    	this.setPayment(payment);
    }
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
        name="orderline",
        joinColumns=@JoinColumn(name="orderid", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="productid", referencedColumnName="id"))
    private List<Product> products;
    
    public Order(){}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getDate() {
		return orderdate;
	}
	public void setDate(String date) {
		this.orderdate = date;
	}

	public List<Product> getProduct() {
		return products;
	}

	public void setProduct(List<Product> product) {
		this.products = product;
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
}
