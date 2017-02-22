/* 
Team Members:

Member1: 
Name:Gunkirat Kaur
Roll number:2015032

Member 2:
Name:Shaan Chopra
Roll numberL2015090
*/
public class Road_accident{
	public static void main(String[] args){
		Harley_Davidson v1 = new Harley_Davidson();
		Bullet v2 = new Bullet();
		Cadillac v3 = new Cadillac();
		Ferrari v4 = new Ferrari();
		Ladybird v5 = new Ladybird();
		Firefox v6 = new Firefox();
		
		Vehicle [] arr=new Vehicle[6];
		arr[0]=v1;
		arr[1]=v2;
		arr[2]=v3;
		arr[3]=v4;
		arr[4]=v5;
		arr[5]=v6;
		//System.out.println(array[0].getOwnerName());

		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("      Model      |   Owner Name | Number of wheels |  Policy class  | Policy Expiry");
		System.out.println(" "+v1.getModel()+" |    " + v1.getOwnerName() + "   |        " + v1.getWheels() + "         |  "+v1.getPolicyClass() + "  |  " + v1.getPol().getExpiryday()+"/"+v1.getPol().getExpirymonth()+"/"+v1.getPol().getExpiryyear());
		System.out.println("      "+v2.getModel()+"     |     " + v2.getOwnerName() +"     |        " +v2.getWheels()+"         |  "+v2.getPolicyClass() + "  |  " + v2.getPol().getExpiryday()+"/"+v2.getPol().getExpirymonth()+"/"+v2.getPol().getExpiryyear());
		System.out.println("     "+v3.getModel()+"    |    " + v3.getOwnerName() +"     |        "+v3.getWheels()+"         |  "+v3.getPolicyClass() + "|  " + v3.getPol().getExpiryday()+"/"+v3.getPol().getExpirymonth()+"/"+v3.getPol().getExpiryyear());
		System.out.println("     "+v4.getModel()+"     |    " + v4.getOwnerName() +"     |        " +v4.getWheels()+"         |  "+v4.getPolicyClass() + "|  " + v4.getPol().getExpiryday()+"/"+v4.getPol().getExpirymonth()+"/"+v4.getPol().getExpiryyear());
		System.out.println("    "+v5.getModel()+"     |    " + v5.getOwnerName() +"     |        " +v5.getWheels()+"         |  "+v5.getPolicyClass() + "     |  " + v5.getPolicyClass());
		System.out.println("     "+v6.getModel()+"     |   " + v6.getOwnerName() +"     |        " +v6.getWheels()+"         |  "+v6.getPolicyClass() + "     |  " + v6.getPolicyClass());
		System.out.println("------------------------------------------------------------------------------------");

		int i,j;
		long damage_1=0,damage_2=0;
		double damages_self, damages_oncoming;
		//damages_self = (4*5000)/5;
		int k=1;
		int check;
		for(i=0;i<6;i++){
			for(j=0;j<6;j++){
				if(i!=j){
					System.out.println("Collision "+k);
					System.out.println("I am " + arr[i].getModel()+","+ arr[i].getOwnerName()+" collided with "+ arr[j].getModel()+","+arr[j].getOwnerName());
					if(arr[i].getModel().equals("Harley Davidson") || arr[i].getModel().equals("Bullet" ))
							damage_1=3000;
					else if(arr[i].getModel().equals("Ferrari") || arr[i].getModel().equals("Cadillac" ))
							damage_1=5000;
					else if(arr[i].getModel().equals("Ladybird") || arr[i].getModel().equals("Firefox" ))
							damage_1=1000;
					// System.out.println(damage_1);
					if(arr[j].getModel().equals("Harley Davidson") || arr[j].getModel().equals("Bullet" ))
							damage_2=3000;
					else if(arr[j].getModel().equals("Ferrari") || arr[j].getModel().equals("Cadillac" ))
							damage_2=5000;
					else if(arr[j].getModel().equals("Ladybird") || arr[j].getModel().equals("Firefox" ))
							damage_2=1000;
					System.out.println("Damages self:" + damage_1);
					System.out.println("Damage oncoming:" + damage_2);
					check=arr[i].assignment(damage_1);
					if(check==1)
					{ 	
						damages_oncoming=0.8*damage_2;
						damages_self=0;
						System.out.println("Settlement details:");
						System.out.println("	oncoming vehicle damage status : "+damages_oncoming+" is paid by the Insurance policies");
						System.out.println("	self vehicle damage status : "+damages_self+" is paid by the Insurance policies");
					}
					else if(check==2)
					{	
						damages_oncoming=0.8*damage_2;
						damages_self=0.5*damage_1;
						System.out.println("Settlement details:");
						System.out.println("	oncoming vehicle damage status : "+damages_oncoming+" is paid by the Insurance policies");
						System.out.println("	self vehicle damage status : "+damages_self+" is paid by the Insurance policies");
					}
					else if(check==3)
					{	
						System.out.println("Settlement details:");
						System.out.println("	Exception Thrown");
						System.out.println("Exception is caught: because cycles do not have policy");
					}
					else if (check==0)
					{	
						System.out.println("Settlement details:");
						System.out.println("	Exception Thrown");
						System.out.println("Exception is caught: because policy is expired");
					}
				k++;
				System.out.println();
				}
				

			}
		} 
	}
}