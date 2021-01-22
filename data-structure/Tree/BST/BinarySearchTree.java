
public class BinarySearchTree {
	private TreeNode root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	
	public TreeNode getRoot() {
		return root;
	}


	public void setRoot(TreeNode root) {
		this.root = root;
	}


	// Ž�� ���� �޼ҵ�. ���� key���� �����ϸ� �ش� ��� ��ȯ, ������ null ��ȯ
	public TreeNode find(int key) {
		TreeNode cur = root;
		
		while(cur != null) {
			if(cur.getKey() == key) {
				return cur; // Ű ���� ������ ���� ��� ��ȯ
			}
			else if(cur.getKey() > key) {
				cur = cur.getLeft();
			}
			else {
				cur = cur.getRight();
			}
		}
		return null; // ���� key���� ������ null ����
	}
	
	
	// ���� ����
	public void insert(int key) {
		if(find(key) != null) { // �̹� �����ϴ� key�̸� ����
			System.out.println("The Key(" + key + ") Already Exists !!!");
			return;
		}
		
		TreeNode newNode = new TreeNode(key);
		
		if(root == null) { // Ʈ���� ��������� root�� �߰�
			root = newNode;
		}
		else {
			TreeNode cur = root; // Ž���� ������ ���
			TreeNode parent = null; // cur�� �θ���
			while(true) {
				parent = cur;
				
				if(key < cur.getKey()) { // �����Ϸ��� Ű���� ���� ����� Ű������ ������
					cur = cur.getLeft(); // �����ڽ����� �̵�
					
					if(cur == null) { // �����ڽ��� null �̸�
						parent.setLeft(newNode); // �����ڽĿ� newNode ����
						return;
					}
				}
				else {// �����Ϸ��� Ű���� ���� ����� Ű������ ũ��
					cur = cur.getRight(); // ������ �ڽĿ� ����������� ����
					
					if(cur == null){
						parent.setRight(newNode);
						return;
					}
				}
			}
		}
	}
	
	
	// ���� ���� �޼ҵ�
	public boolean remove(int key) {
		if(find(key) == null) {
			System.out.println("The key value("+key+") doesn't exist !!!");
			return false;
		}
		
		TreeNode cur = root; // ������ ���
		TreeNode parent = null; // ������ ����� �θ���
		boolean isLeftChild = false;
		
		// while�� ������ cur�� ������ ��� ����Ǿ�����.
		while(cur.getKey() != key) {
			parent = cur;
			
			if(cur.getKey() > key) {
				isLeftChild = true;
				cur = cur.getLeft();
			}
			else {
				isLeftChild = false;
				cur = cur.getRight();
			}
			
		}
		
		
		 // ������ ��尡 �ڽ��� ������
		if(isInternal(cur) == false) {
			if(cur == root) {
				root = null;
			}
			if(isLeftChild) {
				parent.setLeft(null);
			}
			else {
				parent.setRight(null);
			}
		}
		 // ������ ��尡 �������ڽĸ� ������ 
		else if(cur.getLeft() == null) {
			if(cur == root) {
				root = cur.getRight();
			}
			else if(isLeftChild) { // ������ ��尡 parent�� �����ڽ��϶�
				parent.setLeft(cur.getRight());
			}
			else { // ������ ��尡 parent�� �������ڽ��϶�
				parent.setRight(cur.getRight());
			}
		}
		 // ������ ��尡 �����ڽĸ� ������ 
		else if(cur.getRight() == null) {
			if(cur == root) {
				root = cur.getLeft();
			}
			else if(isLeftChild) {
				parent.setLeft(cur.getLeft());
			}
			else {
				parent.setRight(cur.getLeft());
			}
		}
		// ������ ��尡 �ڽ��� ��� �ִ°��
		// ������ ���� ������ ����Ʈ���� ���� ���� Ű���� ���� ���� �ٲ۴�. 
		else {
			TreeNode minNode = getMinNode(cur);
			if(cur == root) {
				root = minNode;
			}
			else if(isLeftChild) {
				parent.setLeft(minNode);
			}
			else {
				parent.setRight(minNode);
			}
			minNode.setLeft(cur.getLeft());
		}
		
		return true;
	}
	
	
	// ���γ��(��� �Ѱ��� �ڽ��� �ִ³��)���� ���� ��ȯ
	public boolean isInternal(TreeNode v) {
		return (v.getLeft() != null || v.getRight() != null);
	}
	
	
	// �����Ϸ��� ����� ������ ����Ʈ���� �ּҰ� ��ȯ�ϴ� �޼ҵ�
	public TreeNode getMinNode(TreeNode removeNode) {
		TreeNode minParent = removeNode;
		TreeNode min = removeNode.getRight();

		
		while(min.getLeft() != null) { 
			minParent = min;
			min = min.getLeft();
		}
		if(min != removeNode.getRight()) {
			minParent.setLeft(min.getRight());
			min.setRight(removeNode.getRight());
		}
		
		return min;
	}

	
	// ������ȸ
	public void preOrder(TreeNode v) {
		if(v != null){ 
			System.out.print(v.getKey() + " ");
			if(v.getLeft() != null)
				preOrder(v.getLeft());
			if(v.getRight() != null) {
				preOrder(v.getRight());
				
			}
		}
	}
	
	// ������ȸ
	public void inOrder(TreeNode v) {
		if(v != null){ 
			if(v.getLeft() != null)
				inOrder(v.getLeft());
			System.out.print(v.getKey() + " ");
			if(v.getRight() != null)
				inOrder(v.getRight());
		}
	}
	
	// ������ȸ
	public void postOrder(TreeNode v) {
		if(v != null){ 
			if(v.getLeft() != null)
				postOrder(v.getLeft());
			if(v.getRight() != null)
				postOrder(v.getRight());
			System.out.print(v.getKey() + " ");
		}
	}


	
}
	
	
