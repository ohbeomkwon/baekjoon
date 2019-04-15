package no15989_Dynamic;

import java.util.Scanner;

// 123더하기 4
// n의 크기가 1000이하인 양수이다.
public class SumOneTwoThree4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] d = new int[10001];
		d[0] = 1;
		// 풀이법은 그냥 123더하기와 동일하나 순서만 다른 경우를 하나로 친다는 점에 유의
		// 1에 대한 경우를 다 계산하고 2에대한 경우를 다 계산하고 3에대한 경우를 다 계산하는 방법으로 진행
		for(int num=1; num<4; num++) {
			for(int i=1; i<d.length; i++) {
//		이중 for문의 순서만 바꿔도 중복되는 경우를 제거할 수 있다.
				if(i-num>=0) {
					d[i] += d[i-num];
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
