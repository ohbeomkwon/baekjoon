package no5557_Dynamic;

import java.util.Scanner;
// 1학년
// n개의 숫자가 주어짐(3<= n <=100)
// 각 수는 0 이상 9 이하임
// 중간에 만들어지는 수가 음수가 될 수 없음
// 0부터 20까지의 수만 알고있음
// 각 수 사이에 + - 를 넣어서 
// 제일 마지막 수와 그 전 수 사이에 = 을 넣을 때 등식이 성립하게 식을 만들 것
public class JuniorGrade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		// i개의 수를 이용하여 j를 나타내는 경우의 수
		// n개의 수를 이용하고, 최대 20까지 나타낼 수 있다.
		int[][] d = new int [n+1][21];
		// D[i][j] = D[i-1][j-A[i]] 인 경우와 
		//				  D[i-1][j+A[i]] 인 경우로 나타낼 수 있다.
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=20; j++) {
				if(j-a[i] >=0) {
					d[i][j] = d[i-1][j-a[i]] +1;
				}
				if(j+a[i] <= 20) {
					d[i][j] = d[i-1][j+a[i]] +1;
				}
			}
		}
		System.out.println(d[n-1][a[n]]);
		sc.close();
	}
}
