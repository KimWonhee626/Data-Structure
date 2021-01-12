import java.util.Scanner;

// 단일 연결 리스트


public class SinglyLinkedList {
	// Node 클래스
	class Node{
		private String data;
		public Node next;
		
		public Node() { }
		
		public Node(String data) {
			this.data = data;
			this.next = null;
		}
	}
		
	private Node head; // 맨 처음 노드
	private Node tail; // 맨 끝 노드
	private int size; // 리스트의 크기
	
	
	//연결리스트의 생성자
	SinglyLinkedList(){
		head = new Node(null);
		tail = new Node(null);
		head.next = tail;
		size = 0;
	}
	
	
	//특정 인덱스의 노드 반환
	public Node getNode(int idx) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("index :" + idx + " size :" + size);
		}
		else {
			Node n = head.next;
			for(int i=0; i<idx; i++)
				n = n.next;
			return n;
		}
	}
	
		
	//맨 앞에 노드 삽입 메소드
	public void addFirst(String data) {
		Node newNode = new Node(data);
		newNode.next = head.next;
		head.next = newNode;
		size++; // 리스트 크기 증가
		
	}
	
	
	//원하는 위치에 노드 삽입 메소드
	public void add(String data) {
		if(size == 0) {
			addFirst(data);
			return;
		}
		Scanner sc = new Scanner(System.in);
		int idx;
		
		System.out.print("인덱스를 입력하세요.>> ");
		idx = sc.nextInt();
		
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		
		if(idx == 0)
			addFirst(data);
		
		else {
		Node newNode = new Node(data);
		Node prevNode = getNode(idx - 1);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		size++;
		}
	}
	
	
	//맨 앞 노드 삭제 메소드
	public String removeFirst() {
		Node n = head.next;
		head.next = n.next;
		size--;
		
		return n.data;
	}
	
	
	//특정 인덱스의 노드 삭제 메소드
	public String remove(int idx) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("index :" + idx + ", size :" + size);
		}
		if(idx == 0)
			return removeFirst();
		
		Node prevNode = getNode(idx - 1);
		Node n = prevNode.next;
		prevNode.next = n.next;
		size--;
		
		return n.data;
	}
	
	
	//리스트의 데이터 모두 출력
	public void print() {
		Node p = head;
		System.out.print("[ ");
		for(int i=0; i<size; i++) {
			p = p.next;
			System.out.print(p.data + " ");
		}
		System.out.println("]");
	}
	
	
	
	//데이터 삽입, 삭제, 탐색이 가능함.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SinglyLinkedList SList = new SinglyLinkedList();
		
		String data;
		int idx, count;
		
		System.out.print("횟수를 입력하세요.>> ");
		count = sc.nextInt();
		
		
		for(int i=0; i<count; i++) {
			int menu;
			System.out.println("메뉴를 선택하세요. ");
			System.out.println("1.삽입, 2.삭제, 3.출력");
			menu = sc.nextInt();
			
			if(menu == 1) {
			System.out.print("데이터를 입력하세오.>> ");
			data = sc.next();
			SList.add(data);
			System.out.println("리스트 크기 : " + SList.size);
			}
			
			if(menu == 2) {
				System.out.print("인덱스를 입력하세요.>> ");
				idx = sc.nextInt();
				System.out.println("삭제된 데이터 : " + SList.remove(idx));
			}
			
			if(menu == 3) {
				SList.print();
			}
		}
	}
}
