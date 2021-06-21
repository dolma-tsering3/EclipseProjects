package com.dolma.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *Artifact = project name i.e. DemoHib here.
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
    	MyCustomer cus = new MyCustomer();
        CusName cn = new CusName();
        
        cn.setFname("Kunga");
        cn.setMname("Pasang");
        cn.setLname("Gurung");
    
    	// setting value of pojo class
        	cus.setCusid(1);
        	cus.setCaddr("basantapur");
        	cus.setCname(cn);
    	
             // inside configuration() we need to add cfg.xml folder which then connects to db
        	// but here hibernate.cg.xml is default name so no need to add it.
        	// addAnnotatedClass() is used to add that java class to db.
        	Configuration conf = new Configuration().configure().addAnnotatedClass(MyCustomer.class);  
        	SessionFactory sf = conf.buildSessionFactory();  // session is interface and we cannot create its object and so we use Configuration class
            Session sess = sf.openSession();   // which gives obj of sessionfactory and then later gives obj of session.
        	Transaction tx = sess.beginTransaction(); // we use this when we want to make any changes in db.
        	
        	// for loading data in db.
        	sess.save(cus);   // save method belongs to session interface which then belongs to hibernate framework.. 
        	                  // so we need to add hibernate dependency.   
        	
        	
        	
        	// for fetching data from db.
        	cus = sess.get(MyCustomer.class, 4);
        	
        	
          	tx.commit();    
          	
          	System.out.println(cus);
        	                    	                
    	
    }
}
