
/*Author name:Gunkirat Kaur
*/
import java.util.Random;
public class Board
{
	private char grid[][]=new char[3][3];
	Board()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				grid[i][j]='-';
			}
		}
	}
	
	public int checkState(char grid[][])
	{
		int check=0;
		if((grid[0][0]==grid[0][1] && grid[0][1]==grid[0][2] && grid[0][2]=='O' )||(grid[1][0]==grid[1][1] && grid[1][1]==grid[1][2] && grid[1][2]=='O')||(grid[2][0]==grid[2][1] && grid[2][1]==grid[2][2] && grid[2][2]=='O'))	
			{	
				check=1;
			}
		else if((grid[0][0]==grid[0][1] && grid[0][1]==grid[0][2] && grid[0][2]=='X' )||(grid[1][0]==grid[1][1] && grid[1][1]==grid[1][2] && grid[1][2]=='X')||(grid[2][0]==grid[2][1] && grid[2][1]==grid[2][2] && grid[2][2]=='X'))	
			{	
				check=1;
			}
		else if ((grid[0][0]==grid[1][0] && grid[1][0]==grid[2][0] && grid[2][0]=='O')||(grid[0][1]==grid[1][1] && grid[1][1]==grid[2][1] && grid[2][1]=='O')||(grid[0][2]==grid[1][2] && grid[1][2]==grid[2][2] && grid[2][2]=='O')) 
		{
			
			check=1;
		}
		else if ((grid[0][0]==grid[1][0] && grid[1][0]==grid[2][0] && grid[2][0]=='X')||(grid[0][1]==grid[1][1] && grid[1][1]==grid[2][1] && grid[2][1]=='X')||(grid[0][2]==grid[1][2] && grid[1][2]==grid[2][2] && grid[2][2]=='X')) 
		{
			
			check=1;
		}

		else if((grid[0][2]==grid[1][1] && grid[1][1]==grid[2][0]  && grid[2][0]=='O')||(grid[0][0]==grid[1][1] && grid[1][1]==grid[2][2]	&& grid[2][2]=='O'))
			{	
				check=1;
			}
		else if((grid[0][2]==grid[1][1] && grid[1][1]==grid[2][0]  && grid[2][0]=='X')||(grid[0][0]==grid[1][1] && grid[1][1]==grid[2][2]	&& grid[2][2]=='X'))
			{
				check=1;
			}
		else
		{
			int flag=0;
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(grid[i][j]=='-')
						flag++;
				}
			}
			if(flag==0)
				check=2;
			else
				check=0;
		}
		return check;
	}
	
	public int computer_move(char a[][])
	{	int count=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(a[i][j]=='-')
					count++;
			}
		}
		// System.out.println(count);
		Random rand_num=new Random();
		if(count==0)
			return -1;
		else
			{int num=rand_num.nextInt(count);
		return num;	
			}
	}
	protected void ai_move(char grid[][])
	{	int check=0;
		
		int count;
		
		for(int i=0;i<3&&check==0;i++)
		{	count=0;
			for(int j=0;j<3;j++)
			{
				if(grid[i][j]=='O')
					count++;
			}
			if(count==2)
			{
				for(int j=0;j<3;j++)
				{
					if(grid[i][j]=='-')
					{
						grid[i][j]='O';
						check=1;
					}		

				}
			}
		
		}
		for(int i=0;i<3&&check==0;i++)
		{	count=0;
			for(int j=0;j<3;j++)
			{
				if(grid[j][i]=='O')
					count++;
			}
			if(count==2)
			{
				for(int j=0;j<3;j++)
				{
					if(grid[j][i]=='-')
					{
						grid[j][i]='O';
						check=1;
					}		

				}
			}
		}
		if(check==0)
		{	count=0;
			for(int i=0,j=0;i<3;i++,j++)
			{	
				if(grid[i][j]=='O')
					count++;
			}
			if(count==2)
			{
				for(int i=0,j=0;i<3;i++,j++)
				{
					if(grid[i][j]=='-')
					{
						grid[i][j]='O';
						check=1;
					}	

				}
			}
		}	
		if(check==0)
		{	count=0;
			for(int i=0,j=2;i<3;i++,j--)
			{	
				if(grid[i][j]=='O')
					count++;
			}
			if(count==2)
			{
				for(int i=0,j=2;i<3;i++,j--)
				{
					if(grid[i][j]=='-')
					{
						grid[i][j]='O';
						check=1;
					}	

				}
			}
		}
		for(int i=0;i<3&&check==0;i++)
		{	count=0;
			for(int j=0;j<3;j++)
			{
				if(grid[i][j]=='X')
					count++;
			}
			if(count==2)
			{
				for(int j=0;j<3;j++)
				{
					if(grid[i][j]=='-')
					{
						grid[i][j]='O';
						check=1;
					}		

				}
			}
		

		}
		for(int i=0;i<3&&check==0;i++)
		{	count=0;
			for(int j=0;j<3;j++)
			{
				if(grid[j][i]=='X')
					count++;
			}
			if(count==2)
			{
				for(int j=0;j<3;j++)
				{
					if(grid[j][i]=='-')
					{
						grid[j][i]='O';
						check=1;
					}		

				}
			}
		}
		if(check==0)
		{	count=0;
			for(int i=0,j=0;i<3;i++,j++)
			{	
				if(grid[i][j]=='X')
					count++;
			}
			if(count==2)
			{
				for(int i=0,j=0;i<3;i++,j++)
				{
					if(grid[i][j]=='-')
					{
						grid[i][j]='O';
						check=1;
					}	

				}
			}
		}
		if(check==0)
		{	count=0;
			for(int i=0,j=2;i<3;i++,j--)
			{
				if(grid[i][j]=='X')
					count++;
			}
			if(count==2)
			{
				for(int i=0,j=2;i<3;i++,j--)
				{
					if(grid[i][j]=='-')
					{
						grid[i][j]='O';
						check=1;
					}	

				}
			}
		}
		if(check==0 && grid[1][1]=='-')
		{
			grid[1][1]='O';
			check=1;
		}
		else if(check==0 && grid[0][0]=='-')
		{
			grid[0][0]='O';
			check=1;
		}
		else if(check==0 && grid[0][2]=='-')
		{
			grid[0][2]='O';
			check=1;
		}
		else if(check==0 && grid[2][0]=='-')
		{
			grid[2][0]='O';
			check=1;
		}
		else if(check==0 && grid[2][2]=='-')
		{
			grid[2][2]='O';
			check=1;
		}	
		else if(check==0 && grid[0][1]=='-')
		{
			grid[0][1]='O';
			check=1;
		}
		else if(check==0 && grid[1][0]=='-')
		{
			grid[1][0]='O';
			check=1;
		}
		else if(check==0 && grid[2][1]=='-')
		{
			grid[2][1]='O';
			check=1;
		}
		else if(check==0 && grid[1][2]=='-')
		{
			grid[1][2]='O';
			check=1;
		}


	}

}
