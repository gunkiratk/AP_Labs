public class Bullet extends Two_wheeler{
	
	Bullet()
	{super(new Policy());
		getPol().setExpiry_date_day(8);
		getPol().setExpiry_date_month(12);
		getPol().setExpiry_date_year(2017);
		getPol().setPolicy_number(1521);
		setOwnerName("John");
		setModel("Bullet");
		setPolicyClass("Third policy");
		
	}
	public int assignment(long damage)
	{
		long day=getPol().getExpiryday();
		long month=getPol().getExpirymonth();
		long year=getPol().getExpiryyear();
		Third_policy pol2=new Third_policy();
		int check=pol2.Collision(damage,day,month,year);
		return check;

	}
	


}