# 스택(Stack)
---
</br>

스택이란 사전적 의미로는 '쌓다'는 뜻이 있습니다.  
자료구조에서의 스택은 한 쪽 끝(top)에서만 자료를 넣고 뺄 수 있는 후입선출 형식을 가지고 있으며  
LIFO(Last In First Out)라 부릅니다.  
인터넷 브라우저의 뒤로가기, 앞으로가기 등에 이용됩니다. 
</br>
</br>
</br>

## 스택 주요 메소드
- push(data) : 데이터 삽입
- pop() : top의 데이터 삭제
- peek() : top 조회
- isEmpty() : 스택이 비어있는지 확인
- isFull() : 스택이 꽉 찼는지 조회 => ArrayStack 에서만 필요
</br>
</br>
</br>

## 1. ArrayStack : 배열을 이용한 스택  
</br>

### 1.1. ArrayStack 구현

```java
public class ArrayStack {
	
	private int top; // 스택 포인터
	private int stackSize;
	private Object [] stackArray;
	
	
	// 생성자
	public ArrayStack(int stackSize) {
		this.top = -1;
		this.stackSize = stackSize;
		this.stackArray = new Object[stackSize];
	}

	
	// 스택이 비어있는지 체크
	public boolean isEmpty() {
		return (top == -1);
	}
	
	
	// 스택이 가득 찼는지 체크
	public boolean isFull() {
		return (top == stackSize-1);
	}
	
	
	// 스택에 데이터 입력
	public void push(Object data) {
		if(isFull()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Full !! (Stack Size : " + stackSize + ")");
		}
		top++;
		stackArray[top] = data;
	}
	
	
	// 스택의 가장 위의 데이터 반환
	public Object peek() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		return stackArray[top];
	}
	
	
	// 스택의 데이터 삭제
	public Object pop() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		Object remove = peek();
		top--;
		return remove;
	}
	
	
	// 스택의 모든 데이터 출력
	public void print() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		for(int i=0; i<=top; i++) {
			System.out.print(stackArray[i].toString() + " ");
		}
		System.out.println();
	}
}
```
</br>

### 1.2. ArrayStack의 특징
배열로 구현한 스택의 장점은 구현이 쉽고 데이터의 접근 속도가 빠르다는 것입니다.  
하지만 스택의 크기가 고정되어 있기 때문에 최대 개수를 미리 정해놔야 한다는 단점이 있습니다.  
따라서 구현과 접근은 좋지만 프로젝트에서 활용할 때는 불편합니다.
</br>
</br>

## 2. ListStack : 리스트를 이용한 스택
</br>

### 2.1. ListStack 구현

```java
public class ListStack {
	private Node top; // 스택의 top 참조
	
	// 리스트 스택 생성자
	ListStack(){
		top = null;
	}
	
	
	// 스택이 비어있는지  체크
	public boolean isEmpty() {
		return (top == null);
	}

	
	// 데이터 삽입
	public void push(Object data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	
	
	// top 노드 반환
	public Node peek() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		return top;
	}
	
	
	// 데이터 삭제 후 반환
	public Node pop() {
		Node remove = peek();
		top = top.next;
		return remove;
	}
	
	
	// 모든 데이터 출력
	public void print() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		Node n = top;
		while(n.next != null) {
			System.out.println(n.data.toString() + " ");
			n = n.next;
		}
		System.out.println(n.data.toString());
	}
}
```
</br>

### 2.2. ListStack의 특징
연결리스트로 구현한 스택의 장점은 배열과 반대로 스택의 크기가 고정되어있지 않고, 삽입과 삭제가 용이하다는 것입니다.  
하지만 데이터를 조회하려면 처음부터 순서대로 순회해야 하기 때문에 많은 연산이 필요합니다.

</br>