import java.util.*;
public class ComplexObject{
	private final Object real;
	private final Object imag;
	public ComplexObject(Object x,Object y)
	{
		real=x;
		imag=y;
	}
	public Object getReal(){
		return real;
	}
	public Object getImaginary(){
		return imag;
	}
	public ComplexObject addition(ComplexObject b)
	{	ComplexObject a=this;
		ComplexObject ans=null;
		if(a.real instanceof Integer && b.real instanceof Integer)
			ans=new ComplexObject((Integer)a.real+(Integer)b.real,(Integer)a.imag+(Integer)b.imag);
		else if(a.real instanceof Float && b.real instanceof Float)
			ans=new ComplexObject((Float)a.real+(Float)b.real,(Float)a.imag+(Float)b.imag);
		else if(a.real instanceof Double && b.real instanceof Double)
			ans=new ComplexObject((Double)a.real+(Double)b.real,(Double)a.imag+(Double)b.imag);
		return ans;
	}
	public ComplexObject subtraction(ComplexObject b)
	{	ComplexObject a=this;
		ComplexObject ans=null;
	if(a.real instanceof Integer && b.real instanceof Integer)
			ans=new ComplexObject((Integer)a.real-(Integer)b.real,(Integer)a.imag-(Integer)b.imag);
		else if(a.real instanceof Float && b.real instanceof Float)
			ans=new ComplexObject((Float)a.real-(Float)b.real,(Float)a.imag-(Float)b.imag);
		else if(a.real instanceof Double && b.real instanceof Double)
			ans=new ComplexObject((Double)a.real-(Double)b.real,(Double)a.imag-(Double)b.imag);
		return ans;
	}
	public Double absolute()
	{   ComplexObject a=this;
		Double ans=0.0;
		if(a.real instanceof Integer)
			ans=Math.sqrt((Integer)a.real*(Integer)a.real+ (Integer)a.imag*(Integer)a.imag);
		else if(a.real instanceof Float)
			ans=Math.sqrt((Float)a.real*(Float)a.real+ (Float)a.imag*(Float)a.imag);
		else if(a.real instanceof Double)
			ans=Math.sqrt((Double)a.real*(Double)a.real+ (Double)a.imag*(Double)a.imag);
		return ans;
	}
	public ComplexObject conjugate()
	{   ComplexObject a=this;
		// Integer x,y;
		// x=a.real;
		// y=-a.imag;
		ComplexObject ans=null;
		if(a.real instanceof Integer)
			ans=new ComplexObject((Integer)a.real,-(Integer)a.imag);
		else if(a.real instanceof Float)
			ans=new ComplexObject((Float)a.real,-(Float)a.imag);
		else if(a.real instanceof Double)
			ans=new ComplexObject((Double)a.real,-(Double)a.imag);
	
		return ans;

	}
	public ComplexObject multiply(ComplexObject b)
	{   ComplexObject a=this;
		ComplexObject ans=null;
		if(a.real instanceof Integer && b.real instanceof Integer)
			ans=new ComplexObject((Integer)a.real*(Integer)b.real-(Integer)a.imag*(Integer)b.imag,(Integer)a.imag*(Integer)b.real+(Integer)a.real*(Integer)b.imag);
		else if(a.real instanceof Float && b.real instanceof Float)
			ans=new ComplexObject((Float)a.real*(Float)b.real-(Float)a.imag*(Float)b.imag,(Float)a.imag*(Float)b.real+(Float)a.real*(Float)b.imag);
		else if(a.real instanceof Double && b.real instanceof Double)
			ans=new ComplexObject((Double)a.real*(Double)b.real-(Double)a.imag*(Double)b.imag,(Double)a.imag*(Double)b.real+(Double)a.real*(Double)b.imag);
		return ans;
	}
	public String toString()
	{
		ComplexObject a=this;
		if(a.real instanceof Integer) 
		{
			if((Integer)a.real==0 )
				return (Integer)a.real+"i";
			else if((Integer)a.imag==0 )
				return (Integer)a.imag+"";
			else if((Integer)a.imag<0 )
				return (Integer)a.real+"-"+(-(Integer)a.imag)+"i";
			else
				return (Integer)a.real+"+"+(Integer)a.imag+"i";
		
		}	
		else if(a.real instanceof Double)
		{

			if((Double)a.real==0.0 )
				return (Double)a.real+"i";
			else if((Double)a.imag==0.0 )
				return (Double)a.imag+"";
			else if((Double)a.imag<0.0 )
				return (Double)a.real+"-"+(-(Double)a.imag)+"i";
			else
				return (Double)a.real+"+"+(Double)a.imag+"i";
		
		}
		else if(a.real instanceof Float)
		{

			if((Float)a.real==0.0f )
				return (Float)a.real+"i";
			else if((Float)a.imag==0.0f )
				return (Float)a.imag+"";
			else if((Float)a.imag<0.0f )
				return (Float)a.real+"-"+(-(Float)a.imag)+"i";
			else
				return (Float)a.real+"+"+(Float)a.imag+"i";
		
		}
		return "";
	}
		
		
	

}