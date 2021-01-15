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
	
	
	// ť�� ����ִ��� Ȯ��
	boolean isEmpty() {
		return (front == null);
	}
	
	
	// ť�� rear�� ������ ����
	public void add(Object data) {
		if(isEmpty()) { // ť�� ������� ��
			front = new Node(data);
			rear = front;
		}
		
		else {
			Node newNode = new Node(data);
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	
	// front��� ��ȯ
	public Node peek() {
		if(isEmpty()) { // ������� �� null ��ȯ
			System.out.println("Queue is Empty !!!");
			return null;
		}
		return front;
	}
	
	
	// front ��� ���� �� ��ȯ
	public Node remove() {
		Node remove = peek();
		if(remove == null) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty !!!");

		}
		front = front.next;
		return remove;
	}
	
	
	// ť�� ��� ������ ���
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is Empty !!!");
			return;
		}
		Node n = peek(); // ��� n�� front ����
		System.out.print("[ ");
		while(n.next != null) {
			System.out.print(n.data.toString() + " ");
			n = n.next;
		}
		System.out.println(n.data.toString() + " ]");
	}

	
	// ����, ����, peek, ��� 
	public static void main(String[] args) {
		int count;
		ListQueue queue = new ListQueue();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� Ƚ���� �Է��ϼ���. >> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu;
			System.out.println("=============================================");
			System.out.println("�޴��� �����ϼ���.");
			System.out.print("1.����, 2.����, 3.front���, 4.��� ������ ��� >> ");
			menu = sc.nextInt();
			
			if(menu == 1) {
				Object data;
				System.out.print("�����͸� �Է��ϼ���. >>");
				data = sc.next();
				queue.add(data);
			}
			if(menu == 2) {
				System.out.println("������ ������ : " + queue.remove().data.toString());
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
