/**
 * 
 */
package generics.wildcard.main;

/**
 * @author Ritam
 *
 */
public class ErasureBridgeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyNode myNode = new MyNode(5);
		Node n = myNode;
		n.setData("hello");
		System.out.println(n.data);

	}

}
 class Node<T> {

    public T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

 class MyNode extends Node<Integer> {
    public MyNode(Integer data) { super(data); }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
