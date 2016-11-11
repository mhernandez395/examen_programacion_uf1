package cat.proven.productmanager.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumne
 */
public class Store extends ArrayList<Product>  {
    
    //Attributes
    //private List<Product> products;
    
    
    //Constructors

    /**
     * Constructor 
     */
    public Store() {       
        //this.products    = new ArrayList<>();      
    }
    
    //Accessors

    public List<Product> getProducts() {
        return this;
    }


    public int getNumElements() {
        return this.size();
    } 
    
    //Methods
    /**
     * Adds a given product to the array of products if there
     * is enough space left and returns 0. If it fails returns -1.
     * It prevents from repeated codes.
     * @param p
     * @return 0 if successfully added, -1 otherwise
     */
//    public int add(Product p) {
//        
//        int result=0;
//       
//        if (p==null || products.contains(p)) result=-1;
//        else {
//            if (products.add(p)) result=0;
//            else result=-1;
//        }
//        
//        return result;
//    }

    @Override
    public boolean add(Product p) {
        boolean result=true;
       
        if (p==null || contains(p)) result=false;
        else {
            if (super.add(p)) result=true;
            else result=false;
        }
        
        return result;
        
    }
    
    /**
     * Find a product by code
     * @param code the code of the product searched for in the list
     * @return a product with the given code or null if it not exists
     */
    public Product findByCode(String code) {
    
        Product p=new Product(code);
        int position=this.indexOf(p);
        if (position==-1) p=null;
        else p=this.get(position);
        
        return p;
    }

    /**
     * Finds a product in the array
     * @param product product to find
     * @return the product searched or null if it doesn't exist
     */
    public Product find(Product product) {
        Product p=null;
        
        int pos=this.indexOf(product);
        if (pos==-1) p=null;
        else {
            p=this.get(pos);
        }
        
        return p;
    }

    /**
     * Find products with the given name.
     * @param name the name to search
     * @return an object store containing all the products with 
     *         the given name or an empty store if not found.
     */
    public Store findByName(String name) {
        
        Store st=new Store();
        
        for (int i=0;i<size(); i++){
            if (get(i).getName().equals(name)) {
                st.add(get(i));
            }
        }
        
        return st;
    }

//    public Product get(int i) {
//        return get(i);
//    }
    
} //END OF CLASS
