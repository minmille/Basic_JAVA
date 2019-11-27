package gugudan;

public class GuGuPrint {
	
	public void guGuDan(int dansu) {
		int result; // 변수 선언, 초기화는 하지 않음
		System.out.println("구구단 " + dansu + "단 출력");
		for (int i = 1; i <= 9; i++) {
			result = dansu * i;
			System.out.println(dansu + " x " + i + " = " + result);
		
		}
		
	}

}
