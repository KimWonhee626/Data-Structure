# 연결리스트
### - 동적 메모리에 할당된, 링크에 의해 연결된 유한 개수의 데이터원소 노드들
#
- 1. 단일 연결 리스트(singly linked lists)
- 2. 이중 연결 리스트(doubly linked lists)
- 3. 원형 연결 리스트(circularly linked lists)
- 4. 헤더 및 트레일러 연결 리스트(linked lists with header and trailer)


</br>
</br>
</br>


# 노드(node)란?
### - 한 개의 데이터원소를 저장하기 위해 동적메모리에 할당된 메모리.
- getnode() : 노드를 할당하고 그 노드의 주소를 반환.(동적 메모리가 고갈된 시점이면 널포인터 반환)
- putnoed(i) : 주소 i의 노드에 할당되었던 메모리의 사용을 해제하고 이를 동적메모리에 반환.(* 메모리 재활용 가능 *)
<<<<<<< HEAD


</br>
</br>


## 1. 단일 연결 리스트(singly linked lists)
### - 연속 노드로 구성된 가장 단순한 연결 데이터 구조.
- 원소(element)
- 링크(link) : 다음 노드의 주소. 다음 노드가 없는 경우 null 저장.
- 접근점 : 첫 노드. 즉, 헤드노드(head node)의 주소.


</br>
</br>


## 2. 이중 연결 리스트(doubly linked lists)
- 원소(element)
- 링크1(link) : 다음 노드의 주소.
- 링크2(link) : 이전 노드의 주소.
- 접근점 : 헤드노드(head node), 테일노드(tail node)


</br>
</br>


## 3. 원형 연결 리스트(circularly linked lists)
- 마지막 노드의 링크가 헤드노드의 주소.
- 접근점 : 헤드노드(head node)의 주소.


</br>
</br>

## 4. 헤더와 트레일러
- 헤드(head)노드 바로 앞에 *헤더(header)* 노드를 추가하여 작업 편의성을 증진.
- 같은 목적으로 테일(tail)노드 바로 뒤에 *트레일러(tailer)* 노드를 추가.
- 저장 내용 : dummy element
- 접근점 : 헤더노드, 트레일러노드




