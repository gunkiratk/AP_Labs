public class Cadillac extends Four_wheeler{
	
	Cadillac()
	{	super(new Policy());
		getPol().setExpiry_date_day(3);
		getPol().setExpiry_date_month(6);
		getPol().setExpiry_date_year(2013);
		getPol().setPolicy_number(1896);
		setOwnerName("Rohan");
		setModel("Cadillac");
		setPolicyClass("Package policy");
		
	}
	public int assignment(long damage)
	{
		long day=getPol().getExpiryday();
		long month=getPol().getExpirymonth();
		long year=getPol().getExpiryyear();
		Package_policy pol3=new Package_policy();
		int check=pol3.Collision(damage,day,month,year);
		return check;

	}
	


}