import java.util.Scanner;

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
