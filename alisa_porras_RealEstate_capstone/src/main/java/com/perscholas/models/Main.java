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

public class Main
{//class beg

    public static void main(String[] args) {//main beg

        System.out.println("Maven + Hibernate + SQL One to Many Mapping Annotations");

        SessionFactory factory = new
                Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();  //create the session object
        Transaction t = session.beginTransaction();  //begins the transaction

        Scanner scannerInput = new Scanner(System.in);

        // creating department objects
        Department department1 = new Department();
        Department department2 = new Department();

        // creating customer objects
        Customer currentCustomer1 = new Customer();
        currentCustomer1.setCustomerName("Toby James");
        currentCustomer1.setCustomerZip("48236");
        department1.setDepartmentName("Current Customer");

        Customer currentCustomer2 = new Customer();
        currentCustomer2.setCustomerName("Kimberly Jojo");
        currentCustomer2.setCustomerZip("32581");
        department1.setDepartmentName("Current Customer");

        Customer potentialCustomer3 = new Customer();
        potentialCustomer3.setCustomerName("Peter Toduuu");
        potentialCustomer3.setCustomerZip("98745");
        department2.setDepartmentName("Potential Customer");




        //create arraylist to add customer

        //adding customer entity objects to array list
        List<Customer> customerList1 = new ArrayList<>();
        //addCurrentCustomerToArrayList(currentCustomer1);
        //addCurrentCustomerToArrayList(currentCustomer2);
        customerList1.add(currentCustomer1);
        customerList1.add(currentCustomer2);

        List<Customer> potentialList1 = new ArrayList<>();
        //addPotentialCustomerToArrayList(potentialCustomer3);
        potentialList1.add(potentialCustomer3);


        //save all my customer data to kinda a holding area
        // aka a session/connection to database
        session.save(currentCustomer1);
        session.save(currentCustomer2);
        session.save(potentialCustomer3);

        //create department object
        department1.setDepartmentName("Current Customer");
        department1.setCustomerList(customerList1);

        department2.setDepartmentName("Potential Customer");
        department2.setCustomerList(potentialList1);

        //store department
        session.save(department1);                   //holds the data in kinda a container until committed
        session.save(department2);

        t.commit();   // actually committing/saving/persisting all my changes to my database

        //------------------------CRUD OPERATIONS---------------------------------------------

        SessionFactory sessionFactoryCrud = new Configuration().configure().buildSessionFactory();
        Session sessionCrud = factory.openSession();
        Transaction transactionCrud = session.beginTransaction();


        System.out.println(" ");
        System.out.println("Hello, please enter what you would like to do:");

        System.out.println("1. Add a customer");
        System.out.println("2. Get existing customer");
        System.out.println("3. Get ALL customers");
        System.out.println("4. Update a customer");
        System.out.println("5. Delete a customer");

        String chosenOption = scannerInput.next();
        System.out.println("CHOSEN OPTION:   " + chosenOption);

        if (chosenOption.equals("1"))
        {
            Customer potentialCustomer4 = new Customer();

            potentialCustomer4.setCustomerName("Lula Washington");
            potentialCustomer4.setCustomerZip("87458");
            department2.setDepartmentName("Potential Customer");


            potentialList1.add(potentialCustomer4);
            session.save(potentialCustomer4);

            //department2.setCustomerList(potentialList1);
            //session.save(department2);

            transactionCrud.commit();
            sessionCrud.close();

            System.out.println(" ");
            System.out.println("ADD A NEW CUSTOMER" + potentialCustomer4);

        } else if (chosenOption.equals("2")) {
            //----------------get a specific EXISTING customer------------------------------------

            //Department department = sessionCrud.get(Department.class,2);
            Customer customer = sessionCrud.get(Customer.class, 3);
            System.out.println(" ");
            System.out.println("RETRIEVED AN EXISTING RECORD: " + customer);

            sessionCrud.close();


        } else if (chosenOption.equals("3")) {
            //----------------get all records------------------------------------
            //Department department = sessionCrud.get(Department.class,2);
//            Customer customer = sessionCrud.
//
//            List li = sessionCrud.createQuery("Department");
//
//            System.out.println(" ");
//            System.out.println("RETRIEVED AN EXISTING RECORD: " + customer);
//
//            sessionCrud.close();

            System.out.println("GET ALL RECORDS");


        } else if (chosenOption.equals("4")) {
            //----------------update a record------------------------------------
            System.out.println("UPDATE RECORD");


            Customer customer = sessionCrud.get(Customer.class, 2);
            customer.setCustomerName("changed customer name");

//            Department department = sessionCrud.get(Department.class,2);  //accessing this id in the table
//            department.setDepartmentName("changed department name");                //updating the table

            sessionCrud.update(customer);
            //sessionCrud.save(department);

            transactionCrud.commit();                                // actually committing/saving all my changes to my database

            System.out.println(" ");
            System.out.println("UPDATED AN EXISTING RECORD: " + customer);

            sessionCrud.close();

        }
        else if (chosenOption.equals("5"))
        {
            //----------------delete a record------------------------------------


//          Department department = sessionCrud.get(Department.class,2);    //accessing this id in the table
//          department.setDepartmentName("changed department name");        //updating the table

            currentCustomer2 = sessionCrud.get(Customer.class, 2);
            System.out.println("BEFORE DELETE RECORD" + currentCustomer2);
            sessionCrud.delete(currentCustomer2);

            transactionCrud.commit();
            //session.close();

            System.out.println(" ");
            System.out.println("DELETE RECORD");
        }


    }//main end




//-----------BEFORE I MADE ANY CHANGES ON 5/10/23 @ 10:02 pm
//        //----------------------------------CREATE OBJECT---------------------------------------
//
//        Scanner scannerInput = new Scanner(System.in);
//        Appointment reservations = new Appointment();
//        Payments payments = new Payments();
//        Customer customer = new Customer();
//        Department department = new Department();
//
//
//        //---------------------------------BUSINESS LOGIC --------------------------------------
//
//        Customer currentCustomer1 = new CurrentCustomer(33333, "Toby James",
//                "8745 Too Little", "555-222-9858",
//                true);
////        true, false, true, true);
//        Customer currentCustomer2 = new CurrentCustomer(1111, "Lynn Odd",
//                "8999 Big Cow", "882-282-9825",
//                true);
////        true, true, true, true);
//        Customer potentialCustomer1 = new PotentialCustomer(44444, "Kanesha Washington",
//                "52 Not Now Ave", "748-227-9645",
//                true);
////                true, true, "225 Stone St");
//        Customer potentialCustomer2 = new PotentialCustomer(5555, "Tommy Ham",
//                "52552 ok dr ", "945-227-8888",
//                true);
////        true, false, "235 Edge St");
//
//
//        //ADD new customer
//        department.addCustomer(currentCustomer1);
//        department.addCustomer(currentCustomer2);
//        department.addCustomer(potentialCustomer1);
//        department.addCustomer(potentialCustomer2);
//
//
//        //using scanner to get user input
//
//        System.out.println("Hello, please enter what you would like to do:");
//
//        System.out.println("1. Add a customer");
//        System.out.println("2. Get existing customer");
//        System.out.println("3. Get ALL customers");
//        System.out.println("4. Update a customer");
//        System.out.println("5. Delete a customer");
//
//        String chosenOption = scannerInput.next();
//        System.out.println("CHOSEN OPTION:   " + chosenOption);
//
//
//        // ADD a customer
//        if (chosenOption.equals("1")) {
//            System.out.println("ADD A NEW CUSTOMER");
//            System.out.println(" ");
//            System.out.println("please enter the information you "
//                    + "would like to add. There are 5 fields. \n" +
//                    "Please enter in this format: please put two spaces" +
//                    " between the fields "
//                    + " for example: " +
//                    "33333,Toby James,8745 Too Little,555-222-9858,true");
//
//            String customerInput = scannerInput.next();
//            customerInput += scannerInput.nextLine();
//            System.out.println("customer input: " + customerInput);
//
//            Customer currentCustomer3 = new Customer(customerInput);
//
//            System.out.println("ADD STILL NOT WORKING");
//            System.out.println("currentcust3: "
//                    + (currentCustomer3.toString()));
//
//            //Customer currentCustomer3 = new CurrentCustomer(customerInput);
//            //System.out.println(Arrays.toString(currentCustomer3));
//            //ArrayList<Customer> currentCustomer3
//            //List<Customer> currentCustomer3
//            //        = department.getCustomerArray();
//            //System.out.println("new data: "
//            department.addCustomer(currentCustomer3);
//            System.out.println("Proof record is added: ");
//            department.getCustomerArray();
//            System.out.println(" ");
//
//
//            // get a specific EXISTING customer
//        } else if (chosenOption.equals("2")) {
//            System.out.println("GET A SPECIFIC EXISTING CUSTOMER");
//            System.out.println("please enter the customer id "
//                    + "you would like to attain: ");
//            int customerId = scannerInput.nextInt();
//            ArrayList<Customer> customerGetSpecificArrayList
//                    = department.getASpecificCustomerArray(customerId);
//            System.out.println(" ");
//
//
//            // get ALL existing customer
//        } else if (chosenOption.equals("3")) {
//            System.out.println("they chose option 3 to get all customers");
//            System.out.println("GET ALL CUSTOMER");
//            ArrayList<Customer> customerArrayList
//                    = department.getCustomerArray();
//            System.out.println(" ");
//
//
//            // UPDATE a specific existing customer
//        } else if (chosenOption.equals("4")) {
//            System.out.println("they chose option 4 to update existing customer");
//
//
//            System.out.println("  please enter the customer id "
//                    + "you would like to update: ");
//            int customerId = scannerInput.nextInt();
//
//            System.out.println("please enter the field you would "
//                    + "like to update (name or address)");
//
//            String customerField = scannerInput.next();
//
//            System.out.print("please enter the new info:   ");
//
//            String newInfoToUpdateField = scannerInput.next();
//            newInfoToUpdateField += scannerInput.nextLine();
//            department.updateSpecifCustomerArray
//                    (customerId, customerField, newInfoToUpdateField);
//            System.out.println("  ");
//
//
//            // DELETE a specific existing customer
//        } else if (chosenOption.equals("5")) {
//            System.out.println("they chose option 5 to delete");
//            System.out.println("DELETE A SPECIFIC EXISTING CUSTOMER");
//            System.out.println("please enter the customer id to delete: ");
//            int customerId = scannerInput.nextInt();
//            department.deleteSpecificCustomerArray(customerId);
//
//        }

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



}//class end


