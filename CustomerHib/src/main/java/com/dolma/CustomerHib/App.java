package com.dolma.CustomerHib;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 Customer c = new Customer();
    	OrderItem ot = new OrderItem();
    	ot.setOid(2);
        ot.setBamboo(88);
        ot.setFruits("apple");
        ot.setPickle("radish");
        ot.getCus().add(c);
    	
      
       c.setDate(LocalDate.now());
       c.setName("rita");
       c.setCid(104);
       c.setAddress("tinchuli");
       // c.setOrder(ot);
       c.getOrder().add(ot);
      
       
       
       
       
       Configuration con = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(OrderItem.class);
       SessionFactory sf = con.buildSessionFactory();
       Session s = sf.openSession();
       Transaction tx = s.beginTransaction();
       // s.get(Customer.class, 102);  // fetching of Customer including that of list of OrderItem class that is defined in Customer class since the fetchtype is EAGER
        s.save(c);
        s.save(ot);
        tx.commit();
    		   
       
       
    
    }
    
}
