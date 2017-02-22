import java.util.*;
public class Person{
	private String user_name;
	private String password;
	private String dispaly_name;
	private int no_friends;
	private int no_pending_request;
	private String status;
	private ArrayList<String> friends=new ArrayList<String>();
	private ArrayList<String> pendingrequest=new ArrayList<String>();

	public void setUser_name(String user){
		user_name=user;
	}
	public void setPassword(String pass){
		password=pass;
	}
	public void setDisplay_name(String name){
		dispaly_name=name;
	}
	public void setNofriends(int x){
		no_friends=x;
	}
	public void setNopendingrequest(int x){
		no_pending_request=x;
	}
	public void setStatus(String stat)
	{
		status=stat;
	}
	public void setFriends(String x)
	{
		friends.add(x);
	}
	public void setPendingrequest(String x)
	{
		pendingrequest.add(x);
	}
	public void deletePendingrequest(String x)
	{
		pendingrequest.remove(x);
	}
	public void printFriends()
	{
		for(int i=0;i<friends.size()-1;i++)
			System.out.print(friends.get(i)+",");
		System.out.println(friends.get(friends.size()-1));
	}
	public void printPendingfriends()
	{
		for(int i=0;i<pendingrequest.size()-1;i++)
			System.out.print(pendingrequest.get(i)+",");
		System.out.println(pendingrequest.get(pendingrequest.size()-1));
	}
	public ArrayList<String> getFriends()
	{
		return friends;
	}
	public ArrayList<String> getPendingrequest()
	{
		return pendingrequest;
	}
	public String getUser_name(){
		return user_name;
	}
	public String getPassword(){
		return password;
	}
	public String getDisplay_name(){
		return dispaly_name;
	}
	public int getNofriends(){
		return no_friends;
	}
	public int getNopendingrequest(){
		return no_pending_request;
	}
	public String getStatus()
	{
		return status;
	}


}