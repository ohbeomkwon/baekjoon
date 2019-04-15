package no10422_Dynamic_two_dimension;

import java.util.Scanner;

public class Bracket {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 올바른 괄호 문자열이 아니라 그냥 괄호문자열을 나타낸다.
		long[][] d = new long[5001][5001];
		// D[N][O] = 길이가 N인 괄호문자열, 짝이 맞지 않는 괄호의 개수 O개
		// 길이가 L인 올바른 괄호문자열은 D[L][0]이 된다.
		long mod = 1000000007L;
		d[0][0] = 1;
		for(int i=1; i<= 5000; i++) {
			for(int j=0; j<=i; j++) {
				d[i][j] = 0;
				if(j+1<=i) {
					d[i][j] += d[i-1][j+1];
				}
				if(j-1 >= 0) {
					d[i][j] += d[i-1][j-1];
				}
				d[i][j] %= mod;
			}
		}
		
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			System.out.println(d[n][0]);
		}
		sc.close();
	}
}
