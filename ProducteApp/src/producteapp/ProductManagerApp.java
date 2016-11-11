
package cat.proven.productmanager;

import cat.proven.productmanager.model.DBStore;
import cat.proven.productmanager.model.Fridge;
import cat.proven.productmanager.model.Product;
import cat.proven.productmanager.model.Store;
import cat.proven.productmanager.model.StoreInterface;
import cat.proven.productmanager.model.Tv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class of the product manager application
 * @author alumne
 * @version 20160920
 */
public class ProductManagerApp {

    private String [] menuOptions =
        {"Exit",
         "List all products",
         "Find a product by code",
         "Find products by name",
         "Add new product"
        };//Array that contains the options of the menu
    
    private Store myStore;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProductManagerApp myApp = new ProductManagerApp();
        myApp.run();
        
    }

    /**
     * This method runs the code of the application
     */
    private void run() {
        
        boolean exit=false; //Flag to exit the app
        int optionSelected=0;
        
        myStore=new Store();
        loadData();
        
        do {
            optionSelected=showMenu();
            
            switch (optionSelected) {
                case 0://Exit
                    exit=true;
                    break;
                case 1://List all products
                    listAllProducts();
                    break;
                case 2://Find a product by its code
                    findProductByCode();
                    break;
                case 3://Find products by their name
                    findProductsByName();
                    break;
                case 4: //Add new product
                    addNewProduct();
                    break;
                default://Invalid option                    
                    System.out.println("Invalid option.");
                    break;
            };
            
        } while (!exit);
        
    }

    /**
     * Shows a menu to the user and asks for an option
     * @return the selected option or -1 in case of error
     */
    private int showMenu() {
        
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        
        for (int i=0; i<menuOptions.length; i++) {
            System.out.format("%d %s\n", i,menuOptions[i]);
        };
        System.out.print("Please, enter an option: ");
        int option;
        try {
            option = Integer.parseInt(reader.readLine());
        } catch (IOException ex) {
            //Logger.getLogger(ProductManagerApp.class.getName()).log(Level.SEVERE, null, ex);
            option=-1;
        } catch (NumberFormatException ex) {
            //Logger.getLogger(ProductManagerApp.class.getName()).log(Level.SEVERE, null, ex);
            option=-1;
        }
        
        return option;
    }

    /**
     * Method that lists all the products
     */
    private void listAllProducts() {
        
        displayStore(myStore);

    }

    /**
     * Method to instantiate test data
     */
    private void loadData() {
        myStore.add(new Tv("1","TV1",1000.,43));
        myStore.add(new Fridge("2","Fridge1",500., 120, true));
        myStore.add(new Product("3","Vacuum cleaner",100.));
        myStore.add(new Product("4","TV1",800.));
        myStore.add(new Product("5","TV1",700.));
        myStore.add(new Fridge("6","Fridge2",700., 150, false));
    }

    /**
     * Asks the user for a code and search a product with
     * that code in the store. If such product exists, shows it.
     * In case of error shows an error message.
     */
    private void findProductByCode() {
       //Ask the code
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the code of the product to search:");
       String code=sc.next();
       
       
       if (code == null) {
           System.out.println("Error reading the code.");
       }
       else {
           //Search the product
           Product p = myStore.find( new Product(code) );
           //Product p=myStore.findByCode(code);
           //Show the product
           if (p == null) {
               System.out.println("Product not found.");
           }
           else {
               System.out.println(p.toString());
           }
       }
       
       
       
       
    }

    
    /**
     * Asks the user to enter the name of the product to search.
     * Once the user has entered a valid name, it searches it in the list.
     * Finally, it reports the result to the user.
     */
    private void findProductsByName() {
        //Asks the user for the name of the product
        Scanner sc=new Scanner(System.in);
        System.out.print("Please, enter the name of the product:");
        String name=sc.next();
        
        //Search the product
        if (name==null) {
            System.out.println("Error reading the name.");
        }
        else {
            Store st = myStore.findByName(name);
            //Reports the result
            displayStore(st);    
        }
    }

    /**
     * Asks the user to input all the necessary data for a new product.
     * If a product has successfully created, it adds that product to the list.
     * Finally it reports the result to the user.
     */
    private void addNewProduct() {
        //Ask the user the type of product.
        String typeName = productTypeForm();
        if (typeName == null) {
            System.out.println("Error reading type of product.");
        }
        else {
            //Ask the user for the data of the new product.
            Product p = null;
            switch (typeName) {
                case "Product":
                    p = productForm();
                    break;
                case "Tv":
                    p = tvForm();
                    break;
                case "Fridge":
                    p = fridgeForm();
                    break;
                default:
                    System.out.println("Incorrect type of product");
                    break;
            }
            
            if (p==null) {
                System.out.println("Error reading product.");
            }
            else {
                //Adds the new product to the store.
                //Reports the result to the user.
                if (!myStore.add(p)) {
                    System.out.println("Error adding the product to the store.");
                }
                else {
                    System.out.println("Product successfully added.");
                }
            }            
        }
        
    }

    /**
     * Displays the content of a store
     * @param store the store to display
     */
    private void displayStore(Store store) {
                
        List<Product> listProd = store.getProducts();
        for (int i=0;i<store.getNumElements();i++) {
            System.out.println(listProd.get(i).toString());
        }
        System.out.format("%d products found.\n",
                          store.getNumElements());
    }

    /**
     * Form to enter the data for a new product.
     * @return a product with the data or null in case of error
     */
    private Product productForm() {
        Product p=null;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Code:");
        String code=sc.next();
        System.out.print("Name:");
        String name=sc.next();
        System.out.print("Price:");
        try {
            double price=sc.nextDouble();
            p = new Product(code,name,price);
        } catch (InputMismatchException e) {
            p=null;
        }
        
        return p;
    }

    /**
     * shows a list of types of products to the user 
     * and asks the user to choose one of them.
     * @return string with the type of product or null in case of error.
     */
    private String productTypeForm() {
        String typeSelected = null;
        String [] options = {"Product", "Tv", "Fridge"};
        System.out.println("====Product type form====");
        for (int i=0; i<options.length; i++) {
            System.out.format("[%d]. %s\n", i, options[i]);
        }
        System.out.print("Choose an option: ");
        Scanner sc = new Scanner(System.in);
        try {
            int optNumber = sc.nextInt();
            if (optNumber >= 0 && optNumber < options.length) {
                typeSelected = options[optNumber];           
            } else {
                typeSelected = null;
            }
        } catch (InputMismatchException e) {
            typeSelected = null;
        }

        return typeSelected;
    }

    /**
     * Form to enter the data for a new TV.
     * @return a tv with the data or null in case of error
     */
    private Product tvForm() {
        
        Tv t=null;
        
        Scanner sc = new Scanner(System.in);
        Product p = productForm();
        System.out.print("Number of inches:");
        try {
            int inches=sc.nextInt();
            t = new Tv(p,inches);
        } catch (InputMismatchException e) {
            t=null;
        }
            
        return t;
    }

    /**
     * Form to enter the data for a new fridge.
     * @return a fridge with the data or null in case of error
     */
    private Product fridgeForm() {
        Product p=null;
        //TODO
        return p;
    }
    
    
}//END OF CLASS
