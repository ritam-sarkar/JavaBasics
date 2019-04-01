package pkg.anonymous;

import pkg.staticmember.NodeProvider;
import pkg.staticmember.NodeProvider.Node;

public class NodeReceiver {

	public static void main(String[] args) {

		NodeProvider nodeProvider = new NodeProvider();
		Node node1 = nodeProvider.provide(0);
	}

}
