package com.perscholas.models2;

import com.perscholas.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//--------------------------code from hibernate demo---------------------------------------------------
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Delete
{
        public static void main(String[] args)
        {
            System.out.println("Maven + Hibernate + SQL One to Many Mapping Annotations");

            SessionFactory factory = new
                    Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();  //create the session object
            Transaction t = session.beginTransaction();  //begins the transaction


            Customer currentCustomer2 = session.get(Customer.class,2);

            session.delete(currentCustomer2);

            t.commit();
        }

    }


