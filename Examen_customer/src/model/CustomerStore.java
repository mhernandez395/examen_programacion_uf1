package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* FriendsStore.java
* Stores contacts.
* @author Jose Moreno
* @version 
*/

public class CustomerStore {
	
	//TODO
	// ...
    private ArrayList <Category> categories = new ArrayList();
    
        public void addCategory(Category c)
        {
            
            categories.add(c);
        }
        
        public Category getCategory(String cat)
        {
            Category result =  null;
            for (Category category : categories) {
                if (category.getId().equals(cat)){
                    result = category;
                    break;
                }
             }
            return result;
        }
        
	public void printCategoies(){
            for (Category category : categories) {
                System.out.print(category.getId()+"-");
                System.out.println(category.getDescription());
            }
        }
	public boolean add (Category c, Customer f) {
		//TODO
		boolean result = false;
                result = c.add(f);
           
                return result;
	}
        public ArrayList resturnCustomers (){
        
            return categories;
        }
		
	public boolean remove (Customer f) {
            
            boolean ok = false;
		          for (Category category : categories) {
                            ok = category.removeCustomer(f);
                              if (ok) {
                                  break;
                              }
                           }
		return ok;
	}
	
	public Customer findByPhone (String phone) {
		Customer f=null;
		          for (Category category : categories) {
                              if (category.findCustomerByPhone(phone)!=null) {
                                  f = category.findCustomerByPhone(phone);
                                  break;
                              }
                          }
		return f;
		}
		
	//TODO
	//...
        

    public void saveData()
    {
        List customersList = new ArrayList();
        FileWriter file = null;
        PrintWriter pw = null;
        try
        {
            file = new FileWriter("files/customers.txt");
            pw = new PrintWriter(file);
            
            for (Category category : categories) {
              
                customersList = category.getCustomer();
                for (Object object : customersList) {
                    String customerCSV = toCsv((Customer) object, ";");
                    pw.println(customerCSV);
                }
            }
              pw.close();
    
          
        } 
        catch (Exception e) 
        {
            System.out.println("Error. Try again.");
        }
    }
    
    /** Open a file and read all the data. Then creates a customer for each readed line
     * @author 
     * @version 1.0
     */
    public void loadData()
    {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try 
        {
            file = new File ("files/customers.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);
            String line;
            Customer c = null;
            Category category = null;
            
            while((line=br.readLine())!=null)
            {   
                
                c = fromCsvPerson(line,";");
                category = getCategory(c.getCategory());
                add(category,c);
            }
            br.close();
            fr.close();
        }
        catch(Exception e)
        {
            System.out.println("Error. Try again.");
        }
    }
    
    
    /** Converts object to CSV.
     * @author 
     * @param Person obj: object to be converted.
     * @param String delimiter: delimiter to be used between fields.
     * @return String with object data in CSV format.
     */
    public static String toCsv(Customer obj, String delimiter) 
    {   
        
        
        String d = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", obj.getCategory(), delimiter, obj.getName(), delimiter, obj.getCustomerCode(), delimiter, obj.getPhone(), delimiter,obj.getAddress().getStreet(), delimiter, obj.getAddress().getNumber(), delimiter, obj.getAddress().getCity(),delimiter, obj.getAddress().getZipcode(), delimiter);
	return d;
    }
    
    /** Converts CSV String to object.
     * @author 
     * @param String s: string to be converted.
     * @param String delimiter: delimiter to be used between fields.
     * @return Person object with data contained in String s.
     */
    public static Customer fromCsvPerson(String s, String delimiter) 
    {
	int objNumFields = 8;  //number of attributes of Person.
	Customer p = null;
	String [] tokens = s.split(delimiter);
	if (tokens.length == 8) 
        { 
        String category= tokens[0];
	String name= tokens[1];
	int customerCode= Integer.parseInt(tokens[2]) ;
	String phone= tokens[3];
        String street= tokens[4];
	String number= tokens[5];
	String city= tokens[6];
	String zipcode= tokens[7];
        
        Address address = new Address(street,number,city,zipcode);
        p = new Customer(category, name, customerCode, phone,address); 
	}
	else p = null;
        
	return p;
    }
}
