package problem;

public class TotalSum {
	public static void main(String[] args) {

		// 1 ~ 100 까지 수 중에 짝수, 홀수만 더해서 출력하세요.
		// 시작값 : 1
		// 종료값 : 100
		// 짝수 누적합 : even
		// 홀수 누적합 : ㅐㅇㅇ
		
		int odd = 0;
		int even = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) { // 짝수
				even += i;
			} else { // 홀수
				odd += i;
			}
		}
		System.out.println("1 ~ 100까지 숫자 중 짝수의 총합은 " + even);
		System.out.println("1 ~ 100까지 숫자 중 홀수의 총합은 " + odd);
	}
}
