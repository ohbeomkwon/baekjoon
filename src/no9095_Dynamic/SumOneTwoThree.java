package no9095_Dynamic;

import java.util.Scanner;

//	123 더하기 문제
// 숫자 1, 2, 3 을 이용하여, 주어지는 숫자 n을 만들 수 있는 경우의 수를 구하는 문제
// n은 양수이며 11보다 작다
public class SumOneTwoThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] d = new int[11];	// n이 11 보다 작으므로..
		
		d[0] = 1;
		for(int i=1; i<d.length; i++) {
			for(int num=1; num<4; num++) {
				if(i-num >=0) {
					d[i] = d[i]+d[i-num];
					// 해당 경우는 중복도 모두 수용한 경우
				}
			}
		}
		while(t-->0) {
			int n = sc.nextInt();
			System.out.println(d[n]);
		}
		sc.close();
	}
}
