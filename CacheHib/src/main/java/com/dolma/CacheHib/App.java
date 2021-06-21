package com.dolma.CacheHib;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
       
       Customer c = new Customer();
       
       Configuration con = new Configuration().configure().addAnnotatedClass(Customer.class);
       SessionFactory sf = con.buildSessionFactory();   
       
       Session s1 = sf.openSession();
       s1.beginTransaction();
       
       // when applying the same query twice for a particular session it is fired only once 
       // since for the second query, data is in first level cache(bydefault provided by hibernate)
      //  c = s1.get(Customer.class, 103); // instead of get() we can also use query as shown below
       String hql = "from Customer where cid=103";  // hql
       Query q1 = s1.createQuery(hql);
       q1.setCacheable(true);  // by doing this and setting in hcfg , second level cache is applicable for query as well
       c = (Customer) q1.uniqueResult();
       System.out.println(c);
       
       s1.getTransaction().commit();      // for two diff sessions the same query is fired twice. To make it fire once we need 
        s1.close();                // to make it second level cache (applicable only for get())by configuring in pom and cfg file.
       
        
       Session s2 = sf.openSession();
       s2.beginTransaction(); 
       
      // c = s2.get(Customer.class, 103);
       String hql2 = "from Customer where cid=103";
       Query q2 = s2.createQuery(hql2);
       q2.setCacheable(true);  
       c = (Customer) q2.uniqueResult();
       System.out.println(c);
       
       s2.getTransaction().commit();
       s2.close();
      
       
    	
    }
}
