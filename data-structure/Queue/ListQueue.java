import java.util.Scanner;

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
