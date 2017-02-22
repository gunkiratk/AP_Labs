import java.util.*;
public class Complex{
	private final Integer real;
	private final Integer imag;
	public Complex(int a,int b)
	{
		this.real=a;
		this.imag=b;
	}
	public Integer getReal()
	{
		return real;
	}
	public Integer getImaginary()
	{
		return imag;
	}
	public Complex addition(Complex b)
	{	Complex a=this;
		Integer x,y;
		x=a.real+b.real;
		y=a.imag+b.imag;
		Complex ans=new Complex(x,y);
		return ans;
	}
	public Complex subtraction(Complex b)
	{ 	Complex a=this;
		Integer x,y;
		x=a.real-b.real;
		y=a.imag-b.imag;
		Complex ans=new Complex(x,y);
		return ans;
	}
	public Double absolute()
	{   Complex a=this;
		Integer x,y;
		Double ans=Math.sqrt(a.real*a.real + a.imag*a.imag);
		return ans;
	}
	public Complex conjugate()
	{   Complex a=this;
		Integer x,y;
		x=a.real;
		y=-a.imag;
		Complex ans=new Complex(x,y);
		return ans;

	}
	public Complex multiply(Complex b)
	{   Complex a=this;
		Integer x,y;
		x=a.real*b.real-a.imag*b.imag;
		y=a.imag*b.real+a.real*b.imag;
		Complex ans=new Complex(x,y);
		return ans;
	}
	public String toString()
	{	
		if(this.real==0)
			return this.imag+"i";
		else if(this.imag==0)
			return this.real+"";
		else if(this.imag<0)
			return this.real+"-"+(-this.imag)+"i";
		else
			return this.real+"+"+this.imag+"i";

	}

}