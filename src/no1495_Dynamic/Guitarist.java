package no1495_Dynamic;

import java.util.Scanner;

// 기타리스트 문제
//	1 ≤ N ≤ 100, 1 ≤ M ≤ 1000, 0 ≤ S ≤ M
public class Guitarist {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();	// 곡의 갯수
		int s = sc.nextInt(); // 시작 볼륨
		int m = sc.nextInt(); // 최대 볼륨
		int[] v = new int [n+1];
		for(int i=1; i<=n; i++) {
			v[i] = sc.nextInt();
		}
		
		boolean[][] d = new boolean[n+1][m+1];
//		최대볼륨이 정해져있으므로 그 볼륨 내에서 연주할 수 있는 값들을 조사한 뒤
//		마지막 곡을 연주할 때의 가장 큰 값을 찾는다.
//		d[i][j] 에서 i 는 곡의 순서, j 는 볼륨의 크기로 본다
		d[0][s] = true;
		for(int i=0; i<=n-1; i++) {
			for(int j=0; j<=m; j++) {
				if(d[i][j] == false) continue;
				if(j-v[i+1]>=0) {
					d[i+1][j-v[i+1]] = true;
				}
				if(j+v[i+1]<=m) {
					d[i+1][j+v[i+1]] = true;
				}
			}
		}
		int ans = -1;		// 답이 0일 수 있기 때문에..
		for(int j=0; j<=m; j++) {
			if(d[n][j]) {
				ans = j;	// true가 출력되는 가장 큰 j가 답으로 들어간다
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
