public class Harley_Davidson extends Two_wheeler{
	
	Harley_Davidson()
	{	super(new Policy());
		getPol().setExpiry_date_day(4);
		getPol().setExpiry_date_month(5);
		getPol().setExpiry_date_year(2014);
		getPol().setPolicy_number(0123);
		setOwnerName("Richard");
		setModel("Harley Davidson");
		setPolicyClass("Third policy");
		
	}
	public int assignment(long damage)
	{
		long day=getPol().getExpiryday();
		long month=getPol().getExpirymonth();
		long year=getPol().getExpiryyear();
		Third_policy pol1=new Third_policy();
		int check=pol1.Collision(damage,day,month,year);
		return check;

	}
	
}