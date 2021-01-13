import java.util.Scanner;

// ���� ���� ����Ʈ


public class SinglyLinkedList {
	// Node Ŭ����
	class Node{
		private String data;
		public Node next;
		
		public Node() { }
		
		public Node(String data) {
			this.data = data;
			this.next = null;
		}
	}
		
	private Node head; // �� ó�� ���
	private int size; // ����Ʈ�� ũ��
	
	
	//���Ḯ��Ʈ�� ������
	SinglyLinkedList(){
		size = 0;
	}
	
	
	//Ư�� �ε����� ��� ��ȯ
	public Node getNode(int idx) {
		if(idx < 1 || idx > size + 1) {
			throw new IndexOutOfBoundsException("index :" + idx + " size :" + size);
		}
		else {
			Node curNode = head;
			for(int i=1; i<idx; i++)
				curNode = curNode.next;
			return curNode;
		}
	}
	
		
	//�� �տ� ��� ���� �޼ҵ�
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if(head == null) { // ����Ʈ�� ������� ��
			head = newNode;
		}
		else {
		newNode.next = head;
		head = newNode;
		
		}
		size++; // ����Ʈ ũ�� ����
		
	}
	
	
	//���ϴ� ��ġ�� ��� ���� �޼ҵ�(1���� ����)
	public void add(int idx, String data) {
		if(idx < 1 || idx > size + 1) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		
		if(idx == 1) {
			addFirst(data);
		}
		else {
		Node newNode = new Node(data);
		Node prevNode = getNode(idx - 1);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		size++;
		}
	}
	
	
	//�� �� ��� ���� �޼ҵ�
	public String removeFirst() {
		Node n = head;
		head = head.next;
		size--;
		return n.data;
	}
	
	
	//Ư�� �ε����� ��� ���� �޼ҵ�
	public String remove(int idx) {
		if(idx < 1 || idx > size) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		if(idx == 1)
			return removeFirst();
		else {
		Node prevNode = getNode(idx - 1);
		Node n = prevNode.next;
		if(n.next == null) { // ������ ����϶�
			prevNode.next = null;
		}
		else {
			prevNode.next = n.next;
		}
		size--;
		return n.data;
		}
	}
	
	
	//����Ʈ�� ������ ��� ���
	public void print() {
		Node p = head;
		System.out.print("[ ");
		for(int i=0; i<size; i++) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println("]");
	}
	
	
	
	//������ ����, ����, Ž���� ������.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SinglyLinkedList SList = new SinglyLinkedList();
		
		String data;
		int idx, count;
		
		System.out.print("���� Ƚ���� �Է��ϼ���.>> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu;
			System.out.println("�޴��� �����ϼ���. ");
			System.out.println("1.����, 2.����, 3.���");
			menu = sc.nextInt();
			
			if(menu == 1) {
			System.out.print("�����͸� �Է��ϼ���.>> ");
			data = sc.next();
			System.out.print("�ε����� �Է��ϼ���.>> ");
			idx = sc.nextInt();
			SList.add(idx, data);
			System.out.println("����Ʈ ũ�� : " + SList.size);
			}
			
			if(menu == 2) {
				System.out.print("�ε����� �Է��ϼ���.>> ");
				idx = sc.nextInt();
				System.out.println("������ ������ : " + SList.remove(idx));
			}
			
			if(menu == 3) {
				SList.print();
			}
		}
		sc.close();
	}
}
