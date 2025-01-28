package servicestation;



import java.io.Serializable;

abstract public class Service implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String desc;
	
	
	public String getDesc() {
		return desc;
	}
	
	
	public abstract double price();
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Service [desc=" + desc + "]";
	}
}
