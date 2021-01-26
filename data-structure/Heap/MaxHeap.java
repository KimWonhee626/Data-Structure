import java.util.ArrayList;

public class MaxHeap {
private ArrayList<Integer> heap;
	
	public MaxHeap() {
		heap = new ArrayList<> ();
		heap.add(0); // 힙의 인덱스를 1부터 시작하기 위해서.
		
	}
	
	//삽입
	public void insert(int key) {
		heap.add(key); // 맨 뒤에 추가
		int pos = heap.size() - 1;
		
		
		// 부모의 키값이 자식의 키값보다 클때까지
		while(pos > 1 && heap.get(parent(pos)) < heap.get(pos)) {
			int tmp = heap.get(parent(pos)); // 부모의 키값을 tmp에 저장
			heap.set(parent(pos), heap.get(pos));
			heap.set(pos, tmp); // 부모와 자식 swap
			
			pos /= 2;
		}
	}
	
	//삭제
	public int remove() {
		if(heap.size() - 1 < 1) {
			return 0;
			
		}
		
		int remove = heap.get(1); // remove에 루트 노드 저장 (루트노드 삭제)
		heap.set(1,  heap.get(heap.size() - 1)); // 루트 자리에 마지막 노드 삽입
		heap.remove(heap.size() - 1); // 마지막 노드 삭제
		
		int pos = 1;
		while(leftChild(pos) < heap.size() - 1) {
			
			int maxPos = leftChild(pos);
			int max = heap.get(maxPos);
			
			if((max < heap.get(rightChild(pos))) && (rightChild(pos) < heap.size())) {
				maxPos = rightChild(pos); // 오른쪽자식이 더 크면 maxPos에 오른쪽 자식 저장
				max = heap.get(maxPos);
			}
			
			if(heap.get(pos) < max) // 부모가 더 크면 
				break; // while문 종료
			else {
				int tmp = heap.get(pos); // 부모와 더 큰 자식 swap
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
