package com.perscholas.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//--------------------------code from hibernate demo---------------------------------------------------
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//--------------------------code from hibernate demo---------------------------------------------------

public class Main {//class beg

    public static void main(String[] args) {//main beg

        //--------------------------code from hibernate demo---------------------------------------------------
        SessionFactory factory = new
                Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        //--------------------------code from hibernate demo---------------------------------------------------


        //----------------------------------CREATE OBJECT---------------------------------------

        Scanner scannerInput = new Scanner(System.in);
        Appointment reservations = new Appointment();
        Payments payments = new Payments();
        Customer customer = new Customer();
        Department department = new Department();


        //---------------------------------BUSINESS LOGIC --------------------------------------

        Customer currentCustomer1 = new CurrentCustomer(33333, "Toby James",
                "8745 Too Little", "555-222-9858",
                true);
//        true, false, true, true);
        Customer currentCustomer2 = new CurrentCustomer(1111, "Lynn Odd",
                "8999 Big Cow", "882-282-9825",
                true);
//        true, true, true, true);
        Customer potentialCustomer1 = new PotentialCustomer(44444, "Kanesha Washington",
                "52 Not Now Ave", "748-227-9645",
                true);
//                true, true, "225 Stone St");
        Customer potentialCustomer2 = new PotentialCustomer(5555, "Tommy Ham",
                "52552 ok dr ", "945-227-8888",
                true);
//        true, false, "235 Edge St");


        //ADD new customer
        department.addCustomer(currentCustomer1);
        department.addCustomer(currentCustomer2);
        department.addCustomer(potentialCustomer1);
        department.addCustomer(potentialCustomer2);


        //using scanner to get user input

        System.out.println("Hello, please enter what you would like to do:");

        System.out.println("1. Add a customer");
        System.out.println("2. Get existing customer");
        System.out.println("3. Get ALL customers");
        System.out.println("4. Update a customer");
        System.out.println("5. Delete a customer");

        String chosenOption = scannerInput.next();
        System.out.println("CHOSEN OPTION:   " + chosenOption);


        // ADD a customer
        if (chosenOption.equals("1")) {
            System.out.println("ADD A NEW CUSTOMER");
            System.out.println(" ");
            System.out.println("please enter the information you "
                    + "would like to add. There are 5 fields. \n" +
                    "Please enter in this format: please put two spaces" +
                    " between the fields "
                    + " for example: " +
                    "33333,Toby James,8745 Too Little,555-222-9858,true");

            String customerInput = scannerInput.next();
            customerInput += scannerInput.nextLine();
            System.out.println("customer input: " + customerInput);

            Customer currentCustomer3 = new Customer(customerInput);

            System.out.println("ADD STILL NOT WORKING");
            System.out.println("currentcust3: "
                    + (currentCustomer3.toString()));

            //Customer currentCustomer3 = new CurrentCustomer(customerInput);
            //System.out.println(Arrays.toString(currentCustomer3));
            //ArrayList<Customer> currentCustomer3
            //List<Customer> currentCustomer3
            //        = department.getCustomerArray();
            //System.out.println("new data: "
            department.addCustomer(currentCustomer3);
            System.out.println("Proof record is added: ");
            department.getCustomerArray();
            System.out.println(" ");


            // get a specific EXISTING customer
        } else if (chosenOption.equals("2")) {
            System.out.println("GET A SPECIFIC EXISTING CUSTOMER");
            System.out.println("please enter the customer id "
                    + "you would like to attain: ");
            int customerId = scannerInput.nextInt();
            ArrayList<Customer> customerGetSpecificArrayList
                    = department.getASpecificCustomerArray(customerId);
            System.out.println(" ");


            // get ALL existing customer
        } else if (chosenOption.equals("3")) {
            System.out.println("they chose option 3 to get all customers");
            System.out.println("GET ALL CUSTOMER");
            ArrayList<Customer> customerArrayList
                    = department.getCustomerArray();
            System.out.println(" ");


            // UPDATE a specific existing customer
        } else if (chosenOption.equals("4")) {
            System.out.println("they chose option 4 to update existing customer");


            System.out.println("  please enter the customer id "
                    + "you would like to update: ");
            int customerId = scannerInput.nextInt();

            System.out.println("please enter the field you would "
                    + "like to update (name or address)");

            String customerField = scannerInput.next();

            System.out.print("please enter the new info:   ");

            String newInfoToUpdateField = scannerInput.next();
            newInfoToUpdateField += scannerInput.nextLine();
            department.updateSpecifCustomerArray
                    (customerId, customerField, newInfoToUpdateField);
            System.out.println("  ");


            // DELETE a specific existing customer
        } else if (chosenOption.equals("5")) {
            System.out.println("they chose option 5 to delete");
            System.out.println("DELETE A SPECIFIC EXISTING CUSTOMER");
            System.out.println("please enter the customer id to delete: ");
            int customerId = scannerInput.nextInt();
            department.deleteSpecificCustomerArray(customerId);

        }

        //--------------------------code from hibernate demo---------------------------------------------------
//        SessionFactory factory = new
//                Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
//
//        Department_BiDirectional department1 = new Department_BiDirectional();
//        Department_BiDirectional department2= new Department_BiDirectional();
//
//
//        //--creating teacher objects, that are loaded into teacher table--------
//        Teacher_BiDirectional t1 = new Teacher_BiDirectional();
//        t1.setTeachername("Haseeb");
//        t1.setSalary("100");
//        t1.setDep(department1);
//
//        Teacher_BiDirectional t2 = new Teacher_BiDirectional();
//        t2.setTeachername("Jenny Finch");
//        t2.setSalary("10000");
//        t2.setDep(department1);
//
//        Teacher_BiDirectional t3 = new Teacher_BiDirectional();
//        t3.setTeachername("James");
//        t3.setSalary("25000");
//        t3.setDep(department1);
//
//        Teacher_BiDirectional t4 = new Teacher_BiDirectional();
//        t4.setTeachername("SID ROSE");
//        t4.setSalary("3000");
//        t4.setDep(department2);
//
//        Teacher_BiDirectional t5 = new Teacher_BiDirectional();
//        t5.setSalary("200");
//        t5.setTeachername("Ali");
//        t5.setDep(department2);
//
//        //Add teacher entity object to the arraylist
//        List<Teacher_BiDirectional> teachlist1 = new ArrayList();
//        teachlist1.add(t1);
//        teachlist1.add(t2);
//        teachlist1.add(t3);
//
//        List<Teacher_BiDirectional> teachlist2 = new ArrayList();
//        teachlist2.add(t4);
//        teachlist2.add(t5);
//
//        //saving teacher objects to teacher table
//        //can comment these out, if using 'cascade all' in department class
//        session.save(t1);
//        session.save(t2);
//        session.save(t3);
//        session.save(t4);
//        session.save(t5);
//
//        //--creating department objects, that are loaded
//        // into department table with certain teachers in
//        // each department
//        //Create Department_ManyToOne
//        //Department_ManyToOne department1 = new Department_ManyToOne();
//        department1.setDname("Development");
//        department1.setTeachers(teachlist1);
//
//        //Department_ManyToOne department2 = new Department_ManyToOne();
//        department2.setDname("Marketing");
//        department2.setTeachers(teachlist2);
//
//        //saving department objects to department table
//        //can comment these out, if using 'cascade all'
//        // in department class
//        //Store/save Department_ManyToOne
//        session.save(department1);
//        session.save(department2);
//        t.commit();


    }//main end
}//class end