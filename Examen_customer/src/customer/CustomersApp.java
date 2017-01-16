package customer;

/**
* CustomersApp.java
* Application with menu.
* @author Jose Moreno
* @version 
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import model.*;
import java.util.*;


public class CustomersApp {
	
	/* ------- attributes, properties or fields ------- */
	private Menu mainMenu;
	private CustomerStore my;
        ArrayList <Category> customersList = new ArrayList();
	/**
	 * main(). 
	 * Starts up application execution.
	 */
    public static void main(String[] args) {
		/* application object */
		CustomersApp myAp = new CustomersApp();
		/* run the application */
		myAp.run();
		
	}
	
        /* -------------- methods -------------- */
    
    /** run()
     * runs the application in non-static mode.
     */	
	private void run() {
		/* build main menu */	
		mainMenu = new CustomersMainMenu("Customers main menu");
		/* exit flag */
		boolean exit = false;
		/* menu option to execute */
		int option;
		/* instantiate data */
		my = new CustomerStore();
		/* load data */
		loadData();
		/* user service loop  */
		do {
			//show menu
			mainMenu.show();
			// get option
			option = mainMenu.choose();
			//control block
			switch (option) {
				case 0: //exit
					exit = true;  //set the exit flag.
					break;
				case 1: //list all customers.
                                        
					listAllCustomers();
                                        for (Category category : customersList) {
                                            System.out.println(category.toString());
                                    }
					break;
				case 2: //Search a customer by his phone
                                        Customer c = null;
					c = searchCustomerByPhone();
                                        if (c.getPhone() != null) {
                                              System.out.println(c.toString());
                                        }
                                        else System.out.println("Customer not found");
                                        
					break;
				case 3: //add a new customer
					newCustomer();
					break;
				case 4: //remove Customer
                                        boolean ok = false;
					ok = removeCustomer();
                                        if (ok) 
                                             alert("Customer successfully removed.\n");
                                        else {
                                            alert("Error removing customer.\n");
                                        }
                                                
					break;
				default: //default or invalid option
					alert("Invalid option\n");
					break;
			}
		} while (!exit);
		/* save data to persistent storage */
		saveData();
		alert("save data ...\n");
    }  

    /** alert()
     * shows a message
     * @param String msg: message to show
     */
     private void alert(String msg) {
		System.out.print(msg);
	 }
    /** 
     * loads and initializes data
     */
     private void loadData() {
		alert("Loading data ...\n");
               
                // ---- categories------
                my.addCategory(new Category("1", "VIP"));
                my.addCategory(new Category("2", "Regular"));
                my.addCategory(new Category("3", "Premium"));
                my.addCategory(new Category("4", "Mierder"));
                
                my.loadData();
                
	 }	
       /**
     * saves data
     */
     private void saveData() {
	my.saveData();
    
 }

	 /** listAllCustomers()
 prints all customers in the list.
     */
	public void listAllCustomers () {
		
            customersList = my.resturnCustomers();
		
	}
	 /** newCustomer()
	  *  asks the user the id of the category he wants to add the new Customer to,
 * asks the user to input data for the new Customer
 and adds it to the category with the given id.
     */
	public void newCustomer () {
		//input category id.
		//TODO
                boolean ok = false;
                do {         
                     my.printCategoies();
                     try {
                        System.out.println("Category:");
                        Scanner scan = new Scanner(System.in);
                        String cat = scan.next();
                        
                        Category c = my.getCategory(cat);
                        //
                         if (c!=null ) {
                             // add the new customer to a category
                             //input new customer.
                              Customer theNewCustomer = readCustomer(cat);
                             if ( theNewCustomer != null ) {
                                  my.add(c, theNewCustomer);
                                 ok = true;
                             }
                            
                         }else{
                             System.out.println("Category not exist");
                         }
               
                     } catch (Exception e) {
                             System.out.println("Sorry, try again");
                         }
                } while (ok == false);
      
		
	}	 
	 /** readCustomer()
 enter data for a new customer from the user.
     * @param cat id of category
     * @return the new Customer or null if error in entering data.
     */
	public Customer readCustomer (String cat) {
		Customer f = null;
		try {
			alert("Input name: ");
			Scanner scan = new Scanner(System.in);
			String name = scan.next();		
			alert("Input customer code: ");
			int customerCode = Integer.parseInt(scan.next());
			alert("Input phone: ");
			String phone = scan.next();
			alert("Input street: ");
			String st = scan.next();
			alert("Input number: ");
			String nu = scan.next();
			alert("Input city: ");
			String ci = scan.next();
			alert("Input zipcode: ");
			String zp = scan.next();
                        
                        //add the adress
			Address ad = new Address(st, nu, ci, zp);
                        
			f = new Customer(cat,name, customerCode, phone, ad);
		} catch (InputMismatchException e) {
			f = null;
		}
		return f;
	}	 
	 /** searchCustomerByPhone()
 asks the user to input the phone of the customer to search,
 searches an customer given its phone and shows it to user.
     */
	public Customer searchCustomerByPhone() {
		//Input customer phone.
		String phone = readString("Input the customer phone: ");
		Customer f = my.findByPhone(phone);
		return f;
	}
	 /** removeCustomer()
 asks the user the phone of the customer to be removed,
 searchs the customer with the given phone,
 and, if it exists, removes it from the list,
 and finally, reports operation result to user.
     */
	public Boolean removeCustomer() {
            boolean ok = false;
		//Input customer phone.
		String phone = readString("Input the customer phone: ");
		Customer f = my.findByPhone(phone);
		if (f != null) {
                    ok = my.remove(f);
			
		}
		else alert("Customer not found\n");	
                return ok;
	}
	 /** readString()
     * asks the user to input an String using a message,
     * @return String answer: the string read from the user.
     */
	public String readString(String message) {
		String answer = null;
		Scanner scan = new Scanner(System.in);
		alert(message);
		answer = scan.next();
		return answer;
	}
}
