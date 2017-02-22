public class Vehicle{
	
	private long number_of_wheels;
	private String owner_name;
	private Policy pol;
	private String policy_class;
	private String model;
	
	public void setWheels(int x)
	{	this.number_of_wheels=x;
	}
	public void setOwnerName(String x)
	{	this.owner_name=x;

	}
	public void setModel(String x)
	{	this.model=x;

	}
	public void setPolicyClass(String x)
	{	this.policy_class=x;

	}
	public long getWheels()
	{
		return number_of_wheels;
	}
	public String getOwnerName()
	{
		return owner_name;
	}
	public void setPol(Policy x)
	{	this.pol=x;

	}
	public String getPolicyClass()
	{	return policy_class;

	}
	public Policy getPol()
	{
		return pol;
	}
	public String getModel()
	{
		return model;
	}
	public int assignment(long damage)
	{	
		return -1;
		
	}

}








