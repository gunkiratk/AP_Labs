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
	public int put(int x,int y, char val)
	{
		if(x<3 && y<3 && grid[x][y]=='-')
			{
				grid[x][y]=val;
				return 1;
			}	
		else
			{
				System.out.println("Invalid Coordinates");
				return 0;
			}	
	}

	public char[][] get()
	{
		return grid;
	}

	public void print()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public int checkState()
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
	protected void ai_move()
	{	int check=0;
		
		int count;
		
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
						grid[i][j]='X';
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
						grid[j][i]='X';
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
						grid[i][j]='X';
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
						grid[i][j]='X';
						check=1;
					}	

				}
			}
		}
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
						grid[i][j]='X';
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
						grid[j][i]='X';
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
						grid[i][j]='X';
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
						grid[i][j]='X';
						check=1;
					}	

				}
			}
		}
		if(check==0 && grid[1][1]=='-')
		{
			grid[1][1]='X';
			check=1;
		}
		else if(check==0 && grid[0][0]=='-')
		{
			grid[0][0]='X';
			check=1;
		}
		else if(check==0 && grid[0][2]=='-')
		{
			grid[0][2]='X';
			check=1;
		}
		else if(check==0 && grid[2][0]=='-')
		{
			grid[2][0]='X';
			check=1;
		}
		else if(check==0 && grid[2][2]=='-')
		{
			grid[2][2]='X';
			check=1;
		}	
		else if(check==0 && grid[0][1]=='-')
		{
			grid[0][1]='X';
			check=1;
		}
		else if(check==0 && grid[1][0]=='-')
		{
			grid[1][0]='X';
			check=1;
		}
		else if(check==0 && grid[2][1]=='-')
		{
			grid[2][1]='X';
			check=1;
		}
		else if(check==0 && grid[1][2]=='-')
		{
			grid[1][2]='X';
			check=1;
		}


	}

}