package operations.models;

public class Customer {
	int customer_id;
	String customer_name;
	Long mobile;
	String email;
	String address;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customer_id, String customer_name, Long mobile, String email, String address) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", mobile=" + mobile
				+ ", email=" + email + ", address=" + address + "]";
	}
	
}
