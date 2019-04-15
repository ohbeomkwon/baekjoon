package no10942_Dynamic_top_down;

import java.util.Arrays;
import java.util.Scanner;

// 팰린드롬
// recursion을 이용한 top down 방식
public class Palindrome {
	static int[] a;
	static int[][] d;
	public static int go(int x, int y) {
		if(x==y) { // 숫자가 하나일 경우
			return 1;
		}
		else if(x+1 == y) { // 숫자가 두개일 경우
			if(a[x]==a[y]) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		if(d[x][y] != -1) {	// -1이 아니면 연산이 끝난 것이므로 저장된 값을 리턴한다.
			return d[x][y];
		}
		if(a[x] != a[y]) {
			return d[x][y] = 0;
		}
		else {
			return d[x][y] = go(x+1, y-1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n];
		d = new int[n][n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			Arrays.fill(d[i], -1);
		}
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(m-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sb.append(go(x-1,y-1));
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
