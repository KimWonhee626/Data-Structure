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
	
	
	// 특정 인덱스의 노드 반환
	// 이중 연결 리스트이므로 효율을 위해 인덱스의 값에 따라 tail에서도 접근함.
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
	
	
	// 맨 앞에 노드 삽입 메소드
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if(head == null) { // 리스트가 비어있을 때
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode; // 새로운 노드를 head로 업데이트
		}
		size++;
	}
	
	//마지막에 노드 삽입 메소드
	public void addLast(String data) {
		Node newNode = new Node(data);
		if(head == null) { // 리스트가 비어있을 때
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode; // 새로운 노드를 tail로 업데이트
		}
		size++;
	}
	
	
	// 특정 위치에 노드 삽입 메소드 (1부터 시작)
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
	
	
	//첫번째 노드 삭제 메소드
	public String removeFirst() {
		Node n = head;
		head = head.next;
		size--;
		return n.data;
	}
	
	
	//마지막 노드 삭제 메소드
	public String removeLast() {
		Node n = tail;
		tail = tail.prev;
		size--;
		return n.data;
	}
	
	
	// 특정 위치의 노드 삭제 메소드(1부터 시작)
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
	
	
	// 리스트 전체 출력 메소드
	public void print() {
		Node p = head;
		System.out.print("[ ");
		for(int i=0; i<size; i++) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println("]");
	}
	
	
	// 데이터 삽입, 삭제, 출력 가능
	public static void main(String[] args) {
		DoublyLinkedList DList = new DoublyLinkedList();
		
		Scanner sc = new Scanner(System.in);
		
		String data;
		int idx, count;
		
		System.out.print("연산 횟수를 입력하세요.>> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu;
			System.out.println("메뉴를 선택하세요. ");
			System.out.println("1.삽입, 2.삭제, 3.출력");
			menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.print("데이터를 입력하세오.>> ");
				data = sc.next();
				System.out.print("인덱스를 입력하세오.>> ");
				idx = sc.nextInt();
				DList.add(idx, data);
				System.out.println("리스트 크기 : " + DList.size);
				}
				
				if(menu == 2) {
					System.out.print("인덱스를 입력하세요.>> ");
					idx = sc.nextInt();
					System.out.println("삭제된 데이터 : " + DList.remove(idx));
				}
				
				if(menu == 3) {
					DList.print();
				}
		}
		sc.close();
	}
}
