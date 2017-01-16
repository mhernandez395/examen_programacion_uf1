package customer;

/**
 * CustomersMainMenu.java
 main menu of zoo application.
 */

public class CustomersMainMenu extends Menu {

	private final String [] labels = {
	 "Exit", 
	 "List all customers from a category", 
	 "Search a customer by his phone",
	 "Add a new customer to a category",
	 "Remove an existing customer"
	};

	public CustomersMainMenu(String title) {
		super(title);
     	for (String s: labels)
     		add(new Option(s));
	}

}
