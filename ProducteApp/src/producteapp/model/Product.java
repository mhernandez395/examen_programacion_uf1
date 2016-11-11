package cat.proven.productmanager.model;

import java.util.Objects;

/**
 * This class encapsulates all data of Product objects
 * @author alumne
 */
public class Product {
 
    //Attributes
    private String code;
    private String name;
    private double price;
    
    //Constructors
    
    /**
     * Full initializer constructor
     * @param code
     * @param name
     * @param price 
     */
    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    
    /**
     * Constructor with code
     * @param code 
     */
    public Product(String code) {
        this.code = code;
    }
    
    /**
     * Void constructor
     */
    public Product() {
    }
    
    /**
     * Copy constructor
     * @param other 
     */
    public Product (Product other) {
        this.code=other.code;
        this.name=other.name;
        this.price=other.price;
    }
    
    //Accessors

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    //Methods

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.code);
        return hash;
    }

    /**
     * Two products are considered equals if they have the same code.
     * @param obj
     * @return true if 'this' is equal to 'obj', false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        
        if (obj==null) b=false; //Null object
        else {
            if (this==obj) b=true;  //Same object
            else {
                if (obj instanceof Product) {
                    Product other = (Product)obj;
                    b=this.code.equals(other.code);
                }
                else b=false;
            }
        }
        return b;
    }

    /**
     * Method to serialize the data of an object into a string
     * @return a string with the data serialized
     */
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("Product{code=");
        sb.append(code);
        sb.append(", name=");
        sb.append(name);
        sb.append(", price=");
        sb.append(price);
        sb.append("}");
        
        return sb.toString();
    }

} //END OF CLASS
