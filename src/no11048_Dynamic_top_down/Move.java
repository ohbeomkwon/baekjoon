package no11048_Dynamic_top_down;

import java.util.Scanner;

public class Move {
	static int[][] candy;
	static int[][] sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		candy = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1;  j<=m; j++) {
				candy[i][j] = sc.nextInt();
			}
		}
		sum = new int[n+1][m+1];
//		sum의 값이 0이 될 수 있으므로. -1로 초기화한다.
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				sum[i][j] = -1;
			}
		}
		int result = go(n,m);
		System.out.println(result);
		sc.close();
	}
	public static int go(int i, int j) {
		if(i<1 || j<1) {	// 최소 인덱스 범위를 제한한다.
			return 0;
		}
		if(sum[i][j]>=0) {	
			// 메모이제이션 되었는지 확인한다.
			// 각 셀을 -1로 초기화 하였으므로 0이상인 경우는 계산이 끝났다고 판단한다.
			return sum[i][j];
		}
		sum[i][j] = Math.max(go(i-1, j), go(i,j-1))+candy[i][j];
		return sum[i][j];
	}
}
