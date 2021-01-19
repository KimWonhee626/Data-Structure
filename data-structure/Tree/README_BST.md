# 이중 탐색 트리(Binary Search Tree)
</br>

이중 탐색 트리(BST)는 탐색을 위한 자료구조로 이진 트리를 사용하여 저장할 데이터의 크기에 따라 노드의 위치를 정의한 것입니다.
</br>

사용 예시로는 전화번호부의 전화번호 찾기, 지도의 목적지 찾기 등이 있습니다.  
탐색을 할 때 자료를 식별할 수 있는 유일한 값이 필요한데 이를 **키(key)**라고 합니다.  
</br>

효율적인 탐색 작업을 위해서 BST는 다음과 같은 특징을 가집니다.  

  1. 모든 원소는 서로 다른 유일한 키를 갖는다.  
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
				return cur;
			}
			else if(cur.getKey() < key) {
				cur = cur.getLeft();
			}
			else {
				cur = cur.getRight();
			}
		}
		return cur; // 같은 key깂이 없을때 null 리턴됨
	}
```
</br>
</br>
</br>

## 2. BST의 삽입 연산
BST의 모든 원소는 유일한 키값을 가져야 하므로 탐색 연산을 수행하여 삽입하려는 원소와 키값이 같은 원소가 존재하는지 확인해야 합니다.  
</br>
</br>

### 2.1 삽입 구현 코드
```java
	public void insert(int key) {
		if(find(key) != null) {
			System.out.println("The Key Already Exists !!!");
			return;
		}
		
		TreeNode newNode = new TreeNode(key);
		
		if(root == null) { // 트리가 비어있을때 root에 추가
			root = newNode;
			return;
		}
		
		TreeNode n = root; // 탐색용 포인터 노드
		TreeNode parent; // n의 부모노드
		while(true) {
			parent = n;
			
			if(key < n.getKey()) { // 삽입하려는 키값이 현재 노드의 키값보다 작으면
				n = n.getLeft(); // 왼쪽자식으로 이동
				
				if(n == null) { // 왼쪽자식이 null 이면
					parent.setLeft(newNode); // 부모노드의 왼쪽자식에 newNode 삽입
					return;
				}
			}
			else {// 삽입하려는 키값이 현재 노드의 키값보다 크면
				n = n.getRight(); // 오른쪽 자식에 같은방법으로 삽입
				
				if(n == null);
				parent.setRight(newNode);
			}
		}
	}
```
</br>
</br>
</br>

## 3. BST의 삭제 연산


