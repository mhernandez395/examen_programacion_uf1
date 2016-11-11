
package cat.proven.productmanager.model;

/**
 *
 * @author alumne
 */
public class Tv extends Product {
    
    private int inches;

    public Tv(String code, String name, double price, int inches) {
        super(code, name, price);
        this.inches = inches;
    }

    public Tv(Product other, int inches) {
        super(other);
        this.inches = inches;
    }
    
    public Tv(Tv other) {
        super(other);
        this.inches=other.inches;
    }

    public Tv(String code) {
        super(code);
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TV: {");
        sb.append(super.toString());
        sb.append(", inches=");
        sb.append(inches);
        sb.append("}");
        return sb.toString();
    }
    
}//END OF CLASS
