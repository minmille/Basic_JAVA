package chapter09;

import java.util.Scanner;

public class Bubble {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i <= 4; i++) {
			System.out.print((i + 1) + "번 : "); 
			arr[i] = sc.nextInt();
		}
		
		//int[] arr = new int[] {7,3,9,4,2};
		int temp = 0;
				
		for (int i = 0; i <= arr.length - 1; i++) {
			for (int j = i + 1; j <= arr.length -1 ; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
							}
			}
		}
		System.out.print("크기로 정렬\n => ");
		for (int i = 0; i <= arr.length -1; i++) {
			System.out.print( + arr[i] + " ");
		}
	}
}
