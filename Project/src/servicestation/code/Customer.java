package servicestation.code;



import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class Customer implements Serializable {
	
    private String customerId;
    private String name;
    private String address;
	private int mobile1;
    private HashMap<String, Vehicle> vehicleList;

    public Customer(String customerId, String name,String address , int mobile1 ) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
		this.mobile1 = mobile1;
        this.vehicleList = new HashMap<>();
    }

    
    public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getMobile1() {
		return mobile1;
	}


	public void setMobile1(int mobile1) {
		this.mobile1 = mobile1;
	}


	public HashMap<String, Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.put(vehicle.getVehicleId(), vehicle);
    }


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", mobile1=" + mobile1
				+ ", vehicleList=" + vehicleList + "]";
	}

   
}
