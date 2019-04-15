package no11048_Dynamic_bottom_up;

import java.util.Scanner;

public class Move {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] candy = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				candy[i][j] = sc.nextInt();
			}
		}
		int[][] sum = new int[n+1][m+1];

		// Bottom-Up Design
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				sum[i][j] = Math.max(sum[i-1][j-1], Math.max(sum[i-1][j], sum[i][j-1])) + candy[i][j];
//				sum[i][j] = Math.max(sum[i-1][j], sum[i][j-1]) + candy[i][j];
//				원래는 위의 식이 맞으나, candy의 값이 항상 0보다 크기 때문에 대각선으로 움직이는 것보다
//				오른쪽-아래 또는 아래-오른쪽으로 움직이는 것이 항상 크기때문에 대각선을 제외하고 연산할 수 있다.
			}
		}
		System.out.println(sum[n][m]);
		sc.close();
		
	}
}
