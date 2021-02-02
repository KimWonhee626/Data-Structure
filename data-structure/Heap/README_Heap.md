# 힙(Heap)

힙이란 완전 이진 트리의 일종으로 **우선순위 큐**를 위해 만들어진 자료구조 입니다.  
</br>

여기서 우선순위 큐란 우선순위의 개념을 큐에 도입한 자료구조 입니다.   
우선순위 큐의 데이터들은 우선순위를 가지고 있고, 순위가 높은 데이터가 먼저 나갑니다.  
우선순위 큐는 여러 방법으로 구현이 가능하지만 이 중 힙(Heap)을 이용하여 구현하는 것이 가장 효율적이기 때문에 주로 힙을 이용합니다.
</br>

힙은 여러 데이터중에서 최대값 또는 최소값을 빠르게 찾아내도록 만들어졌습니다.(**O(logN)**)  
힙은 반정렬 상태(느슨한 정렬 상태)를 유지하기 때문에 큰 값이 상위레벨에, 작은 값이 하위 레벨에 있게 됩니다.  
또한 힙에서는 중복된 값을 허용합니다.
</br>
</br>
</br>

## 힙(Heap)의 종류
- **최대힙**
    * 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진트리.
</br>

- **최소힙**
    * 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진트리.

 ![heap](https://user-images.githubusercontent.com/69297345/105316110-c255eb00-5c03-11eb-98d3-b3af3d9b52c4.png)
</br>
</br>
</br>

## 힙 구현 방법
힙은 완전 이진트리 이기 때문에 차례대로 데이터들이 저장되고, 중간에 비어있는 노드가 없게됩니다.  
따라서 배열을 사용하여 구현하면 저장 및 탐색이 쉽기 때문에 힙을 구현하는 가장 효과적인 방법은 배열을 이용한 방법입니다.  
</br>

또한 구현의 편의성을 위하여 배열의 0번째 인덱스는 사용하지 않고, 바로 1번째 인덱스부터 데이터를 저장합니다.
</br>

원래 배열을 이용하면 크기가 정해져있어서 삽입과 삭제 연산을 할 때 배열이 가득 찼는지, 비었는지 확인해야 합니다.  
하지만 이번에는 자바의 ArrayList를 사용하여 크기가 가변적으로 변할 수 있도록 구현해 보겠습니다.
</br>
</br>

힙에서의 부모노드와 자식노드의 관계는  
왼쪽자식의 인덱스 = **(부모의 인덱스) * 2**  
오른쪽자식의 인덱스 = **(부모의 인덱스) * 2 + 1**  
가 됩니다. 
</br>
</br>
</br>
 
## 1. 최소힙
</br>

### 1.1 최소힙의 삽입
최소힙은 부모 노드의 키값이 자식 노드의 키값보다 작아야 합니다.  
또한 부모 노드의 인덱스를 알면 자식 노드의 인덱스를 알 수 있습니다.
</br>

따라서 최소힙 삽입연산의 순서를 알아보면  
</br>

- 1. 삽입할 데이터를 배열의 마지막 원소로 추가합니다.
- 2. 마지막 인덱스를 이용해 부모노드의 인덱스를 찾습니다.
- 3. 부모 노드와 삽입할 데이터의 키값을 비교하여 부모 노드의 키값이 작은지 확인합니다.
- 4. 위의 과정을 루트 노드를 만날때 까지 반복합니다. (3번을 만족하면 종료)
</br>
</br>

```java
	public void insert(int key) {
		heap.add(key); // 맨 뒤에 추가
		int pos = heap.size() - 1;
		
		
		// 부모의 키값이 자식의 키값보다 작을때까지
		while(pos > 1 && heap.get(parent(pos)) > heap.get(pos)) {
			int tmp = heap.get(parent(pos)); // 부모의 키값을 tmp에 저장
			heap.set(parent(pos), heap.get(pos));
			heap.set(pos, tmp); // 부모와 자식 swap
			
			pos /= 2;
		}
	}
```

</br>
</br>
</br>

### 1.2 최소힙의 삭제
최소힙에서 삭제 연산은 **루트 노드를 삭제**하는 것입니다.  
삭제한 후에도 최소힙의 특성을 만족해야 합니다.  
이 때 사용하는 개념이 **우선순위 큐**입니다.  

</br>

- 1. 루트 노드를 새로운 변수에 저장해 놓습니다.
- 2. 마지막 노드를 루트 노드로 변경합니다.
- 3. 부모 노드의 자식 노드를 비교하며 최소힙의 특성을 만족하도록 합니다.
- 4. 모든 노드가 최소힙의 특성을 만족할 때 까지 위의 과정을 반복합니다.
</br>
</br>

```java
	public int remove() {
		if(heap.size() - 1 < 1) {
			return 0;
			
		}
		
		int remove = heap.get(1); // remove에 루트 노드 저장 (루트노드 삭제)
		heap.set(1,  heap.get(heap.size() - 1)); // 루트 자리에 마지막 노드 삽입
		heap.remove(heap.size() - 1); // 마지막 노드 삭제
		
		int pos = 1;
		while(leftChild(pos) < heap.size() - 1) {
			
			int minPos = leftChild(pos);
			int min = heap.get(minPos);
			
			if((min > heap.get(rightChild(pos))) && (rightChild(pos) < heap.size())) {
				minPos = rightChild(pos); // 오른쪽자식이 더 작으면 minPos에 오른쪽 자식 저장
				min = heap.get(minPos);
			}
			
			if(heap.get(pos) < min) // 부모가 더 작으면
				break; // while문 종료
			else {
				int tmp = heap.get(pos); // 부모와 더 작은 자식 swap
				heap.set(pos, min);
				heap.set(minPos, tmp);
				pos = minPos;
			}
		}
		return remove; // 삭제한 데이터 반환
	}
```

</br>
</br>
</br>

## 2. 최대힙

최대힙은 부모 노드의 키값이 자식 노드의 키값보다 커야합니다.  
따라서 구현할 때 최소힙과 부호를 반대로 해야합니다.
</br>
</br>

### 2.1 최대힙의 삽입
```java
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
```
</br>
</br>
</br>

### 2.2 최대힙의 삭제
```java
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
		return remove; // 삭제한 데이터 반환
	}
```
</br>
</br>
</br>

## 3. 기타 메소드
```java
    // 부모의 인덱스 반환
	public int parent(int pos) {
		return (pos/2);
	}
	
    // 왼쪽 자식의 인덱스 반환
	public int leftChild(int pos) {
		return (2*pos);
	}
	
    // 오른쪽 자식의 인덱스 반환
	public int rightChild(int pos) {
		return (2*pos + 1);
	}
	
    // 출력
	public void print() {
		for(int i=1; i<heap.size(); i++) {
			System.out.print(heap.get(i) + " ");
		}
	}
```
