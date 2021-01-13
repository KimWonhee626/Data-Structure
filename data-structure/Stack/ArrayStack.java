import java.util.Scanner;


// �迭�� �̿��� ����

public class ArrayStack {
	
	private int top; // ���� ������
	private int stackSize;
	private Object [] stackArray;
	
	
	// ������
	public ArrayStack(int stackSize) {
		this.top = -1;
		this.stackSize = stackSize;
		this.stackArray = new Object[stackSize];
	}

	
	// ������ ����ִ��� üũ
	public boolean isEmpty() {
		return (top == -1);
	}
	
	
	// ������ ���� á���� üũ
	public boolean isFull() {
		return (top == stackSize-1);
	}
	
	
	// ���ÿ� ������ �Է�
	public void push(Object data) {
		if(isFull()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Full !! (Stack Size : " + stackSize + ")");
		}
		top++;
		stackArray[top] = data;
	}
	
	
	// ������ ���� ���� ������ ��ȯ
	public Object peek() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		return stackArray[top];
	}
	
	
	// ������ ������ ����
	public Object pop() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		Object remove = peek();
		top--;
		return remove;
	}
	
	
	// ������ ��� ������ ���
	public void print() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		for(int i=0; i<=top; i++) {
			System.out.print(stackArray[i].toString() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int stackSize;
		int count, menu; // ���� Ƚ��, �޴���ȣ
		Object data;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ ũ�⸦ �Է��ϼ���. >> ");
		stackSize = sc.nextInt();
		
		ArrayStack stack = new ArrayStack(stackSize); // ���� ����
		
		System.out.print("���� Ƚ���� �Է��ϼ���. >> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			System.out.println("=============================================");
			System.out.println("�޴��� �����ϼ���.");
			System.out.print("1.����, 2.����, 3.���� �� ������ ���, 4.��� ������ ��� >> ");
			menu = sc.nextInt();
			if(menu == 1) {
				System.out.print("�����͸� �Է��ϼ���. >>");
				data = sc.next();
				stack.push(data);
			}
			if(menu == 2) {
				System.out.println("������ ������ : " + stack.pop().toString());
			}
			if(menu == 3) {
				System.out.println("���� �� ������ :" + stack.peek().toString());
			}
			if(menu == 4) {
				stack.print();
			}
		}
		sc.close();
	}

}
