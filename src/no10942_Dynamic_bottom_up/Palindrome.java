package no10942_Dynamic_bottom_up;

import java.util.Scanner;

// 팰린드롬 문제
// 문자열이 대칭적으로 같은지를 보는 문제
public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		// 각 두개의 인덱스가 펠런드롬인지 판단한다.
		// 두개의 인덱스를 저장하기 위해 2차원 배열을 사용한다.
		boolean[][] d = new boolean[n][n];
		for(int i=0; i<n; i++) {
			d[i][i] = true;
			// 홀수일 때 혹은 숫자가 1개일 때
		}
		for(int i=0; i<n-1; i++	) {
			if(a[i] == a[i+1]) {
				d[i][i+1] = true;
				// 숫자가 두개일 때, 두 수가 같으면  true
			}
		}
		for(int k=2; k<n; k++) {
			for(int i=0; i<n-k; i++) {
				int j = i+k;
				if(a[i] == a[j] && d[i+1][j-1]) {
					d[i][j] = true;
				}
			}
		}
		// 모든 경우에 대한 팰린드롬 분석 완료
		
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(m-->0) {
			int s = sc.nextInt();	// start
			int e = sc.nextInt();	// end
			if(d[s-1][e-1]) {	// 인덱스이므로 하나씩 뺌
				sb.append(1);
				// 팰린드롬이면 1 출력
			}
			else {
				sb.append(0);
				// 팰린드롬이 아니면 0 출력
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
