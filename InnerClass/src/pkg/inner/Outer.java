package pkg.inner;

public class Outer {

	public class Inner{
		//static  int staticInner = 10;
		//static final int  staticMethod(){}
		public Inner(){
			//static final int staticInner = 10;
		}
		public void display(){
			System.out.println("This is inner");
		}
		
	}
	public Inner getInner(){
		return new Inner();
	}
	public void test1(){
		Inner inner = new Inner();
	}
	public Outer(){
		int staticOuter = 10;
	}
	
	

}
