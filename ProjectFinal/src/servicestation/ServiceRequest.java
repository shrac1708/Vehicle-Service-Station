package servicestation;



import java.io.Serializable;
import java.util.LinkedList;

public class ServiceRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Service> serviceList;
	private String customerName;
	private String vehicleNumber;
	public ServiceRequest() {
		serviceList=new LinkedList<Service>();
	}
	public ServiceRequest(String customerName, String vehicleNumber) {
		super();
		serviceList=new LinkedList<Service>();
		this.customerName = customerName;
		this.vehicleNumber = vehicleNumber;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public LinkedList<Service> getServiceList() {
		return serviceList;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	
	public void newService(Service s)
	{
		this.serviceList.add(s);
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setServiceList(LinkedList<Service> serviceList) {
		this.serviceList = serviceList;
	}
	
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	@Override
	public String toString() {
		return "ServiceRequest [serviceList=" + serviceList + ", customerName="
				+ customerName + ", vehicleNumber=" + vehicleNumber + "]";
	}
}
