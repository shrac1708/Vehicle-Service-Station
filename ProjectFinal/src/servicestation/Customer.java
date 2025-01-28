package servicestation;



import java.io.Serializable;
import java.util.HashMap;

public class Customer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String,Vehicle> vehList;
	private String name;
	private String mobile;
	private String address;	
	private double lastBalance;
	public Customer() 
	{
		this.vehList=new HashMap<String, Vehicle>();
		this.lastBalance=0;
	}
	
	public String getAddress() {
		return address;
	}
	public double getLastBalance() {
		return lastBalance;
	}
	public String getMobile() {
		return mobile;
	}
	public String getName() {
		return name;
	}
	public Vehicle getVehicle(String number)
	{
		return vehList.get(number);
	}
	public HashMap<String,Vehicle> getVehicleList()
	{
		return this.vehList;
	}
	
	public void newVehicle(Vehicle v)
	{
		this.vehList.put(v.number, v);
	}
	public double payBill(Bill b,double x)
	{
		b.setPaidAmount(x);
		this.setLastBalance(this.getLastBalance()+b.computeTotalBill()-x);
		return this.getLastBalance();
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setLastBalance(double lastBalance) {
		this.lastBalance = lastBalance;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobile=" + mobile + ", address="
				+ address + ", lastBalance=" + lastBalance + "]";
	}
}
