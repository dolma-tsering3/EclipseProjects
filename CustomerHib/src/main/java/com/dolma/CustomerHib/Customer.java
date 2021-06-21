package com.dolma.CustomerHib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer 
{
	@Id
	private int cid;
	private LocalDate date;
	private String name;
	private String address;
	// @OneToOne    // one student has one orderitem
	// private OrderItem order;
	
//	@OneToMany(mappedBy="cus") // one student has many orderitem // mapping is done by OrderItem class
//	private List<OrderItem> order = new ArrayList<OrderItem>();
	
	@ManyToMany(mappedBy="cus",fetch=FetchType.EAGER)  // mapping is done by OrderItem class.  // bydefault it is lazy.
	private List<OrderItem> order = new ArrayList<OrderItem>();
	

	
	public int getCid() {
		return cid;
	}
	public List<OrderItem> getOrder() {
		return order;
	}
	public void setOrder(List<OrderItem> order) {
		this.order = order;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", date=" + date + ", name=" + name + ", address=" + address + ", order="
				+ order + "]";
	}
	
	
	

}
