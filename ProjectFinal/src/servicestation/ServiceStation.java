package servicestation;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ServiceStation implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final ServiceStation station=new ServiceStation();
	public static final String billFilePath="bills.txt";
	public static final String custFilePath="customers.txt";
	public final String name="Vehicle Station";
	private HashSet<Customer> custList;
	private LinkedList<Bill> billList;
	
	private ServiceStation() {
		this.custList=new HashSet<>();
		this.billList=new LinkedList<>(); 
	}
	public double computeCash(Date d)
	{
		double c=0;
		for(Bill b : this.billList)
			if(new SimpleDateFormat("dd/MM/yyyy").format(d).equals(new SimpleDateFormat("dd/MM/yyyy").format(b.getBillDate())))
				c+=b.getPaidAmount();
		return c;
	}
	
	public Customer findCustomer(String s)
	{
		for(Customer c : this.custList)
			if(c.getName().equals(s))
				return c;
		return null;
	}
	public LinkedList<Bill> getBillList() 
	{
		return billList;
	}
	List<Bill> getBillList(Date d)
	{
		LinkedList<Bill> list=new LinkedList<Bill>();
		for(Bill b : this.billList)
			if(b.getBillDate().equals(d))
				list.add(b);
		return list;
	}
	public HashSet<Customer> getCustList()
	{
		return this.custList;
	}
	
	@SuppressWarnings("unchecked")
	public void loadBillDetails() throws IOException, ClassNotFoundException
	{
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream(ServiceStation.billFilePath);
		}
		catch(Exception e)
		{
			new ObjectOutputStream(new FileOutputStream(ServiceStation.billFilePath)).writeObject(this.billList);;
			fis=new FileInputStream(ServiceStation.billFilePath);	
		}
		finally
		{
			ObjectInputStream ois=new ObjectInputStream(fis); 
			this.billList=(LinkedList<Bill>) ois.readObject(); 
			fis.close();
			ois.close();
		}
	}
	@SuppressWarnings("unchecked")
	public void loadCustDetails() throws IOException, ClassNotFoundException
	{
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream(ServiceStation.custFilePath);
		}
		catch(Exception e)
		{
			new ObjectOutputStream(new FileOutputStream(ServiceStation.custFilePath)).writeObject(this.custList);
			fis=new FileInputStream(ServiceStation.custFilePath);
		}
		finally
		{
			ObjectInputStream ois=new ObjectInputStream(fis); 
			this.custList=(HashSet<Customer>)ois.readObject(); 
			fis.close();
			ois.close();
		}
		
	}
	void newBill(Bill b)
	{
		this.billList.add(b);
	}
	public Bill newBill(ServiceRequest s)
	{
		Bill b=new Bill();
		b.setBillDate(new Date());
		b.setRequest(s);
		newBill(b);
		return b;
	}
	public void newCustomer(Customer c)
	{
		this.custList.add(c);
	}
	public ServiceRequest newRequest(String customerName,String vehicleNumber)
	{
		return new ServiceRequest(customerName,vehicleNumber);
	}
	public void storeBillDetails() throws IOException
	{
		FileOutputStream fos=new FileOutputStream(ServiceStation.billFilePath);
		ObjectOutputStream oos=new ObjectOutputStream(fos); 
		oos.writeObject(this.billList);
		oos.close();
	}
	public void storeCustDetails() throws IOException
	{
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(ServiceStation.custFilePath)); 
		oos.writeObject(this.custList);
		oos.close();
	}
	@Override
	public String toString() {
		return "ServiceStation [name=" + name + ", custList=" + custList
				+ ", billList=" + billList + "]";
	}
	
}
