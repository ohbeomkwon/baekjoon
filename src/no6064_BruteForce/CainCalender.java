package no6064_BruteForce;

import java.util.Scanner;

// 카잉 달력

public class CainCalender {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			// x와 y에 대해서 1씩 빼주어서 나머지연산과 맞아떨어지게 맞춰준다.
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			int ans = -1;
			// x를 고정하고 y에 대한 값만 비교하자
			// x가 같은 가장 작은 값 k가 있을 때..
			// k는 연산 할 때마다 x만큼 커진다. 그래야 같은 나머지 값을 유지할 수 있다.
			for(int k=x; k<(m*n); k+=m) {
				if(k%n==y) {
					ans = k+1;// 처음에 x, y를 1씩 뺏으니 값을 구할 때 1을 더한다.
					break; // 작은 수를 구하기위해 값이 구해지면 탈출
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
