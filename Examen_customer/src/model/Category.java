package model;

import java.util.*;

public class Category {

	private String id;
	private String description;
	private List<Customer> customers;
	
	
        
        public Customer findCustomerByPhone (String Phone){
            Customer c = new Customer();
            for (Customer customer : customers) {
                if (customer.getPhone().equals(Phone)) {
                    c = customer;
                    break;
                }
                else c = null;
            }
            return c;
        }
        public boolean add(Customer c)
        {
            boolean result = true;
            for (Customer customer : customers) {
                if (customer.getCustomerCode()== c.getCustomerCode()) {
                    result = false;
                    break;
                }
            }
            if (result) {
                customers.add(c);
               
            }
            return result;
        }
        
        public Category(String id, String description) {
		super();
		this.id = id;
		this.description = description;
		customers = new ArrayList<Customer>();
	}

    public Category() {
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
        
        public List getCustomer() {
		return customers;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("-------"+description+"-------");
		builder.append("\n");
		builder.append(customers);
		return builder.toString();
	}

    public boolean removeCustomer(Customer f) {
        boolean ok = false;
            for (Customer customer : customers) {
                if (customer.getPhone().equals(f.getPhone())) {
                    customers.remove(f);
                    ok = true;
                    break;
                }
        }
        return ok;
    }


	
}
