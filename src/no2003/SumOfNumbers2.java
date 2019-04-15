package no2003;

import java.util.Scanner;

// 수들의 합2
// n개의 수로 된 수열이 있다. 이 수열 i 번째 부터 j 번째 수까지의
//	합이 m이 되는 경우의 수를 구하는 프로그램을 작성하라
// 1≤N≤10,000  1≤M≤300,000,000
// 각 수열의 수는 30000을 넘지 않는다.
public class SumOfNumbers2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum += a[j];
				if(sum==m) {
					ans++;
				}
				if(sum>m) {
					break;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
