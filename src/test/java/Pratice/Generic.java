package Pratice;

public class Generic {

	public static void main(String[] args) //caller
	{
	
		int sum = add(10,200);
		System.out.println(sum);

	}

	public static int add(int a, int b) //called
	{
	
		int c=a+b;
		return c;
		
		
	}
}
