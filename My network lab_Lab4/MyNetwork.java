import java.util.*;
import java.io.*;
public class MyNetwork{
	 public static int check(ArrayList<Person> arr,int n,String x)
	{int check_point=0;
		for(int i=0;i<n;i++)
		{	
			// System.out.println(arr.ge
			// t(i).getUser_name());
			// System.out.println(x);
			if(arr.get(i).getUser_name().equals(x))
				{	
					check_point=1;	
					break;
				}	
				
		}
		return check_point;
	}
	public static int search(ArrayList<Person> arr,int n,String x)
	{
		// int search_point=0;
		int i;
		for(i=0;i<n;i++)
		{
			if(arr.get(i).getUser_name().equals(x))
			{
				break;
			}
		}
		return i;
	}

	public static int search_friend(ArrayList<String> arr,int n,String x)
	{
		// int search_point=0;
		// for(int j=0;j<n;j++)
		// 	System.out.println(arr.get(j));
		int check=-1;
		int i;
		for(i=0;i<n;i++)
		{
			if(arr.get(i).equals(x))
			{	
				// System.out.println("in");
				check=0;
				break;
			}
		}
		if(check==0)
			return i;
		else
			return check;
	}
	public static ArrayList<String> mutual_friends(ArrayList<String> arr1,ArrayList<String> arr2,int n,int m)
	{
		ArrayList<String> mutual=new ArrayList<String>();
		// System.out.println(arr1);
		// System.out.println(arr2);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(arr1.get(i).equals(arr2.get(j)))
					mutual.add(arr1.get(i));
			}
		}
		// System.out.println(mutual);
		return mutual;
	}
	public static void file_update(String username,String password,String displayname,int nofriends,ArrayList<String> friends,int nopendingrequest,ArrayList<String> pendingfriendrequest,String status)
	{	
		BufferedReader br = null;
		BufferedWriter bw = null;
	try
	{
   	 br = new BufferedReader(new FileReader("input.txt"));
   	 bw = new BufferedWriter(new FileWriter(new File("new_name.txt"),true));
 
    	String line = br.readLine();
     
   		 while(line != null) { 
       		 String[] array_user=line.split(",");
       		 // System.out.println(array_user[0]+username);
       		 String friend_list="";
       		 if(!(friends.isEmpty()))
       		{ for(int u=0;u<friends.size()-1;u++)
       		 {
       		 	friend_list+=friends.get(u);
       		 	friend_list+=",";
       		 }
       		 friend_list+=friends.get(friends.size()-1);
       		}
       		String pendingfriend_list="";
       		if(!(pendingfriendrequest.isEmpty()))
       		 {
       		 for(int u=0;u<pendingfriendrequest.size()-1;u++)
       		 {
       		 	pendingfriend_list+=pendingfriendrequest.get(u);
       		 	pendingfriend_list+=",";
       		 }
       		 pendingfriend_list+=pendingfriendrequest.get(pendingfriendrequest.size()-1);
        	}
        	if(array_user[0] .equals( username)){
            //code what to change in the file. The entire line with the this username must be rewritten with the required changes/additions.
            	// System.out.println(nopendingrequest);
            	// System.out.println(pendingfriendrequest);
        		if(friend_list.isEmpty())
        			bw.write(username+","+password+","+displayname+","+nofriends+","+nopendingrequest+","+pendingfriend_list+","+status+"\n");
            	else if(pendingfriend_list.isEmpty())
            		bw.write(username+","+password+","+displayname+","+nofriends+","+friend_list+","+nopendingrequest+","+status+"\n");
            	else
            	    bw.write(username+","+password+","+displayname+","+nofriends+","+friend_list+","+nopendingrequest+","+pendingfriend_list+","+status+"\n");
        	}
        	else{
            	bw.write(line+"\n");
        	}
        
       	 line = br.readLine();
    	}
    //File file = new File("\\Files\\" + name + ".txt");
    	br.close();
    	bw.close();
    	File oldName = new File("/Users/apple/Desktop/Semester/Sem3/AP/Java/My network lab/new_name.txt");
      	File file=new File("/Users/apple/Desktop/Semester/Sem3/AP/Java/My network lab/input.txt");
    	oldName.renameTo(file);
    	// file.delete();
    //br.close();
    //br = null;
    	// bw.renameTo("input.txt");
    // bw.flush();            
    	// bw.close();
    //bw = null;
     
	}
	catch(Exception e) {
   	 System.out.println("Exception caught");
	}
}
public static void bfs(Vertex s){
    s.dist = 0;
    s.colour = 'g';
    s.prev = null;
    PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
    q.add(s);
    while(!q.isEmpty()){
        Vertex u = q.poll();
        for(Edge e : u.adjacency_list){
             Vertex v = e.dest;

            if(v.colour =='w'){
                //q.remove(v);
                v.colour = 'g';
                v.dist = u.dist + 1;
                v.prev = u;
                q.add(v);
            }
            u.colour = 'b';
        }
    }
    }
    public static int search_vertex(ArrayList<Vertex> g,Vertex vr)
    {int same=0;

    	for(int i=0;i<g.size();i++)
    	{
    		if(g.get(i).toString().equals(vr.toString()))
    			{
    				 same=i;
    				break;
    			}
    	}
    	return same;

    }



    public static List<Vertex> getShortestDist(Vertex dest)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex ver = dest; ver != null; ver = ver.prev){
            path.add(ver);
        }

        Collections.reverse(path);
        return path;
    }
	public static void main(String args[])throws Exception
	{
		ArrayList<Person> arr=new ArrayList<Person>();
	
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
    	String line;
    	while ((line = br.readLine()) != null)
    {
      	String[] details=line.split(",");
      	Person p=new Person();
      	int pendingrequest=Integer.parseInt(details[3]);
      	// System.out.println(details[4+pendingrequest]);
      	p.setUser_name(details[0]);
      	p.setPassword(details[1]);
      	p.setDisplay_name(details[2]);
      	p.setStatus(details[details.length-1]);
      	p.setNofriends(pendingrequest);
      	p.setNopendingrequest(Integer.parseInt(details[4+pendingrequest]));
      	for(int j=4;j<=pendingrequest+3;j++)
      	{
      		p.setFriends(details[j]);
      	}
      	// p.getFriends();
      	for(int j=5+pendingrequest;j<details.length-1;j++)
      	{
      		p.setPendingrequest(details[j]);
      	}
      	// p.getPendingfriends();

      	// p.setNopendingrequest(details[3+details[3]]);
      	arr.add(p);
     
      	// for (String w:details)
      	// {System.out.println(w);
      	// }
      }
      	System.out.println("Reading database file…");
		System.out.println("Network is ready.");		
		System.out.println("1. Sign up");
		System.out.println("2. Login");
		Scanner in=new Scanner(System.in);
		// int input=in.nextInt();
		int login=0;
		String login_username=null;
		String login_displayname=null;
		Scanner x=new Scanner(System.in);
		while(login==0)
		{	int input=in.nextInt();
			if(input==1)
			{	Person p1=new Person();
			
				System.out.print("Enter username:");
				String username=x.nextLine();
			
				if(check(arr,arr.size(),username)==1)
				{
					throw new MyException(username);

				}
				else
				{
					p1.setUser_name(username);
				}		
				System.out.print("Enter display name:");
				String displayname=x.nextLine();
				p1.setDisplay_name(displayname);
				System.out.print("Enter password:");
				String password=x.nextLine();
				p1.setPassword(username);
				p1.setStatus("No Status");
				p1.setNofriends(0);
				p1.setNopendingrequest(0);
				arr.add(p1);

				BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt",true));
				bw.write(p1.getUser_name()+","+p1.getPassword()+","+p1.getDisplay_name()+","+p1.getNofriends()+","+p1.getNopendingrequest()+","+p1.getStatus()+"\n");
				bw.close();
				System.out.println("Registration is Successful Usr "+p1.getUser_name()+" Created");
			}
			else if(input==2)
			{
				System.out.print("Please enter your username:");
				String check_username=x.nextLine();
		
				if(check(arr,arr.size(),check_username)==0)
				{
					throw new MynewException(check_username);
				}
			
				System.out.print("Please enter your password:");
				String check_password=x.nextLine();
				int search_index=search(arr,arr.size(),check_username);
				if(!(arr.get(search_index).getPassword().equals(check_password)))
				{
					throw new PasswordException(check_password);
				}
				login=1;
				login_username=arr.get(search_index).getUser_name();
				login_displayname=arr.get(search_index).getDisplay_name();
				System.out.println(login_displayname+" Logged in");
				System.out.println(arr.get(search_index).getStatus());
			
			}
			else if(input!=1 || input!=2)
			{
				throw new IllegalArgumentException("Error enter 1 or 2");
			}
			System.out.println("1. List Friends");
			System.out.println("2. Search");
			System.out.println("3. Update status");
			System.out.println("4. Pending request");
			System.out.println("5. logout");
			int n=x.nextInt();

			while(n!=5)
			{
				int search_index=search(arr,arr.size(),login_username);
			block1:
			{
				if(n==1)
			{
				
				System.out.print("Your friends are:");
				arr.get(search_index).printFriends();
			}
			else if(n==2)
			{
				System.out.print("Enter Name:");
				Scanner scan=new Scanner(System.in);
				String name=scan.nextLine();
				int search_friend_index=search_friend(arr.get(search_index).getFriends(),arr.get(search_index).getFriends().size(),name);
				if(check(arr,arr.size(),name)==0)
				{
					throw new SearchException(name);
				}
				int search_name_index=search(arr,arr.size(),name);
				// System.out.println(search_name_index);
				ArrayList<String> mutual=mutual_friends(arr.get(search_index).getFriends(),arr.get(search_name_index).getFriends(),arr.get(search_index).getFriends().size(),arr.get(search_name_index).getFriends().size());
				// System.out.println(search_index);
				// ArrayList<String>
				ArrayList<Vertex> graph=new ArrayList<Vertex>();
				for(int y=0;y<arr.size();y++)
					{
						Vertex A= new Vertex(arr.get(y).getUser_name());
						graph.add(A);
					}
				// System.out.println(graph);
				for(int y=0;y<arr.size();y++)
				{
					 graph.get(y).adjacency_list = new ArrayList<Edge>();
					 for(int h=0;h<arr.get(y).getFriends().size();h++)
					 {
					 	Vertex A= new Vertex(arr.get(y).getFriends().get(h));
					 	// System.out.println(A);
					 	int vertex_search=search_vertex(graph,A);
					 	// System.out.println(vertex_search);
					 	// System.out.println(graph.get(vertex_search));
					 	graph.get(y).adjacency_list.add(new Edge(graph.get(vertex_search)));
					 	// System.out.println(graph.get(y).adjacency_list.get(h));
					 }
				}	
				// System.out.println(graph);

				// for(int h=0;h<arr.size();h++)
				// {
				// 	System.out.println(graph.get(h));
				// 	for(int y=0;y<graph.get(h).adjacency_list.size();y++)
				// 		System.out.println(graph.get(h).adjacency_list.get(y));
				// }	
				// Vertex B=new Vertex(login_username);
				int t;
				int same_1=0;
				int same_2=0;
				for(t=0;t<graph.size();t++)
				{
					// String d=B.toString();
					String g=graph.get(t).toString();
					// System.out.println(d);
					// System.out.println(g);
					if(g.equals(login_username))
						{
							same_1=t;
							
						}
					if(g.equals(name))
					{
						same_2=t;
					}	
						
				}
				// System.out.println(graph.get(same_1));

				bfs(graph.get(same_1));
				List<Vertex> path = getShortestDist(graph.get(same_2));
				if(search_friend_index==-1)
					{
						System.out.println(name+" is not a friend");
						System.out.print("Mutual Friends:");
						if(mutual.isEmpty())
							System.out.println("No mutual Friends");
						else
						{
							for(int k=0;k<mutual.size()-1;k++)
								System.out.print(mutual.get(k)+",");
							System.out.println(mutual.get(mutual.size()-1));
						}
						System.out.print("Shortest Route:");
						for(int i=0;i<path.size()-1;i++)
           					 System.out.print(path.get(i)+"->");
       					System.out.println(path.get(path.size()-1));
						int search_request_index=search_friend(arr.get(search_index).getPendingrequest(),arr.get(search_index).getPendingrequest().size(),name);
						// System.out.println(search_request_index);
						if(search_request_index==-1)
						{
							System.out.println("1.Send request");
							System.out.println("b.back");
							char sent=in.next().charAt(0);
							if(sent=='1')
							{
								System.out.println("Request sent");
								arr.get(search_index).setPendingrequest(name);
								// arr.get(search_index).printPendingfriends();
								arr.get(search_index).setNopendingrequest(arr.get(search_index).getNopendingrequest()+1);
								System.out.println(name+" is not a friend");
								System.out.print("Mutual Friends:");
								if(mutual.isEmpty())
									System.out.println("No mutual Friends");
								else
								{
									for(int k=0;k<mutual.size()-1;k++)
										System.out.print(mutual.get(k)+",");
									System.out.println(mutual.get(mutual.size()-1));
								}
								System.out.print("Shortest Route:");
								for(int i=0;i<path.size()-1;i++)
           					 		System.out.print(path.get(i)+"->");
       							System.out.println(path.get(path.size()-1));
								System.out.println("Request Pending");
								System.out.println("1.Cancel Request");
								System.out.println("b.Back");
								char sent2=in.next().charAt(0);
								if(sent2=='1')
								{	System.out.println("Request Cancelled");
									arr.get(search_index).deletePendingrequest(name);
									arr.get(search_index).setNopendingrequest(arr.get(search_index).getNopendingrequest()-1);
									// arr.get(search_index).printPendingfriends();
								}
								else if(sent2=='b')
								{
									arr.get(search_index).printPendingfriends();
									file_update(login_username,arr.get(search_index).getPassword(),arr.get(search_index).getDisplay_name(),
										arr.get(search_index).getNofriends(),arr.get(search_index).getFriends(),arr.get(search_index).getNopendingrequest(),
										arr.get(search_index).getPendingrequest(),arr.get(search_index).getStatus());
									break block1;
								}
							}
							else if(sent=='b')
							{
								break block1;
							}
						}
						else 
						{System.out.println("Request Pending");
							System.out.println("1.Cancel Request");
							System.out.println("b.Back");
							char sent2=in.next().charAt(0);
							if(sent2=='1')
							{	System.out.println("Request Cancelled");
								arr.get(search_index).deletePendingrequest(name);
								arr.get(search_index).setNopendingrequest(arr.get(search_index).getNopendingrequest()-1);
								file_update(login_username,arr.get(search_index).getPassword(),arr.get(search_index).getDisplay_name(),
										arr.get(search_index).getNofriends(),arr.get(search_index).getFriends(),arr.get(search_index).getNopendingrequest(),
										arr.get(search_index).getPendingrequest(),arr.get(search_index).getStatus());
							}								
							else if(sent2=='b')
							{
								break block1;
							}
						}
					}	
				else
					{
						System.out.println("You and "+name+" are friend");
						System.out.println("Display Name:"+arr.get(search_name_index).getDisplay_name());
						System.out.println("Status:"+arr.get(search_name_index).getStatus());
						System.out.println("Friends:");arr.get(search_name_index).printFriends();
						System.out.print("Mutual Friennds:");
						if(mutual.isEmpty())
							System.out.println("No mutual Friends");
						else
						{
							for(int k=0;k<mutual.size()-1;k++)
								System.out.print(mutual.get(k)+",");
							System.out.println(mutual.get(mutual.size()-1));
						// }
						}
						
						System.out.println("b.Back");
						char sent2=in.next().charAt(0);
						if(sent2=='b');
							break block1;
					}	
			}
			else if(n==3)
			{
				Scanner r =new Scanner(System.in);
				System.out.print("Enter Status:");
				String stat=r.nextLine();
				arr.get(search_index).setStatus(stat);
				System.out.println("Status updated!!!");
				file_update(login_username,arr.get(search_index).getPassword(),arr.get(search_index).getDisplay_name(),
										arr.get(search_index).getNofriends(),arr.get(search_index).getFriends(),arr.get(search_index).getNopendingrequest(),
										arr.get(search_index).getPendingrequest(),arr.get(search_index).getStatus());

				// System.out.print(arr.get(search_index).getStatus());
			}
			else if(n==4)
			{
				ArrayList<String> pending = new ArrayList<String>();
				pending=arr.get(search_index).getPendingrequest();
				if(pending.isEmpty())
					{
						System.out.println("No friend Request");
						
					}
				else{
				for(int d=0;d<pending.size();d++)
				{
					System.out.println((d+1)+" "+pending.get(d));
				}
				}
				System.out.println("b.Back");
				char option=x.next().charAt(0);
				while(option!='b')
				{	if(pending.isEmpty())
					{
						System.out.println("No friend Request");
						break;
					}
					int index=option-'0';
					System.out.println(pending.get(index-1));
					System.out.println("1.Accept");
					System.out.println("2.Reject");
					int option_2=x.nextInt();
					String check_name=pending.get(index-1);
					if(option_2==1)
					{	
						System.out.println("You are now friends with "+check_name);
						arr.get(search_index).deletePendingrequest(check_name);
						arr.get(search_index).setFriends(check_name);
						arr.get(search_index).setNofriends(arr.get(search_index).getNofriends()+1);
						arr.get(search_index).setNopendingrequest(arr.get(search_index).getNopendingrequest()-1);
						file_update(login_username,arr.get(search_index).getPassword(),arr.get(search_index).getDisplay_name(),
										arr.get(search_index).getNofriends(),arr.get(search_index).getFriends(),arr.get(search_index).getNopendingrequest(),
										arr.get(search_index).getPendingrequest(),arr.get(search_index).getStatus());
						// arr.get(search_index).printFriends();
						
					}
					else if(option_2==2)
						{
						arr.get(search_index).deletePendingrequest(check_name);
						System.out.println("Friend request by "+check_name+" deleted");
						arr.get(search_index).setNopendingrequest(arr.get(search_index).getNopendingrequest()-1);
						file_update(login_username,arr.get(search_index).getPassword(),arr.get(search_index).getDisplay_name(),
										arr.get(search_index).getNofriends(),arr.get(search_index).getFriends(),arr.get(search_index).getNopendingrequest(),
										arr.get(search_index).getPendingrequest(),arr.get(search_index).getStatus());
						}
				if(pending.isEmpty())
					{
						System.out.println("No friend Request");
						
					}
				else{
					for(int d=0;d<pending.size();d++)
					{
						System.out.println((d+1)+" "+pending.get(d));
					}
					}
				System.out.println("b.Back");
					option=x.next().charAt(0);	
				}
				if(option=='b')
					break block1;
			}
		}
			System.out.println("1. List Friends");
			System.out.println("2. Search");
			System.out.println("3. Update status");
			System.out.println("4. Pending request");
			System.out.println("5. logout");
			n=x.nextInt();
		

		}
			
		}

		System.out.println("Usr " +login_username+" Logged out Successfully");

  }
      	catch(IOException e)
      	{
      		System.out.println("Error file not find");
      	}
    }
}




	
// 