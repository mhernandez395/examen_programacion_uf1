package model;


public class Customer {
	
        private String category;
	private String name;
	private int customerCode;
	private String phone;
	private Address address;
	
        public Customer() {
    }
	public Customer(String category,String name, int customerCode, String phone, Address address) {
		super();
                this.category = category;
		this.name = name;
		this.customerCode = customerCode;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerCode() {
		return customerCode;
	}

    public String getCategory() {
        return category;
    }

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Customer other = (Customer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name=");
		builder.append(name);
		builder.append(", customerCode=");
		builder.append(customerCode);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(address);
		return builder.toString();
	}


	
}
