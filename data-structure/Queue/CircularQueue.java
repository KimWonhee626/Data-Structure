import java.util.Scanner;

// ��ȭ�� ������ �����ϱ� ���� �迭�� ��ĭ�� �����!!
public class CircularQueue {
	private int front;
	private int rear;
	private int size;
	private Object [] queueArray;
	
	
	// CircularQueue ������
	CircularQueue(int size){
		this.size = size;
		this.front = 0; // front�� ���� ù��° ���Һ��� �� �� ���� ����Ŵ.
		this.rear = 0;
		this.queueArray = new Object[size];
		
	}
	
	// ť�� ������� Ȯ��
	public boolean isEmpty() {
		return (rear == front);
	}
	
	//ť�� ���� á���� Ȯ��
	public boolean isFull() {
		return ((rear+1)%size == front);
	}
	
	// rear�� ������ �߰�
	public void add(Object data) {
		if(isFull()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Full !!!");
		}
		rear = (rear+1)%size;
		queueArray[rear] = data;
	}

	// front�� ������ �߰�
	public Object remove() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty !!");
		}
		front = (front+1)%size;
		return queueArray[front];
	}
	
	// ��� ������ ���
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
	
	
	//ť�� ������ ����, ����, ������ ���
	public static void main(String[] args) {
		int size;
		int count;
		Scanner sc = new Scanner(System.in);
		System.out.print("ť�� �ִ� ũ�⸦ �Է��ϼ���. >> ");
		size = sc.nextInt();
		
		CircularQueue queue = new CircularQueue(size);
		
		System.out.print("���� Ƚ���� �Է��ϼ���. >> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu;
			System.out.println("=============================================");
			System.out.println("�޴��� �����ϼ���.");
			System.out.print("1.����, 2.����, 3.��� ������ ��� >> ");
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
				queue.print();
			}
		}
		sc.close();
	}
}
