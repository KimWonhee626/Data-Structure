# 이중 탐색 트리(Binary Search Tree)
</br>

이중 탐색 트리(BST)는 탐색을 위한 자료구조로 이진 트리를 사용하여 저장할 데이터의 크기에 따라 노드의 위치를 정의한 것입니다.
</br>

사용 예시로는 전화번호부의 전화번호 찾기, 지도의 목적지 찾기 등이 있습니다.  
탐색을 할 때 자료를 식별할 수 있는 유일한 값이 필요한데 이를 **키(key)**라고 합니다.  
</br>

효율적인 탐색 작업을 위해서 BST는 다음과 같은 특징을 가집니다.  

  1. 모든 원소는 서로 다른 **유일한 키**를 갖는다.  
  2. 왼쪽 서브 트리에 있는 원소의 키는 그 루트의 키보다 작다.  
  3. 오른쪽 서브 트리에 있는 원소의 키는 그 루트의 키보다 크다.  
  4. 왼쪽 서브 트리와 오른쪽 서브 트리도 이진탐색 트리다.  
</br>
</br>
</br>

## 1. BST의 탐색 연산
탐색은 루트노드에서 시작합니다.(v = root)  
먼저 찾으려는 키값(k)과 현재 노드의 키값(v)을 비교하여 **(k == v) -> 성공**, **(k > v) -> 오른쪽 서브트리에서 탐색 수행**, **(k < v) -> 왼쪽 서브트리에서 탐색 수행**을 합니다.  
</br>
</br>

### 1.1 탐색 구현 코드
```java
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
```
</br>
</br>
</br>

## 2. BST의 삽입 연산
BST의 모든 원소는 유일한 키값을 가져야 하므로 탐색 연산을 수행하여 삽입하려는 원소와 키값이 같은 원소가 존재하는지 확인해야 합니다.  
</br>

삽입하려는 키값이 현재 노드의 키값보다 작은 경우 왼쪽자식으로, 클 경우 오른쪽 자식으로 이동하여 null을 만나면 그자리에 새로운 노드를 삽입합니다.
</br>
</br>

### 2.1 삽입 구현 코드
```java
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
```
</br>
</br>
</br>

## 3. BST의 삭제 연산  
삭제 연산은 노드를 삭제한 후 나머지 노드들을 어떻게 연결할 것인지 생각해야 하기때문에 조금 복잡합니다.  
</br>

따라서 아래의 3가지 경우로 나누어 보겠습니다.
1. 자식 노드가 없는경우
2. 자식 노드가 하나만 있는 경우
3. 자식 노드가 둘 다 있는 경우


### 3.1 삭제 구현 코드

```java
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

```
</br>
</br>
</br>

### 4. 순회 코드

```java
	// 전위순회
	public void preOrder(TreeNode v) {
		if(v != null){ 
			System.out.println(v.getKey());
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
			System.out.println(v.getKey());
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
			System.out.println(v.getKey());
		}
	}

```
