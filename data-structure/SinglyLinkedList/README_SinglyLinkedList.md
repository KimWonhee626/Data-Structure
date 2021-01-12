# 단일 연결 리스트 (Singly Linked list) 설명
---
</br>

데이터들이 한쪽 방향으로만 연결되어있는 리스트입니다.
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

헤드(head)노드와 테일(tail)노드는 각각 제일 첫번째와 제일 마지막 노드로
연결리스트에 접근하기 위한 기준점이 되고 데이터를 저장하지 않습니다.
</br>
</br>
</br>

### 단일 연결리스트 주요 메소드
1. 노드 반환
- 1.1 Node getNode(int idx) : 해당 인덱스의 노드를 반환
```java
	public Node getNode(int idx) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("index :" + idx + " size :" + size);
		}
		else {
			Node n = head.next;
			for(int i=0; i<idx; i++)
				n = n.next;
			return n;
		}
	}
```

2. 삽입
- 2.1 void addFirst(String data) : 처음에 노드 삽입
``` java
	public void addFirst(String data) {
		Node newNode = new Node(data);
		newNode.next = head.next;
		head.next = newNode;
		size++; // 리스트 크기 증가
	}
```

- 2.2 void add(String data) : 원하는 위치에 노드 삽입
```java
	public void add(String data) {
		if(size == 0) {
			addFirst(data);
			return;
		}
		Scanner sc = new Scanner(System.in);
		int idx;
		
		System.out.print("인덱스를 입력하세요.>> ");
		idx = sc.nextInt();
		
		if(idx < 0 || idx >= size) {
			sc.close();
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		
		if(idx == 0)
			addFirst(data);
		
		else {
		Node newNode = new Node(data);
		Node prevNode = getNode(idx - 1);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		size++;
		}
		
		sc.close();
	}
```

3. 삭제
- 3.1 String removeFirst() : 첫번째 위치의 노드 삭제
```java
	public String removeFirst() {
		Node n = head.next;
		head.next = n.next;
		size--;
		
		return n.data;
	}
```

- 3.2 String remove(int idx) : 해당 인덱스의 노드 삭제
```java
	public String remove(int idx) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		if(idx == 0)
			return removeFirst();
		
		Node prevNode = getNode(idx - 1);
		Node n = prevNode.next;
		prevNode.next = n.next;
		size--;
		
		return n.data;
	}
```

4. 출력
- 4.1 void print() : 리스트의 원소들 출력
```java
	public void print() {
		Node p = head;
		System.out.print("[ ");
		for(int i=0; i<size; i++) {
			p = p.next;
			System.out.print(p.data + " ");
		}
		System.out.println("]");
	}
```