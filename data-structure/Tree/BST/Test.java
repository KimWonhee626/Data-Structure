import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		int count;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("연산 횟수를 입력하세요. >>");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu, key;
			System.out.println("=============================================");
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1.삽입, 2.삭제, 3.순회>> ");
			menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.print("삽입할 키 값을 입력하세요.>>");
				key = sc.nextInt();
				tree.insert(key);
			}
			else if(menu == 2) {
				System.out.print("삭제할 키 값을 입력하세요.>>");
				key = sc.nextInt();
				tree.remove(key);
			}
			else if(menu == 3) {
				System.out.print("1. 선위순회, 2. 중위순회, 3. 후위순회");
				menu = sc.nextInt();
				if(menu == 1) {
					tree.preOrder(tree.getRoot());
					System.out.println();
				}
				else if(menu == 2) {
					tree.inOrder(tree.getRoot());
					System.out.println();
				}
				else if(menu == 3) {
					tree.postOrder(tree.getRoot());
					System.out.println();
				}
				else {
					System.out.println("잘못된 번호입니다.");
				}
			}
			else {
				System.out.println("잘못된 번호입니다! 다시 입력하세요.");
				i--;
			}
		}
		sc.close();
	}
	
}
