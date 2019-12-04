package problem.calc;

import java.util.Scanner;

// 사칙 연산이 가능한 계산기 프로그램
public class CalcMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator calc = new Calculator();

		while (true) {

			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦ 더하고나누고 ver1.0");
			System.out.print("▦ 숫자 >> ");
			int first = sc.nextInt();
			System.out.print("▦ 연산자(+, -, x, /) >> ");
			sc.nextLine(); // 한줄 개행 막음
			String oper = sc.nextLine();
			System.out.print("▦ 숫자 >> ");
			int second = sc.nextInt();

			// System.out.println(first + "," + oper + "," + second); // 작동 테스트용 출력
			int result = 0;
			if (oper.equals("+")) {
				result = calc.sum(first, second);
			} else if (oper.equals("-")) {
				result = calc.sub(first, second);
			} else if (oper.equals("*")) {
				result = calc.multi(first, second);
			} else if (oper.equals("/")) {
				result = calc.div(first, second);
			}

			// 결과 출력
			System.out.println(first + oper + second + "=" + result);
			sc.close();
		}
	}
}
