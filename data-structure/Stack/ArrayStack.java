import java.util.Scanner;


// 배열을 이용한 스택

public class ArrayStack {
	
	private int top; // 스택 포인터
	private int stackSize;
	private Object [] stackArray;
	
	
	// 생성자
	public ArrayStack(int stackSize) {
		this.top = -1;
		this.stackSize = stackSize;
		this.stackArray = new Object[stackSize];
	}

	
	// 스택이 비어있는지 체크
	public boolean isEmpty() {
		return (top == -1);
	}
	
	
	// 스택이 가득 찼는지 체크
	public boolean isFull() {
		return (top == stackSize-1);
	}
	
	
	// 스택에 데이터 입력
	public void push(Object data) {
		if(isFull()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Full !! (Stack Size : " + stackSize + ")");
		}
		top++;
		stackArray[top] = data;
	}
	
	
	// 스택의 가장 위의 데이터 반환
	public Object peek() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		return stackArray[top];
	}
	
	
	// 스택의 데이터 삭제
	public Object pop() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty !!");
		}
		Object remove = peek();
		top--;
		return remove;
	}
	
	
	// 스택의 모든 데이터 출력
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
		int count, menu; // 연산 횟수, 메뉴번호
		Object data;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("스택의 크기를 입력하세요. >> ");
		stackSize = sc.nextInt();
		
		ArrayStack stack = new ArrayStack(stackSize); // 스택 생성
		
		System.out.print("연산 횟수를 입력하세요. >> ");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
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
				System.out.println("삭제된 데이터 : " + stack.pop().toString());
			}
			if(menu == 3) {
				System.out.println("가장 위 데이터 :" + stack.peek().toString());
			}
			if(menu == 4) {
				stack.print();
			}
		}
		sc.close();
	}

}
