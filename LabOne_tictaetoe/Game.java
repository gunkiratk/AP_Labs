/*Author name:Gunkirat Kaur
*/
/*This is the Main Class*/
import java.util.Scanner;
import java.util.Random;
public class Game{
	private static int computer_move(char a[][])
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
		int num=rand_num.nextInt(count);
		return num;		
	}
	
	public static void main(String args[])
	{
		Board ttt=new Board();
		System.out.println("Enter your Choice");
		
		Scanner reader=new Scanner(System.in);
		int choice=reader.nextInt();
		
		if(choice==1)
		{	ttt.print();
			int check_status=0;
			int count_1=0;
			int count_2=0;
			while(check_status==0)
			{
			
		
				System.out.println("Coordinates of User1(O)");
				Scanner in_1=new Scanner(System.in);
				int x1=in_1.nextInt();
				int y1=in_1.nextInt();
				int put_check_1=ttt.put(x1,y1,'O');
				while(put_check_1==0)
				{
					System.out.println("Enter Coordinates Again");
					// Scanner read_1=new Scanner(System.in);
					x1=in_1.nextInt();
					y1=in_1.nextInt();
				// System.out.println(x1+" "+y1);
					put_check_1=ttt.put(x1,y1,'O');
				// System.out.println(check_status);
				}
				ttt.print();
				count_1++;
				check_status=ttt.checkState();
				if(check_status!=0)
					{
						break;
					}
				System.out.println("Coordinates of User2(X)");
				Scanner in_2=new Scanner(System.in);
				int x2=in_2.nextInt();
				int y2=in_2.nextInt();
				int put_check_2=ttt.put(x2,y2,'X');
				while(put_check_2==0)
				{
					System.out.println("Enter Coordinates Again");
					x2=in_2.nextInt();
					y2=in_2.nextInt();
				// System.out.println(x1+" "+y1);
					put_check_2=ttt.put(x2,y2,'X');

				}
				ttt.print();
				count_2++;
				check_status=ttt.checkState();

			// System.out.println(x1 + "  "+x2);
			}
	
			int diff=count_1-count_2;
			if(check_status==1)
			{
				if(diff==0)
					System.out.println("User 2 (X) Wins");
				else if(diff==1)
					System.out.println("User 1 (O) Wins");
			}
			else if(check_status==2)
				System.out.println("Tie");
		}
		else if(choice==2)
		{
			Random rand_num=new Random();
			int count_1,count_2;
			int num=rand_num.nextInt(2);
			// int num=0;
			if(num==0)
			{	System.out.println("Computer Playes First with O");
				count_1=0;
				count_2=0;
				int check_status=0;
				while(check_status==0)
				{
					int count=0;
					char arr[][]=ttt.get();
					Game A=new Game();
					int comp_num=A.computer_move(arr);
					// System.out.println(comp_num);
					int put_check_1;
					int put_check_2;
					for(int i=0;i<3;i++)
					{
						for(int j=0;j<3;j++)
						{	
							if(arr[i][j]=='-')
							{
								if(count==comp_num)
								{	
									// System.out.println("i:"+i+"j:"+j);
									put_check_1=ttt.put(i,j,'O');
									count++;
									break;
								}
								count++;
							}
						}
					}
					System.out.println("Computer(O):");
					count_1++;
					ttt.print();
					check_status=ttt.checkState();
					if(check_status!=0)
						{
							break;
						}
					System.out.println("Coordinates of User(X)");
					Scanner read_1=new Scanner(System.in);
					int x1=read_1.nextInt();
					int y1=read_1.nextInt();
					put_check_2=ttt.put(x1,y1,'X');
					while(put_check_2==0)
					{
						System.out.println("Enter Coordinates Again");
					// Scanner read_1=new Scanner(System.in);
						x1=read_1.nextInt();
						y1=read_1.nextInt();
				// System.out.println(x1+" "+y1);
						put_check_2=ttt.put(x1,y1,'X');
				// System.out.println(check_status);
					}
					System.out.println("User(X):");
					ttt.print();
					count_2++;
					check_status=ttt.checkState();
				}

			
				int diff=count_1-count_2;
				if(check_status==1)
				{
					if(diff==0)
						System.out.println("User (X) Wins");
					else if(diff==1)
						System.out.println("Computer (O) Wins");
				}
				else if(check_status==2)
					System.out.println("Tie");

			}

		
			else if(num==1)
			{	
				System.out.println("User Playes First with O");
				ttt.print();
				count_1=0;
				count_2=0;
				int check_status=0;
				int put_check_2;
				while(check_status==0)
				{
					
					System.out.println("Coordinates of User(O)");
					Scanner read_1=new Scanner(System.in);
					int x1=read_1.nextInt();
					int y1=read_1.nextInt();
					put_check_2=ttt.put(x1,y1,'O');
					while(put_check_2==0)
					{
						System.out.println("Enter Coordinates Again");
						// Scanner read_1=new Scanner(System.in);
						x1=read_1.nextInt();
						y1=read_1.nextInt();
					// System.out.println(x1+" "+y1);
						put_check_2=ttt.put(x1,y1,'O');
				// System.out.println(check_status);
					}
					System.out.println("User(O):");
					ttt.print();
					count_1++;
					check_status=ttt.checkState();
					if(check_status!=0)
					{
						break;
					}
					int count=0;
					char arr[][]=ttt.get();
					Game A=new Game();
					int comp_num=A.computer_move(arr);
					// System.out.println(comp_num);
					int put_check_1;
				
					for(int i=0;i<3;i++)
					{
						for(int j=0;j<3;j++)
						{	
							if(arr[i][j]=='-')
							{
								if(count==comp_num)
								{	
								// System.out.println("i:"+i+"j:"+j);
									put_check_1=ttt.put(i,j,'X');
									count++;
									break;
								}
								count++;
							}
						}
					}
					System.out.println("Computer(X):");
					count_2++;
					ttt.print();
					check_status=ttt.checkState();

				}

			
				int diff=count_1-count_2;
				if(check_status==1)
				{
					if(diff==1)
						System.out.println("User (O) Wins");
					else if(diff==0)
						System.out.println("Computer (X) Wins");
				}
				else if(check_status==2)
					System.out.println("Tie");

			}	

		}	
	
		else if(choice==3)
		{	int count_1,count_2;
			System.out.println("Computer Plays first with O");
			count_1=0;
			count_2=0;
			int check_status=0;
			while(check_status==0)
			{
				int count=0;
				char arr[][]=ttt.get();
				Game A=new Game();
				int comp_num=A.computer_move(arr);
					// System.out.println(comp_num);
				int put_check_1;
				int put_check_2;
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{	
						if(arr[i][j]=='-')
						{
							if(count==comp_num)
							{	
								// System.out.println("i:"+i+"j:"+j);
								put_check_1=ttt.put(i,j,'O');
								count++;
								break;
							}
							count++;
						}
					}
				}
				System.out.println("Computer(O):");
				count_1++;
				ttt.print();
				check_status=ttt.checkState();
				if(check_status!=0)
				{
					break;
				}
				ttt.ai_move();
				System.out.println("AI User(X):");
				count_2++;
				ttt.print();
				check_status=ttt.checkState();
			}
			int diff=count_1-count_2;
			if(check_status==1)
			{
				if(diff==0)
					System.out.println("AI User (X) Wins");
				else if(diff==1)
					System.out.println("Computer (O) Wins");
			}
			else if(check_status==2)
				System.out.println("Tie");

		}
		else if(choice==4)
		{
			Random rand_num=new Random();
			int count_1,count_2;
			int put_check_2;
			int num=rand_num.nextInt(2);
			if(num==0)
			{
				// int count_1,count_2;
				System.out.println("User Plays first with O");
				count_1=0;
				count_2=0;
				int check_status=0;
				while(check_status==0)
				{
					System.out.println("Coordinates of User(O)");
					Scanner read_in_1=new Scanner(System.in);
					int x1=read_in_1.nextInt();
					int y1=read_in_1.nextInt();
					put_check_2=ttt.put(x1,y1,'O');
					while(put_check_2==0)
					{
						System.out.println("Enter Coordinates Again");
						// Scanner read_1=new Scanner(System.in);
						x1=read_in_1.nextInt();
						y1=read_in_1.nextInt();
					// System.out.println(x1+" "+y1);
						put_check_2=ttt.put(x1,y1,'O');
				// System.out.println(check_status);
					}
					System.out.println("User(O):");
					ttt.print();
					count_1++;
					check_status=ttt.checkState();
					if(check_status!=0)
					{
						break;
					}
					ttt.ai_move();
					System.out.println("AI CPU(X):");
					count_2++;
					ttt.print();
					check_status=ttt.checkState();
			
				}
				int diff=count_1-count_2;
				if(check_status==1)
				{
					if(diff==0)
						System.out.println("AI CPU (X) Wins");
					else if(diff==1)
						System.out.println("User (O) Wins");
				}
				else if(check_status==2)
					System.out.println("Tie");
			}
			else if(num==1)
			{
				// int count_1,count_2;
				System.out.println("AI CPU Plays first with X");
				count_1=0;
				count_2=0;
				int check_status=0;
				while(check_status==0)
				{
					ttt.ai_move();
					System.out.println("AI User(X):");
					count_1++;
					ttt.print();
					check_status=ttt.checkState();
					if(check_status!=0)
					{
						break;
					}
					System.out.println("Coordinates of User(O)");
					Scanner read_in_1=new Scanner(System.in);
					int x1=read_in_1.nextInt();
					int y1=read_in_1.nextInt();
					put_check_2=ttt.put(x1,y1,'O');
					while(put_check_2==0)
					{
						System.out.println("Enter Coordinates Again");
						// Scanner read_1=new Scanner(System.in);
						x1=read_in_1.nextInt();
						y1=read_in_1.nextInt();
					// System.out.println(x1+" "+y1);
						put_check_2=ttt.put(x1,y1,'O');
				// System.out.println(check_status);
					}
					System.out.println("User(O):");
					ttt.print();
					count_2++;
					check_status=ttt.checkState();
				}
				int diff=count_1-count_2;
				if(check_status==1)
				{
					if(diff==1)
						System.out.println("AI CPU (X) Wins");
					else if(diff==0)
						System.out.println("User (O) Wins");
				}
				else if(check_status==2)
					System.out.println("Tie");

			}	


		}

		
	}

}