import java.util.Scanner;


// ����Ʈ�� �̿��� ����


class Node{
	public Object data;
	public Node next;
	
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
	
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
}	

public class ListStack {
	private Node top; // ������ top ����
	
	// ����Ʈ ���� ������
	ListStack(){
		top = null;
	}
	
	
	// ������ ����ִ���  üũ
	public boolean isEmpty() {
		return (top == null);
	}
	
	// ������ ����
	public void push(Object data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	
	
	// top ��� ��ȯ
	public Node peek() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		return top;
	}
	
	
	// ������ ���� �� ��ȯ
	public Node pop() {
		Node remove = peek();
		top = top.next;
		return remove;
	}
	
	
	// ��� ������ ���
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
	
	
	// ���ÿ� ������ ����, ���� �� top���� ��� ������ ���
	public static void main(String[] args) {
		ListStack stack = new ListStack(); // ���� ����
		
		int count; // ���� Ƚ��
		Object data;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� Ƚ���� �Է��ϼ���. >> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu;
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
				System.out.println("������ ������ : " + stack.pop().data.toString());
			}
			if(menu == 3) {
				System.out.println("���� �� ������ :" + stack.peek().data.toString());
			}
			if(menu == 4) {
				stack.print();
			}
		}
		sc.close();
	}

}
