package pkg.staticmember;

public class NodeProvider {	
	
	int data =5;
	public  class ChildNode extends Node{
		Node next;
		int data;
		public ChildNode() {
			int d = super.data;
			int d2= this.data;
			int d3 = NodeProvider.this.data;
			System.out.println(d+" from parent node");
			System.out.println(d2+" from child node");
			System.out.println(d3+" from outer class");
		}
		
	}
	
	public class Node{
		protected int data;		
		public Node() {
			this.data = 3;
		}
		
	}
	void method() {
		//LocalInner inner = new LocalInner();
		class LocalInner{
			int a = 1;
			static final int var=2;
			void methodInner(){
				data = 10;
			}
		}
	}
	static class StaticInner{
		
	}
	public static void main(String [] args) {
		NodeProvider nodeProvider = new NodeProvider();
		Node node = nodeProvider.new ChildNode();
	}	
	
}
class AnotherClass extends NodeProvider.StaticInner{
	
}
