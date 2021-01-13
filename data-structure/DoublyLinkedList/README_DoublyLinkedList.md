# 이중 연결 리스트 (Doubly Linked list)
---
</br>

이중 연결 리스트란 데이터들이 *양방향*으로 연결되어 있는 리스트 입니다.
</br>

이중 연결 리스트의 노드는 이전 노드를 가리키는 prev변수, 다음 노드를 가리키는 next변수, 
데이터를 저장하는 data변수를 가지고 있습니다.
```java
	private class Node {
        public Node prev; // 이전 노드를 가리킴
		public Node next; // 다음 노드를 가리킴
		private String data; // 데이터 저장
		
		Node() { }
		Node(String data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
```

</br>

이중 연결 리스트는 양방향으로 연결되어있기 때문에 헤드(head)와 테일(tail)이 있고,
이는 연결리스트에 접근하기 위한 기준점이 됩니다.
</br>
</br>
</br>

## 이중 연결 리스트 주요 메소드
</br>

### 1. 노드 반환
- 1.1 Node getNode(int idx) : 해당 인덱스의 노드를 반환
```java
	// 효율을 위해 인덱스의 값에 따라 tail에서도 접근함.
	public Node getNode(int idx) {
		if(idx < 1 || idx > size + 1) {
			throw new IndexOutOfBoundsException("index :" + idx + " size :" + size);
		}
		if (idx < size/2){
			Node curNode = head;
			for(int i=1; i<idx; i++)
				curNode = curNode.next;
			return curNode;
		}
		else {
			Node curNode = tail;
			for(int i=size; i>idx; i--)
				curNode = curNode.prev;
			return curNode;
		}
	}
```
</br>
</br>

### 2. 삽입
- 2.1 void addFirst(String data) : 맨 앞에 노드 삽입
```java
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if(head == null) { // 리스트가 비어있을 때
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode; // 새로운 노드를 head로 업데이트
		}
		size++;
	}
```
</br>

- 2.2 void add(int idx, String data) : 특정 인덱스에 노드 삽입
```java
	public void add(int idx, String data) {
		if(idx < 1 || idx > size + 1) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		
		if(idx == 1) {
			addFirst(data);
		}
		else if(idx == size + 1) {
			addLast(data);
		}
		else {
			Node newNode = new Node(data);
			Node curNode = getNode(idx);
			
			newNode.next = curNode;
			newNode.prev = curNode.prev;
			curNode.prev.next = newNode;
			curNode.prev = newNode;
			size++;
		}
	}
```
</br>
</br>

### 삭제
- 3.1 String removeFirst() : 첫 노드 (head) 삭제
```java
	public String removeFirst() {
		Node n = head;
		head = head.next;
		size--;
		return n.data;
	}
```
</br>

- 3.2 String removeLast() : 마지막 노드 (tail) 삭제
```java
	public String removeLast() {
		Node n = tail;
		tail = tail.prev;
		size--;
		return n.data;
	}
```
</br>

- 3.3 String remove(int idx) : 특정 인덱스의 노드 삭제
```java
	public String remove(int idx) {
		if(idx < 1 || idx > size) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		if(idx == 1)
			return removeFirst();
		else if(idx == size)
			return removeLast();
		else {
			Node removeNode = getNode(idx);
			removeNode.prev.next = removeNode.next;
			removeNode.next.prev = removeNode.prev;
			size--;
			return removeNode.data;
		}
	}
```
</br>
</br>

### 4. 출력
-4.1 void print() : 리스트의 원소들 출력
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
### 장점
이중 연결 리스트의 큰 장점은 양방향으로 연결되어 있기 때문에,
노드를 양방향으로 탐색이 가능하다는 장점이 있습니다.
</br>

단일 연결 리스트의 경우에는 맨 끝의 데이터를 가져오기 위하여
head부터 순차적으로 탐색해야 하기 때문에 많은 연산을 필요로 합니다.
반면, 이중 연결 리스트는 tail에 바로 접근할 수 있어서 시간을 단축할 수 있습니다.
</br>

### 단점
단점은 이전 노드를 저장하기 위한 prev변수를 하나 더 사용해야 하기 때문에 메모리를 더 많이 사용합니다.
또한 구현이 단일 연결 리스트에 비해 복잡합니다.

</br>
</br>

하지만 시간을 단축할 수 있다는 장점이 크기 때문에,
대부분 이중 연결 리스트를 많이 사용합니다.
</br>
