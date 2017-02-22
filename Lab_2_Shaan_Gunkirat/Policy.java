class Policy
{ 
	private long expiry_date_day;
	private long expiry_date_month;
	private long expiry_date_year;
	private long policy_number;
	
	public void setExpiry_date_day(int x)
	{	this.expiry_date_day=x;
	}
	public void setExpiry_date_month(int x)
	{	this.expiry_date_month=x;
	}
	public void setExpiry_date_year(int x)
	{	this.expiry_date_year=x;
	}
	public void setPolicy_number(int x)
	{	this.policy_number=x;
	}
	public long getExpiryday()
	{
		return expiry_date_day;
	}
	public long getExpirymonth()
	{
		return expiry_date_month;
	}
	public long getExpiryyear()
	{
		return expiry_date_year;
	}
	public long getPolicynumber()
	{
		return policy_number;
	}

}

