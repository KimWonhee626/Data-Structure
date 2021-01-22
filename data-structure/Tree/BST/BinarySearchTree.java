
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


	// 탐색 연산 메소드. 같은 key값이 존재하면 해당 노드 반환, 없으면 null 반환
	public TreeNode find(int key) {
		TreeNode cur = root;
		
		while(cur != null) {
			if(cur.getKey() == key) {
				return cur; // 키 값이 같으면 현재 노드 반환
			}
			else if(cur.getKey() > key) {
				cur = cur.getLeft();
			}
			else {
				cur = cur.getRight();
			}
		}
		return null; // 같은 key깂이 없을때 null 리턴
	}
	
	
	// 삽입 연산
	public void insert(int key) {
		if(find(key) != null) { // 이미 존재하는 key이면 종료
			System.out.println("The Key(" + key + ") Already Exists !!!");
			return;
		}
		
		TreeNode newNode = new TreeNode(key);
		
		if(root == null) { // 트리가 비어있을때 root에 추가
			root = newNode;
		}
		else {
			TreeNode cur = root; // 탐색용 포인터 노드
			TreeNode parent = null; // cur의 부모노드
			while(true) {
				parent = cur;
				
				if(key < cur.getKey()) { // 삽입하려는 키값이 현재 노드의 키값보다 작으면
					cur = cur.getLeft(); // 왼쪽자식으로 이동
					
					if(cur == null) { // 왼쪽자식이 null 이면
						parent.setLeft(newNode); // 왼쪽자식에 newNode 삽입
						return;
					}
				}
				else {// 삽입하려는 키값이 현재 노드의 키값보다 크면
					cur = cur.getRight(); // 오른쪽 자식에 같은방법으로 삽입
					
					if(cur == null){
						parent.setRight(newNode);
						return;
					}
				}
			}
		}
	}
	
	
	// 삭제 연산 메소드
	public boolean remove(int key) {
		if(find(key) == null) {
			System.out.println("The key value("+key+") doesn't exist !!!");
			return false;
		}
		
		TreeNode cur = root; // 삭제할 노드
		TreeNode parent = null; // 삭제할 노드의 부모노드
		boolean isLeftChild = false;
		
		// while문 끝나면 cur에 삭제할 노드 저장되어있음.
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
		
		
		 // 삭제할 노드가 자식이 없을때
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
		 // 삭제할 노드가 오른쪽자식만 있을때 
		else if(cur.getLeft() == null) {
			if(cur == root) {
				root = cur.getRight();
			}
			else if(isLeftChild) { // 삭제할 노드가 parent의 왼쪽자식일때
				parent.setLeft(cur.getRight());
			}
			else { // 삭제할 노드가 parent의 오른쪽자식일때
				parent.setRight(cur.getRight());
			}
		}
		 // 삭제할 노드가 왼쪽자식만 있을때 
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
		// 삭제할 노드가 자식이 모두 있는경우
		// 삭제할 노드는 오른쪽 서브트리의 가작 작은 키값을 가진 노드로 바꾼다. 
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
	
	
	// 내부노드(적어도 한개의 자식이 있는노드)인지 여부 반환
	public boolean isInternal(TreeNode v) {
		return (v.getLeft() != null || v.getRight() != null);
	}
	
	
	// 삭제하려는 노드의 오른쪽 서브트리의 최소값 반환하는 메소드
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

	
	// 전위순회
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
	
	// 중위순회
	public void inOrder(TreeNode v) {
		if(v != null){ 
			if(v.getLeft() != null)
				inOrder(v.getLeft());
			System.out.print(v.getKey() + " ");
			if(v.getRight() != null)
				inOrder(v.getRight());
		}
	}
	
	// 후위순회
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
	
	
