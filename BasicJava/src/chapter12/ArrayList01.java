package chapter12;

// Array는 아래 형식
// int[] array = new int[5];
// array[0]=3

import java.util.ArrayList;

public class ArrayList01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("복숭아"); // 값 입력
		list.add("수박"); // 값 입력
		list.add("딸기"); // 값 입력
		//복숭아와 수박 사이에 다른 값을 넣고 넣으면
		list.add(1,"망고"); // (index,value)
		// 복숭아,망고,수박,딸기로 출력 망고를 1번지에 넣고 뒤의 값들은 한칸씩 밀림
		// 3번지의 값을 수정
		list.set(3, "오렌지");// 딸기가 오렌지로 바뀜.
		list.remove(3); // 값을 지우고 뒤에 값이 앞으로 다시 옴
		
		//출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));

			// Array는 length지만 ArrayList는 size() 사용
			// CRUD add등록, set수정, remove삭제, get조회
			// get(),remove(),set() 은 반드시 indext 값 필요
			// add()와 get()만 주로 쓴다.
			
			}
		
		// 향상된 for문 (for each문) => 전체를 출력할 때만 쓸 수 있음
		// list에 있는 값을 한칸씩 꺼내서 담음
		for(String val : list) {
			System.out.println(val);
		}
		
	}
}
