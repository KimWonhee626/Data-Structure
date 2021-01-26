import java.util.ArrayList;

public class MinHeap {
	private ArrayList<Integer> heap;
	
	public MinHeap() {
		heap = new ArrayList<> ();
		heap.add(0); // ���� �ε����� 1���� �����ϱ� ���ؼ�.
		
	}
	
	//����
	public void insert(int key) {
		heap.add(key); // �� �ڿ� �߰�
		int pos = heap.size() - 1;
		
		
		// �θ��� Ű���� �ڽ��� Ű������ ����������
		while(pos > 1 && heap.get(parent(pos)) > heap.get(pos)) {
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
			
			int minPos = leftChild(pos);
			int min = heap.get(minPos);
			
			if((min > heap.get(rightChild(pos))) && (rightChild(pos) < heap.size())) {
				minPos = rightChild(pos); // �������ڽ��� �� ������ minPos�� ������ �ڽ� ����
				min = heap.get(minPos);
			}
			
			if(heap.get(pos) < min) // �θ� �� ������
				break; // while�� ����
			else {
				int tmp = heap.get(pos); // �θ�� �� ���� �ڽ� swap
				heap.set(pos, min);
				heap.set(minPos, tmp);
				pos = minPos;
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
		MinHeap heap = new MinHeap();
		
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
