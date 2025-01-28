package servicestation;


import java.io.Serializable;

public class Vehicle implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String company;
	public String model;
	public String number;
	
	public String getCompany() {
		return company;
	}
	public String getModel() {
		return model;
	}
	public String getNumber() {
		return number;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Vehicle [company=" + company + ", model=" + model + ", number="
				+ number + "]";
	}
}


