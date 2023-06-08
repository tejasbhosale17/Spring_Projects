package operations.models;

public class Vehicle {

	int vehicle_id;
	String company;
	String model;
	
	public Vehicle(int vid, String company, String model) {
		super();
		this.vehicle_id = vid;
		this.company = company;
		this.model = model;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getVid() {
		return vehicle_id;
	}
	public void setVid(int vid) {
		this.vehicle_id = vid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vid=" + vehicle_id + ", company=" + company + ", model=" + model + "]";
	}
}
