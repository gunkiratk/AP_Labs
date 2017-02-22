import java.util.Scanner;
public class ComplexDemo
{
	public static void main(String[] arg)
	{
		System.out.println("1.Simplex complex Integer values(part 1)");
		System.out.println("2.Complex with Object(part 2)");
		System.out.println("3.Complex with generic(part 3)");
		Scanner in=new Scanner(System.in);
		int option=in.nextInt();
		if(option==1)
		{
		ComplexObject a=new ComplexObject(5,6);
		ComplexObject b=new ComplexObject(-3,4);
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("Addition:"+a.addition(b));
		System.out.println("Subtraion:"+a.subtraction(b));
		System.out.println("Absolute value of a:"+a.absolute());
		System.out.println("Absolute value of b:"+b.absolute());
		System.out.println("Conjugate of a:"+a.conjugate());
		System.out.println("Conjugate of b:"+b.conjugate());
		System.out.println("Multiplication:"+a.multiply(b));
		}
		else if(option==2){
		System.out.println("Integer Values");
		ComplexObject a=new ComplexObject(5,6);
		ComplexObject b=new ComplexObject(-3,4);
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("Addition:"+a.addition(b));
		System.out.println("Subtraion:"+a.subtraction(b));
		System.out.println("Absolute value of a:"+a.absolute());
		System.out.println("Absolute value of b:"+b.absolute());
		System.out.println("Conjugate of a:"+a.conjugate());
		System.out.println("Conjugate of b:"+b.conjugate());
		System.out.println("Multiplication:"+a.multiply(b));
		System.out.println();
		System.out.println("Float Values");
		ComplexObject p=new ComplexObject(5.5f,6.8f);
		ComplexObject q=new ComplexObject(-3.4f,4.4f);
		System.out.println("p:"+p);
		System.out.println("q:"+q);
		System.out.println("Addition:"+p.addition(q));
		System.out.println("Subtraion:"+p.subtraction(q));
		System.out.println("Absolute value of p:"+p.absolute());
		System.out.println("Absolute value of q:"+p.absolute());
		System.out.println("Conjugate of p:"+p.conjugate());
		System.out.println("Conjugate of q:"+q.conjugate());
		System.out.println("Multiplication:"+p.multiply(q));
		System.out.println();
		System.out.println("Double Values");
		ComplexObject x=new ComplexObject(4.9,7.2);
		ComplexObject y=new ComplexObject(-4.5,-6.6);
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println("Addition:"+x.addition(y));
		System.out.println("Subtraion:"+x.subtraction(y));
		System.out.println("Absolute value of x:"+x.absolute());
		System.out.println("Absolute value of y:"+y.absolute());
		System.out.println("Conjugate of x:"+x.conjugate());
		System.out.println("Conjugate of y:"+y.conjugate());
		System.out.println("Multiplication:"+x.multiply(y));

		}
		else if(option==3){
		System.out.println("Integer Values");
		ComplexGenerics<Integer> a=new ComplexGenerics<Integer>(5,6);
		ComplexGenerics<Integer> b=new ComplexGenerics<Integer>(-3,4);
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("Addition:"+a.addition(b));
		System.out.println("Subtraion:"+a.subtraction(b));
		System.out.println("Absolute value of a:"+a.absolute());
		System.out.println("Absolute value of b:"+b.absolute());
		System.out.println("Conjugate of a:"+a.conjugate());
		System.out.println("Conjugate of b:"+b.conjugate());
		System.out.println("Multiplication:"+a.multiply(b));
		System.out.println();
		System.out.println("Float Values");
		ComplexGenerics<Float> p=new ComplexGenerics<Float>(5.5f,6.8f);
		ComplexGenerics<Float> q=new ComplexGenerics<Float>(-3.4f,4.4f);
		System.out.println("p:"+p);
		System.out.println("q:"+q);
		System.out.println("Addition:"+p.addition(q));
		System.out.println("Subtraion:"+p.subtraction(q));
		System.out.println("Absolute value of p:"+p.absolute());
		System.out.println("Absolute value of q:"+p.absolute());
		System.out.println("Conjugate of p:"+p.conjugate());
		System.out.println("Conjugate of q:"+q.conjugate());
		System.out.println("Multiplication:"+p.multiply(q));
		System.out.println();
		System.out.println("Double Values");
		ComplexGenerics<Double> x=new ComplexGenerics<Double>(4.9,7.2);
		ComplexGenerics<Double> y=new ComplexGenerics<Double>(-4.5,-6.6);
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println("Addition:"+x.addition(y));
		System.out.println("Subtraion:"+x.subtraction(y));
		System.out.println("Absolute value of x:"+x.absolute());
		System.out.println("Absolute value of y:"+y.absolute());
		System.out.println("Conjugate of x:"+x.conjugate());
		System.out.println("Conjugate of y:"+y.conjugate());
		System.out.println("Multiplication:"+x.multiply(y));

		}

	}
}