package queue;

public class ArrayQueue {
	/* 큐(Queue)는 줄(line) 이라는 의미를 가지고 있다.
	 * 데이터의 제거는 대기 줄의 가장 '앞'에서 수행되며 
	 * 데이터의 삽입은 대기 줄의 가장 '뒤'에서 수행이 되는 제한된 리스트 구조
	 * 선입선출(FIFO - First In First Out) 형태의 자료구조
	 * 
	 * + 가장 오래전에 입력된 데이터는 front
	 * + 가장 최근에 입력된 데이터를 rear
	 * 데이터의 삽입은 rear에서 이루어지고 
	 * 삭제는 front에서 이루어지기 때문에 
	 * 큐를 구현하기 위해서는 front와 rear를 관리하는 배열을 이용하거나, 
	 * front 노드와 rear 노드를 관리하는 연결 리스트를 이용할 수 있다.
	 * */
	
    // 큐 배열은 front와 rear 그리고 maxSize를 가진다.
    private int front;
    private int rear;
    private int maxSize;
    private Object[] queueArray;

    // 큐 배열 생성
    public ArrayQueue(int maxSize){
        this.front = -1;
        this.rear = -1;
        this.maxSize = maxSize;
        this.queueArray = new Object[maxSize];  // Object 배열
    }
	
    // 큐가 비어있는지 확인
    public boolean isEmpty(){
        return (front == rear);
    }
	
    // 큐가 꽉 찼는지 확인
    public boolean isFull(){
        return (rear == maxSize - 1);
    }

    public void enqueue(Object item) {
    	System.out.println("===========큐에 Enqueue 시도!=====================");
		// rear에서 삽입. 데이터가 삽입 될 때 하나 증가시킨 후 새로운 데이터를 삽입
        if(isFull()) {
        	System.out.println("큐가 꽉 차서 Enqueue할 수 없습니다.");
        	return;
        } else {
        	queueArray[++rear] = item;
        	System.out.println("큐에 " + item + "를 넣었습니다!");
        }
	}
	
	public Object dequeue() {
		// front에서 발생.
		// front가 가리키고 있는 데이터를 꺼낸 후 front 값을 하나 증가.
		// front 값이 rear를 추월하게 되면 더이상 제거할 데이터가 없는 상태 즉, 자료가 하나도 없는 빈 큐임을 의미.
		if (isEmpty()) { 
			return null;
		} else {
			return queueArray[++front];
		}
	}
	
	public Object peek() {
		// 큐에서 front가 가리키는 데이터를 읽는 작업
		// 데이터를 제거하지 않고 읽는 작업만 수행하므로 front 값을 변경시키지 않는다.
        if(isEmpty()) {
        	System.out.println("큐가 비어있습니다.");
        	return null;
        } else {
        	return queueArray[front + 1];
        }
	}
	// rear값 반환
	public int returnRear() {
		return rear;
	}
	
	// front값 반환
	public int returnFront() {
		return front;
	}
	
	// maxsize값 반환
	public int returnMaxsize() {
		return maxSize;
	}
	// 배열을 이용하여 큐를 구현할 때의 단점
	// 1. 그 크기가 고정되었다는 점 
	// 2. 데이터의 삽입과 삭제가 반복 될 수록 
	//    rear와 front가 계속 증가되므로 이미 꺼낸 데이터가 들어있던 배열의 인덱스를 다시 활용할 수 없다는 점
	// 3. 데이터가 다 차있지 않더라도 rear와 front가 계속 증가되다보면 
	//    언젠가는 배열의 사이즈까지 도달하여 더이상 사용할 수 없게 된다는 점
}
