package queue;

import java.util.Scanner;

public class View {
	
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== 몇개의 공간을 가진 큐를 만들까요? ==========");
		int qsize = sc.nextInt();
		sc.nextLine();
		ArrayQueue arrayQueue = new ArrayQueue(qsize);
		while (true) {
			System.out.println("========== 큐에 할 행동을 고르세요 ==========");
			System.out.println("1. 큐에 데이터 삽입(Enqueue)");
			System.out.println("2. 큐의 데이터 삭제(Dequeue)");
			System.out.println("3. 데이터 확인(Peek)");
			System.out.println("4. 큐가 꽉찼는지 확인");
			System.out.println("5. 큐가 비었는지 확인");
			System.out.println("6. 큐의 front 값은?");
			System.out.println("7. 큐의 rear 값은? ");
			System.out.println("8. 종료 ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 : 
				System.out.println("큐에 넣을 데이터를 입력하세요.");
				String input = sc.nextLine();
				System.out.println(input);
				arrayQueue.enqueue(input);
				break;
			case 2 : 
				Object dequeuedItem = arrayQueue.dequeue(); 
				if(dequeuedItem == null) {
					System.out.println("삭제실패");
				} else {
					System.out.println(dequeuedItem + "가 삭제되었습니다.");
				}
				break;
			case 3 : 
				Object peekedItem = arrayQueue.peek();
				if(peekedItem != null) System.out.println("front에 " + peekedItem + "가 있습니다");
				break;
			case 4 : 
				System.out.println(arrayQueue.isFull());
				break;
			case 5 : 
				System.out.println(arrayQueue.isEmpty());
				break;
			case 6 :
				System.out.println("큐의 front 값은 " + arrayQueue.returnFront() + "입니다");
				break;
			case 7 :
				System.out.println("큐의 rear 값은 " + arrayQueue.returnRear() + "입니다");
				break;
			case 8 : 
				System.out.println("Bye-");
				return;
			}
		}
	}
}
