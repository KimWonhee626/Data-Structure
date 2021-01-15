import java.util.Scanner;


// 리스트를 이용한 스택


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
	private Node top; // 스택의 top 참조
	
	// 리스트 스택 생성자
	ListStack(){
		top = null;
	}
	
	
	// 스택이 비어있는지  체크
	public boolean isEmpty() {
		return (top == null);
	}
	
	// 데이터 삽입
	public void push(Object data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	
	
	// top 노드 반환
	public Node peek() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		return top;
	}
	
	
	// 데이터 삭제 후 반환
	public Node pop() {
		Node remove = peek();
		top = top.next;
		return remove;
	}
	
	
	// 모든 데이터 출력
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
	
	
	// 스택에 데이터 삽입, 삭제 및 top노드와 모든 데이터 출력
	public static void main(String[] args) {
		ListStack stack = new ListStack(); // 스택 생성
		
		int count; // 연산 횟수
		Object data;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("연산 횟수를 입력하세요. >> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu;
			System.out.println("=============================================");
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1.삽입, 2.삭제, 3.가장 위 데이터 출력, 4.모든 데이터 출력 >> ");
			menu = sc.nextInt();
			if(menu == 1) {
				System.out.print("데이터를 입력하세요. >>");
				data = sc.next();
				stack.push(data);
			}
			if(menu == 2) {
				System.out.println("삭제된 데이터 : " + stack.pop().data.toString());
			}
			if(menu == 3) {
				System.out.println("가장 위 데이터 :" + stack.peek().data.toString());
			}
			if(menu == 4) {
				stack.print();
			}
		}
		sc.close();
	}

}
