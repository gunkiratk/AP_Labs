public class Package_policy extends Policy
{	int Compare(long day,long month,long year)
	{	
		if(year>2016)
			return 1;
		else if(year==2016)
		{
			if(month>8)
				return 1;
			else if(month==8)
			{	
				if(day>27)
					return 1;
				else if(day==27)
					return 1;
				else return 0;

			}
			else return 0;
		}	
		else return 0;
			
	}
	
	int Collision(long x,long day,long month,long year)
	{	
		if(Compare(day,month,year)==1)
		{
			return 2;//2 is for 80% damage paid by the policy(oncomming) and 50% on self
		}
		else return 0;//Exception

	}
}
