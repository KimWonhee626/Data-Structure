import java.util.ArrayList;

public class MaxHeap {
private ArrayList<Integer> heap;
	
	public MaxHeap() {
		heap = new ArrayList<> ();
		heap.add(0); // ���� �ε����� 1���� �����ϱ� ���ؼ�.
		
	}
	
	//����
	public void insert(int key) {
		heap.add(key); // �� �ڿ� �߰�
		int pos = heap.size() - 1;
		
		
		// �θ��� Ű���� �ڽ��� Ű������ Ŭ������
		while(pos > 1 && heap.get(parent(pos)) < heap.get(pos)) {
			int tmp = heap.get(parent(pos)); // �θ��� Ű���� tmp�� ����
			heap.set(parent(pos), heap.get(pos));
			heap.set(pos, tmp); // �θ�� �ڽ� swap
			
			pos /= 2;
		}
	}
	
	//����
	public int remove() {
		if(heap.size() - 1 < 1) {
			return 0;
			
		}
		
		int remove = heap.get(1); // remove�� ��Ʈ ��� ���� (��Ʈ��� ����)
		heap.set(1,  heap.get(heap.size() - 1)); // ��Ʈ �ڸ��� ������ ��� ����
		heap.remove(heap.size() - 1); // ������ ��� ����
		
		int pos = 1;
		while(leftChild(pos) < heap.size() - 1) {
			
			int maxPos = leftChild(pos);
			int max = heap.get(maxPos);
			
			if((max < heap.get(rightChild(pos))) && (rightChild(pos) < heap.size())) {
				maxPos = rightChild(pos); // �������ڽ��� �� ũ�� maxPos�� ������ �ڽ� ����
				max = heap.get(maxPos);
			}
			
			if(heap.get(pos) < max) // �θ� �� ũ�� 
				break; // while�� ����
			else {
				int tmp = heap.get(pos); // �θ�� �� ū �ڽ� swap
				heap.set(pos, max);
				heap.set(maxPos, tmp);
				pos = maxPos;
			}
		}
		return remove;
	}
	
	public int parent(int pos) {
		return (pos/2);
	}
	
	public int leftChild(int pos) {
		return (2*pos);
	}
	
	public int rightChild(int pos) {
		return (2*pos + 1);
	}
	
	public void print() {
		for(int i=1; i<heap.size(); i++) {
			System.out.print(heap.get(i) + " ");
		}
	}
	

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap();
		
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(60);
		heap.insert(40);
		heap.insert(50);
		heap.insert(15);
		heap.insert(5);
		heap.insert(35);
		
		heap.print();
		System.out.println("");
		System.out.println("removed : "+ heap.remove());
		
		heap.print();
	}

}
