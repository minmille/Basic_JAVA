package chapter04;

import java.util.Scanner;

public class IfElse02 {
	public static void main(String[] args) {
		// 학점 계산 프로그램
		Scanner sc = new Scanner(System.in);

		int score = 0;
		// 파트1 : 학생 점수 입력 받는 부분
		while (true) {
			System.out.print("학생점수 >> ");
			score = sc.nextInt();

			if (score > 100 || score < 0) {
				System.out.println("0 ~ 100 : 다시 입력");
			} else {
				break; // 0~100 들어온 경우 반복문 빠져나감
			}

		}
		// A+: 100~96 / A: 95~90
		// B+: 89~86 / B: 85~80
		// C+: 79~76 / C: 75~70
		// D+: 69~66 / D: 65~60
		// 60점 미만 F 등급
		// 파트2 : 학점 등급 매기는 부분
		// 중첩 if 사용 할 것

		String grade = ""; // 학점 등급
		if (score >= 90 && score <= 100) {
			if(score >= 96) {
				grade = "A+";
			} else {
				grade = "A";
			}
		} else if (score >= 80 && score < 89) {
			if(score >= 86) {
				grade = "B+";
			} else {
				grade = "B";
			}
		} else if (score >= 70 && score < 79) {
			if(score >= 76) {
				grade = "C+";
			} else {
				grade = "C";
			}
		} else if (score >= 60 && score <= 69) {
			if(score >= 66) {
				grade = "D+";
			} else {
				grade = "D";
			}
		} else if (score < 60 && score >= 0) {
			grade = "F";
		}
		System.out.printf("당신은 %s 학점입니다.", grade);
		// System.out.println("0 ~ 100 사이의 값을 입력해 주세요");
	}

}
