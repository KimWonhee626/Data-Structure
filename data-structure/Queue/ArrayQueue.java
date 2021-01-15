import java.util.Scanner;

public class ArrayQueue {
	
	private int front;
	private int rear;
	private int queueSize;
	private Object [] queueArray;
	
	
	// ArrayQueue �ļ���
	ArrayQueue(int queueSize){
		this.queueSize = queueSize;
		this.front = 0;
		this.rear = -1;
		this.queueArray = new Object[queueSize];
	}
	
	// ť�� ����ִ��� Ȯ��
	public boolean isEmpty() {
		return (front == rear+1);
	}
	
	// ť�� �� á���� Ȯ��
	public boolean isFull() {
		return (rear == queueSize-1);
	}
	
	// ������ ����
	public void add(Object data) {
		if(isFull()) {
			throw new ArrayIndexOutOfBoundsException("ArrayQueue is Full !! (ArrayQueue Size : " + queueSize + ")");
		}
		rear++;
		queueArray[rear] = data;
	}
	
	// front ��ȯ
	public Object peek() {
		return queueArray[front];
	}
	
	// rear ������ ����
	public Object remove() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty !!");
		}
		Object remove = peek();
		front++;
		return remove;
	}
	
	// ��� ������ ���
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
	
	
	//������ ����, ����, peek, ���
	public static void main(String[] args) {
		int queueSize;
		int count; // ���� Ƚ��
		Scanner sc = new Scanner(System.in);
		System.out.print("ť�� �ִ� ũ�⸦ �Է��ϼ���. >> ");
		queueSize = sc.nextInt();
		
		ArrayQueue queue = new ArrayQueue(queueSize);
		
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
				System.out.println("������ ������ : " + queue.remove().toString());
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
