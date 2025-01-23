package servicestation.code;


import java.io.Serializable;

abstract public class Service implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	public String desc;
	
	public String getDesc() {
		return desc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		return result;
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
