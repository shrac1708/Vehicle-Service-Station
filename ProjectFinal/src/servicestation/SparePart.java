package servicestation;


import java.io.Serializable;

public class SparePart implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String desc;
	public double rate;
	public SparePart(String desc, double rate) {
		super();
		this.desc = desc;
		this.rate = rate;
	}
	
	public String getDesc() {
		return desc;
	}
	public double getRate() {
		return rate;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "SparePart [desc=" + desc + ", rate=" + rate + "]";
	}
}
