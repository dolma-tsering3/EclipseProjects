package com.dolma.DemoHib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity    // @Entity is used to create table.
@Table(name="customer_table")  // giving the table name 
public class MyCustomer   // POJO
{
     @Id       // primary key
	 private int cusid;
    // @Transient  //this is not shown in table
	 private CusName cname;
	 @Column(name="location")   // changing the name caddr to location in table
	 private String caddr;
	
	 
	 public int getCusid() 
	 {
		return cusid;
	}
	public void setCusid(int cusid) 
	{
		this.cusid = cusid;
	}
	
	public CusName getCname() {
		return cname;
	}
	public void setCname(CusName cname) {
		this.cname = cname;
	}
	public String getCaddr() 
	{
		return caddr;
	}
	public void setCaddr(String caddr) 
	{
		this.caddr = caddr;
	}
	@Override
	public String toString() {
		return "MyCustomer [cusid=" + cusid + ", cname=" + cname + ", caddr=" + caddr + "]";
	}
	 
	 
	 
	
}
