package cat.proven.productmanager.model;

/**
 * TAD for object fridge.
 * @author alumne
 */
public class Fridge extends Product {
    
    //Attributes
    
    private int capacity;
    private boolean noFrost;

    //Constructors
    
    public Fridge(String code, String name, double price, int capacity, boolean noFrost) {
        super(code, name, price);
        this.capacity = capacity;
        this.noFrost = noFrost;
    }

    public Fridge() {
    }

    public Fridge(Product other, int capacity, boolean noFrost) {
        super(other);
        this.capacity = capacity;
        this.noFrost = noFrost;
    }
    
    public Fridge(String code) {
        super(code);
    }   
    
    public Fridge(Fridge other) {
        super(other);
        this.capacity = other.capacity;
        this.noFrost = other.noFrost;
    }
    
    //Accessors

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isNoFrost() {
        return noFrost;
    }

    public void setNoFrost(boolean noFrost) {
        this.noFrost = noFrost;
    }
    
    //Methods

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fridge: {");
        sb.append(super.toString());
        sb.append(", capacity=");
        sb.append(capacity);
        sb.append(", noFrost=");
        sb.append(noFrost);
        sb.append("}");
        return sb.toString();        
    }
    
    
    
}
