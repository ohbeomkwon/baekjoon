package no14391_BruteForce_bitmask;

import java.util.Scanner;

// 종이조각 문제
// 종이조각을 잘라서 합을 구하였을 때 가장 큰 수가 되도록 만들자
//	1<=세로 N 가로 M <=4, 종이에 적힌 수는 0에서 9까지.
public class ScrapPaper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<m; j++) {
				a[i][j] = s.charAt(j)-'0';
			}
		}
		
		int ans = 0;
		// 0은 가로, 1은 세로
		for(int s=0; s<(1<<(n*m)); s++) {
			int sum =0;
			for(int i=0; i<n; i++) {
				int cur =0;
				for(int j=0; j<m; j++) {
					int k = i*m + j;
					if((s&(1<<k))==0) {
						cur = cur*10 + a[i][j];
					}
					else {
						sum += cur;
						cur = 0;
					}
				}
				sum += cur;
			}
			for(int j=0; j<m; j++) {
				int cur=0;
				for(int i=0; i<n; i++) {
					int k = i*m+j;
					if((s&(1<<k)) !=0) {
						cur = cur*10 + a[i][j];
					}
					else {
						sum += cur;
						cur = 0;
					}
				}
				sum += cur;
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
		
		sc.close();
	}
}
