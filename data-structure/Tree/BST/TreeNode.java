
public class TreeNode {
	private int key;
	private Object data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int key) {
		this.key = key;
		this.data = null;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(int key, Object data) {
		this.key = key;
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
