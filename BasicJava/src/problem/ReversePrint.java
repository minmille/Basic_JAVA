package problem;

import java.util.Scanner;

public class ReversePrint {
	/*
	 * 조건 1. 사용자가 임의의 정수를 입력 
	 * 2. 사용자가 입력한 정수를 1부터 끝까지 출력 
	 * 출력 예제 
	 * 입력 >> 5
	 *  1
	 *  2 
	 *  3 
	 *  4 
	 *  5
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력 >> ");
		int max = sc.nextInt();
		for(int i = 1; i <= max; i++) {
			System.out.println(i);
		}

		// 입력한 숫자 역순
		
		//System.out.printf("숫자를 입력 >> %d", max);
		for(int i = max; i >= 1; i--) {
			System.out.println(i);
		}
		
	}

}
