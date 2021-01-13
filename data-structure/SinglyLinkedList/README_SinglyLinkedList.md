# 단일 연결 리스트 (Singly Linked list)
---
</br>

단일 연결 리스트란 데이터들이 한쪽 방향으로만 연결되어있는 리스트입니다.
</br>

단일 연결 리스트는 'Node'로 구성되며, 각 노드는 다음 노드를 저장하기 위한 변수 (next)와
데이터를 저장하기 위한 벼수 (data)를 가지고 있습니다.
```java
	class Node{
		private String data; // 데이터 저장
		public Node next; // 다음 노드를 저장

		public Node() { }
		
		public Node(String data) {
			this.data = data;
			this.next = null; // 생성자는 다음 노드에 null 저장
		}
	}
```

</br>

헤드(head)노드는 연결리스트에 접근하기 위한 기준점이 됩니다.
</br>
</br>
</br>

## 단일 연결리스트 주요 메소드
</br>

### 1. 노드 반환
- 1.1 Node getNode(int idx) : 해당 인덱스의 노드를 반환
```java
	public Node getNode(int idx) {
		if(idx < 1 || idx > size + 1) {
			throw new IndexOutOfBoundsException("index :" + idx + " size :" + size);
		}
		else {
			Node curNode = head;
			for(int i=1; i<idx; i++)
				curNode = curNode.next;
			return curNode;
		}
	}
```
</br>

### 2. 삽입
- 2.1 void addFirst(String data) : 처음에 노드 삽입
``` java
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if(head == null) { // 리스트가 비어있을 때
			head = newNode;
		}
		else {
		newNode.next = head;
		head = newNode; // head 업데이트
		}
		size++; // 리스트 크기 증가
	}
```
</br>

- 2.2 void add(String data) : 원하는 위치에 노드 삽입(1부터 시작)
```java
	public void add(int idx, String data) {
		if(idx < 1 || idx > size + 1) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		
		if(idx == 1) {
			addFirst(data);
		}
		else {
		Node newNode = new Node(data);
		Node prevNode = getNode(idx - 1);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		size++;
		}
	}
```
</br>

### 3. 삭제
- 3.1 String removeFirst() : 첫번째 위치의 노드 삭제
```java
	public String removeFirst() {
		Node n = head;
		head = head.next;
		size--;
		return n.data;
	}
```
</br>

- 3.2 String remove(int idx) : 해당 인덱스의 노드 삭제
```java
	public String remove(int idx) {
		if(idx < 1 || idx > size) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		if(idx == 1)
			return removeFirst();
		else {
		Node prevNode = getNode(idx - 1);
		Node n = prevNode.next;
		if(n.next == null) { // 마지막 노드일때
			prevNode.next = null;
		}
		else {
			prevNode.next = n.next;
		}
		size--;
		return n.data;
		}
	}
```
</br>

### 4. 출력
- 4.1 void print() : 리스트의 원소들 출력
```java
	public void print() {
		Node p = head;
		System.out.print("[ ");
		for(int i=0; i<size; i++) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println("]");
	}
```
</br>
</br>
</br>

## 정리
단일 연결 리스트는 삽입, 삭제 과정에서 링크(next)만 끊어주면 되기 때문에 효율적으로 데이터를 관리할 수 있습니다.
</br>

그러나 모든 데이터를 head를 통하여 접근해야 하기 때문에 배열 리스트에 비해 access능력은 떨어집니다.
</br>

따라서 삽입, 삭제가 빈번하게 일어나는 경우 단일 연결 리스트(Singly Linked List)를 사용하는 것이 좋고,
데이터 접근이 주로 일어나는 경우 배열 리스트(Array List)를 사용하는 것이 좋습니다.

</br>
