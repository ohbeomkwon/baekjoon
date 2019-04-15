package no11066_Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class FileCombine {
	static int[] a;
	static int[][] d;	// 결과값 저장
	
	public static int go(int i, int j) {
		if(i==j) {
			return 0;
		}
		if(d[i][j] != -1) {	// 입력된 값이 있으면.
			return d[i][j];
		}
		int ans = -1;
		int sum = 0;
		for(int k=i; k<j; k++) {
			sum += a[k];
		}
		for(int k=i; k<j; k++) {
			int temp = go(i,k) + go(k+1, j) + sum;
			if(ans == -1 || ans > temp) {
				ans = temp;
			}
		}
		d[i][j] = ans;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			a = new int[n+1];
			d = new int[n+1][n+1];
			for(int i=1; i<a.length; i++) {
				a[i] = sc.nextInt();
				Arrays.fill(d[i], -1);
			}
			int result = go(1, n);
			System.out.println(result);
		}
		sc.close();
	}
}
