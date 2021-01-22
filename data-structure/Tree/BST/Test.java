import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		int count;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� Ƚ���� �Է��ϼ���. >>");
		count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			int menu, key;
			System.out.println("=============================================");
			System.out.println("�޴��� �����ϼ���.");
			System.out.print("1.����, 2.����, 3.��ȸ>> ");
			menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.print("������ Ű ���� �Է��ϼ���.>>");
				key = sc.nextInt();
				tree.insert(key);
			}
			else if(menu == 2) {
				System.out.print("������ Ű ���� �Է��ϼ���.>>");
				key = sc.nextInt();
				tree.remove(key);
			}
			else if(menu == 3) {
				System.out.print("1. ������ȸ, 2. ������ȸ, 3. ������ȸ");
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
					System.out.println("�߸��� ��ȣ�Դϴ�.");
				}
			}
			else {
				System.out.println("�߸��� ��ȣ�Դϴ�! �ٽ� �Է��ϼ���.");
				i--;
			}
		}
		sc.close();
	}
	
}
