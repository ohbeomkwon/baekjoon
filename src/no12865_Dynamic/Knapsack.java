package no12865_Dynamic;

import java.util.Scanner;

// 평범한 배낭
// 제한된 무게에 최대의 가치를 담는 문제

public class Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 물건의 수
		int k = sc.nextInt();	// 준서가 버틸 수 있는 무게
		int[] w = new int[n+1]; // 물건들의 무게
		int[] v = new int[n+1]; // 물건들의 가치
		for(int i=1; i<=n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int[][] d = new int[n+1][k+1];
		//d[i][j] = i번째 물건까지 고려했을 때 배낭에 넣은 무게의 합이 j일 때 가치의 최대값
		// i 가 물건번호. j 가 배낭의 무게.  d[i][j]가 배낭의 총 가치
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				d[i][j] = d[i-1][j];		// 물건을 넣지 않은 경우
				if (j - w[i] >= 0) {
					d[i][j] = Math.max(d[i][j], d[i - 1][j - w[i]] + v[i]);
				}
			}
		}
		System.out.println(d[n][k]);
		sc.close();
	}
}
