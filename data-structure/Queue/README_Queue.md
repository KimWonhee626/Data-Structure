# 큐(Queue)
---
</br>

큐는 먼저 넣은 데이터가 먼저 나오는 FIFO(First In First Out)구조로 저장하는 형식을 가지고 있습니다.  
데이터 삽입은 rear에서, 삭제와 peek는 front에서 일어납니다.  
</br>

활용 예시로는 은행의 번호표, 프린터의 인쇄 대기열 등이 있습니다.  

</br>
</br>
</br>

## 큐의 종류
- 1. ArrayQueue : 배열을 이용한 큐
- 2. ListQueue : 리스트를 이용한 큐
- 3. CircularQueue : 선형큐(ArrayQueue)의 단점을 보완한 큐
</br>
</br>
</br>

## 큐 주요 메소드
- add(data) : rear부분에 데이터 추가
- remove() : front의 데이터 삭제 후 반환
- peek() : front의 데이터 반환 (삭제 x)
- isEmpty() : 큐가 비어있는지 체크
- isFull() : 큐가 가득 찼는지 체크 => 배열을 이용한 큐에서만 필요!
</br>
</br>
</br>
</br>

## 1. ArrayQueue : 배열을 이용한 큐  
</br>

### 1.1. ArrayQueue 구현
```java
public class ArrayQueue {
	
	private int front;
	private int rear;
	private int queueSize;
	private Object [] queueArray;
	
	
	// ArrayQueue 셍성자
	ArrayQueue(int queueSize){
		this.queueSize = queueSize;
		this.front = 0;
		this.rear = -1;
		this.queueArray = new Object[queueSize];
	}
	
	// 큐가 비어있는지 확인
	public boolean isEmpty() {
		return (front == rear+1);
	}
	
	// 큐가 꽉 찼는지 확인
	public boolean isFull() {
		return (rear == queueSize-1);
	}
	
	// 데이터 삽입
	public void add(Object data) {
		if(isFull()) {
			throw new ArrayIndexOutOfBoundsException("ArrayQueue is Full !! (ArrayQueue Size : " + queueSize + ")");
		}
		rear++;
		queueArray[rear] = data;
	}
	
	// front 반환
	public Object peek() {
		return queueArray[front];
	}
	
	// rear 데이터 삭제
	public Object remove() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty !!");
		}
		Object remove = peek();
		front++;
		return remove;
	}
	
	// 모든 데이터 출력
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is Empty !!");
			return;
		}
		System.out.print("[ ");
		for(int i=front; i<=rear; i++)
			System.out.print(queueArray[i].toString() + " ");
		System.out.println("]");
	}
	
	
	//데이터 삽입, 삭제, peek, 출력
	public static void main(String[] args) {
		int queueSize;
		int count; // 연산 횟수
		Scanner sc = new Scanner(System.in);
		System.out.print("큐의 최대 크기를 입력하세요. >> ");
		queueSize = sc.nextInt();
		
		ArrayQueue queue = new ArrayQueue(queueSize);
		
		System.out.print("연산 횟수를 입력하세요. >> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu;
			System.out.println("=============================================");
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1.삽입, 2.삭제, 3.front출력, 4.모든 데이터 출력 >> ");
			menu = sc.nextInt();
			
			if(menu == 1) {
				Object data;
				System.out.print("데이터를 입력하세요. >>");
				data = sc.next();
				queue.add(data);
			}
			if(menu == 2) {
				System.out.println("삭제된 데이터 : " + queue.remove().toString());
			}
			if(menu == 3) {
				System.out.println("front : " + queue.peek().toString());
			}
			if(menu == 4) {
				queue.print();
			}
		}
		sc.close();
	}

}
```
</br>

### 1.2. ArrayQueue의 특징
배열을 이용하여 구현한 큐는 최대 크기가 고정되었다는 점과 데이터의 삽입과 삭제가 횟수가 늘어날수록 front와 rear가 증가하므로 이미 사용했던 배열의 인덱스를 다시 사용할 수 없다는 단점이 있습니다.  
따라서 배열에 데이터가 모두 차있지 않더라도 front가 증가하게 되면 배열 크기만큼의 데이터를 이용할 수 없습니다.  
이를 보완하기 위하여 rear와 front를 적절하게 수정하는 원형 큐(Circulat Queue)를 사용할 수 있습니다.  
원형큐에 대한 것은 후에 다뤄보도록 하겠습니다.  
</br>
</br>
</br>
</br>

## 2. ListQueue : 리스트를 이용한 큐
</br>

### 2.1. ListQueue 구현

```java
class Node{
	Object data;
	Node next;
	
	public Node(Object data){
		this.data = data;
		this.next = null;
	}
}


public class ListQueue {
	private Node front;
	private Node rear;
	
	ListQueue(){
		this.front = null;
		this.rear = null;
	}
	
	
	// 큐가 비어있는지 확인
	boolean isEmpty() {
		return (front == null);
	}
	
	
	// 큐의 rear에 데이터 삽입
	public void add(Object data) {
		if(isEmpty()) { // 큐가 비어있을 때
			front = new Node(data);
			rear = front;
		}
		
		else {
			Node newNode = new Node(data);
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	
	// front노드 반환
	public Node peek() {
		if(isEmpty()) { // 비어있을 때 null 반환
			System.out.println("Queue is Empty !!!");
			return null;
		}
		return front;
	}
	
	
	// front 노드 삭제 후 반환
	public Node remove() {
		Node remove = peek();
		if(remove == null) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty !!!");

		}
		front = front.next;
		return remove;
	}
	
	
	// 큐의 모든 데이터 출력
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is Empty !!!");
			return;
		}
		Node n = peek(); // 노드 n에 front 대입
		System.out.print("[ ");
		while(n.next != null) {
			System.out.print(n.data.toString() + " ");
			n = n.next;
		}
		System.out.println(n.data.toString() + " ]");
	}

	
	// 삽입, 삭제, peek, 출력 
	public static void main(String[] args) {
		int count;
		ListQueue queue = new ListQueue();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("연산 횟수를 입력하세요. >> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu;
			System.out.println("=============================================");
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1.삽입, 2.삭제, 3.front출력, 4.모든 데이터 출력 >> ");
			menu = sc.nextInt();
			
			if(menu == 1) {
				Object data;
				System.out.print("데이터를 입력하세요. >>");
				data = sc.next();
				queue.add(data);
			}
			if(menu == 2) {
				System.out.println("삭제된 데이터 : " + queue.remove().data.toString());
			}
			if(menu == 3) {
				Node peek = queue.peek();
				if(peek == null)
					continue;
				else
					System.out.println("front : " + peek.data.toString());
			}
			if(menu == 4) {
				queue.print();
			}
		}
		sc.close();
	}
}
```
</br>
</br>

### 2.2. ListQueue의 특징
연결 리스트를 이용하여 큐를 구현할 때는 큐의 크기를 미리 지정하지 않아도 되기 때문에 배열 큐에 비해 저장공간을 낭비하지 않는다는 장점을 가지고 있습니다.  
<br>
비어있는 큐에 데이터를 삽입할 때는 새로운 노드가 front와 rear가 됩니다.  
비어있지 않은 큐에 데이터를 삽입할 때는 rear의 next에 새로운 노드를 연결한 후 rear을 새로운 노드로 업데이트 합니다.
</br>
</br>
</br>
</br>

## 3. CircularQueue : 선형큐의 단점을 보완하는 큐
</br>

### 3.1. CircularQueue 구상
- front, rear, 배열의 초기값은 0으로 놓습니다.
- 삽입 시 rear값을 하나 증가시킨 후 데이터를 삽입합니다.
- 삭제 시 front값을 하나 증가시킨 후 front가 가리키는 데이터를 삭제하고 반환합니다.
- front = rear면 공백상태, front가 rear보다 하나 앞에 있으면 포화상태로 정의합니다.

![원형큐](https://user-images.githubusercontent.com/69297345/104682946-3f332180-5739-11eb-9b49-46869ca26dc8.PNG)


</br>
</br>

### 3.2. CircularQueue 구현
```java
// 포화와 공백을 구분하기 위해 배열의 한칸은 비워둠!!
public class CircularQueue {
	private int front;
	private int rear;
	private int size;
	private Object [] queueArray;
	
	
	// CircularQueue 생성자
	CircularQueue(int size){
		this.size = size;
		this.front = 0; // front는 실제 첫번째 원소보다 한 셀 앞을 가리킴.
		this.rear = 0;
		this.queueArray = new Object[size];
		
	}
	
	// 큐가 비었는지 확인
	public boolean isEmpty() {
		return (rear == front);
	}
	
	//큐가 가득 찼는지 확인
	public boolean isFull() {
		return ((rear+1)%size == front);
	}
	
	// rear에 데이터 추가
	public void add(Object data) {
		if(isFull()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Full !!!");
		}
		rear = (rear+1)%size;
		queueArray[rear] = data;
	}

	// front에 데이터 추가
	public Object remove() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty !!");
		}
		front = (front+1)%size;
		return queueArray[front];
	}
	
	// 모든 데이터 출력
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is Empty !!!");
			return;
		}
		int p = front + 1;
		while(p != rear) {
			System.out.print(queueArray[p].toString() + " ");
			p = (p+1)%size;
		}
		System.out.println(queueArray[p].toString());
		
	}
	
	
	//큐에 데이터 삽입, 삭제, 데이터 출력
	public static void main(String[] args) {
		int size;
		int count;
		Scanner sc = new Scanner(System.in);
		System.out.print("큐의 최대 크기를 입력하세요. >> ");
		size = sc.nextInt();
		
		CircularQueue queue = new CircularQueue(size);
		
		System.out.print("연산 횟수를 입력하세요. >> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu;
			System.out.println("=============================================");
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1.삽입, 2.삭제, 3.모든 데이터 출력 >> ");
			menu = sc.nextInt();
			
			if(menu == 1) {
				Object data;
				System.out.print("데이터를 입력하세요. >>");
				data = sc.next();
				queue.add(data);
			}
			if(menu == 2) {
				System.out.println("삭제된 데이터 : " + queue.remove().toString());
			}
			if(menu == 3) {
				queue.print();
			}
		}
		sc.close();
	}
}

```
</br>
</br>

### 3.3. CircularQueue의 특징
원형큐는 직선형태의 선형큐(ArrayQueue)의 단점을 보완하는 큐 입니다.  
선형큐에서 삽입과 삭제를 반복하다보면 데이터가 없음에도 사용하지 못하는 메모리가 생기게 되는데, 원형큐에서는 rear나 front가 배열의 끝 인덱스에 가게되면 다시 처음부터 데이터를 저장하므로 메모리를 효율적으로 사용할 수 있습니다.
</br>
