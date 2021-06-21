package com.dolma.CustomerHib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem 
{
	@Id 
	private int oid;
	private String pickle;
	private String fruits;
	private int bamboo;

//	@ManyToOne
//	private Customer cus;
	
	@ManyToMany
	private List<Customer> cus = new ArrayList<Customer>();
	
	
	
	public List<Customer> getCus() {
		return cus;
	}
	public void setCus(List<Customer> cus) {
		this.cus = cus;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public String getPickle() {
		return pickle;
	}
	public void setPickle(String pickle) {
		this.pickle = pickle;
	}
	public String getFruits() {
		return fruits;
	}
	public void setFruits(String fruits) {
		this.fruits = fruits;
	}
	public int getBamboo() {
		return bamboo;
	}
	public void setBamboo(int bamboo) {
		this.bamboo = bamboo;
	}
	@Override
	public String toString() {
		return "OrderItem [oid=" + oid + ", pickle=" + pickle + ", fruits=" + fruits + ", bamboo=" + bamboo + "]";
	}
	
	

}
