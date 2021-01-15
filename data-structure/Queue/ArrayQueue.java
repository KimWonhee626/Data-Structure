import java.util.Scanner;

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
