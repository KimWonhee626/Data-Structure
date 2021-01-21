
public class Test {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
	
		tree.insert(14);
		tree.insert(13);
		tree.insert(20);
		tree.insert(18);
		tree.insert(23);
		tree.insert(25);
		tree.insert(22);
		tree.insert(21);
		tree.insert(7);
		tree.insert(2);
		tree.insert(1);
		tree.insert(5);
		tree.insert(9);
		tree.postOrder(tree.getRoot());
		
		System.out.println("========removed!========");
		tree.remove(14);
		tree.preOrder(tree.getRoot());
	}
	
}
