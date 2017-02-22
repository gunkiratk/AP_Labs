public class Ferrari extends Four_wheeler{
	Ferrari()
	{	super(new Policy());
		getPol().setExpiry_date_day(6);
		getPol().setExpiry_date_month(6);
		getPol().setExpiry_date_year(2018);
		getPol().setPolicy_number(1239);
		setOwnerName("Susan");
		setModel("Ferrari");
		setPolicyClass("Package policy");
		
	}
	public int assignment(long damage)
	{
		long day=getPol().getExpiryday();
		long month=getPol().getExpirymonth();
		long year=getPol().getExpiryyear();
		Package_policy pol4=new Package_policy();
		int check=pol4.Collision(damage,day,month,year);
		return check;

	}

}