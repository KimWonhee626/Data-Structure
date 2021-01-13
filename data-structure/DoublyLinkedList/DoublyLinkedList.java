import java.awt.geom.Arc2D.Double;
import java.util.Scanner;

public class DoublyLinkedList {
	private class Node {
		private String data;
		public Node next;
		public Node prev;
		
		Node() { }
		Node(String data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	private Node head;
	private Node tail;
	public int size;
	
	DoublyLinkedList(){
		size = 0;
	}
	
	
	// Ư�� �ε����� ��� ��ȯ
	// ���� ���� ����Ʈ�̹Ƿ� ȿ���� ���� �ε����� ���� ���� tail������ ������.
	public Node getNode(int idx) {
		if(idx < 1 || idx > size + 1) {
			throw new IndexOutOfBoundsException("index :" + idx + " size :" + size);
		}
		if (idx < size/2){
			Node curNode = head;
			for(int i=1; i<idx; i++)
				curNode = curNode.next;
			return curNode;
		}
		else {
			Node curNode = tail;
			for(int i=size; i>idx; i--)
				curNode = curNode.prev;
			return curNode;
		}
	}
	
	
	// �� �տ� ��� ���� �޼ҵ�
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if(head == null) { // ����Ʈ�� ������� ��
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode; // ���ο� ��带 head�� ������Ʈ
		}
		size++;
	}
	
	//�������� ��� ���� �޼ҵ�
	public void addLast(String data) {
		Node newNode = new Node(data);
		if(head == null) { // ����Ʈ�� ������� ��
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode; // ���ο� ��带 tail�� ������Ʈ
		}
		size++;
	}
	
	
	// Ư�� ��ġ�� ��� ���� �޼ҵ� (1���� ����)
	public void add(int idx, String data) {
		if(idx < 1 || idx > size + 1) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		
		if(idx == 1) {
			addFirst(data);
		}
		else if(idx == size + 1) {
			addLast(data);
		}
		else {
			Node newNode = new Node(data);
			Node curNode = getNode(idx);
			
			newNode.next = curNode;
			newNode.prev = curNode.prev;
			curNode.prev.next = newNode;
			curNode.prev = newNode;
			size++;
		}
	}
	
	
	//ù��° ��� ���� �޼ҵ�
	public String removeFirst() {
		Node n = head;
		head = head.next;
		size--;
		return n.data;
	}
	
	
	//������ ��� ���� �޼ҵ�
	public String removeLast() {
		Node n = tail;
		tail = tail.prev;
		size--;
		return n.data;
	}
	
	
	// Ư�� ��ġ�� ��� ���� �޼ҵ�(1���� ����)
	public String remove(int idx) {
		if(idx < 1 || idx > size) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		if(idx == 1)
			return removeFirst();
		else if(idx == size)
			return removeLast();
		else {
			Node removeNode = getNode(idx);
			removeNode.prev.next = removeNode.next;
			removeNode.next.prev = removeNode.prev;
			size--;
			return removeNode.data;
		}
	}
	
	
	// ����Ʈ ��ü ��� �޼ҵ�
	public void print() {
		Node p = head;
		System.out.print("[ ");
		for(int i=0; i<size; i++) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println("]");
	}
	
	
	// ������ ����, ����, ��� ����
	public static void main(String[] args) {
		DoublyLinkedList DList = new DoublyLinkedList();
		
		Scanner sc = new Scanner(System.in);
		
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
				DList.add(idx, data);
				System.out.println("����Ʈ ũ�� : " + DList.size);
				}
				
				if(menu == 2) {
					System.out.print("�ε����� �Է��ϼ���.>> ");
					idx = sc.nextInt();
					System.out.println("������ ������ : " + DList.remove(idx));
				}
				
				if(menu == 3) {
					DList.print();
				}
		}
		sc.close();
	}
}
