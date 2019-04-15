package no1748_BruteForce;

import java.util.Scanner;

// 수 이어쓰기
// 1 부터 N까지의 수를 이어쓰면 새로운 수가 나온다.
// 이때 그 수의 자릿수를 구하시오
// 1<= n <100,000,000 (1억이하)
public class NumSubsequentWriting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// n의 제한이 너무 크기 때문에 실제로 숫자를 만들기 어렵다.
		// 자릿수만 계산해보자
		// 1 - 9 => (9-1+1)*1자리
		// 10 - 99 => (99-10+1)*2자리
		// 100-999 => (999-100+1)*3자리 등등..
		
		int n = sc.nextInt();
		long ans = 0;
		// 이렇게 for문을 쓸 수 있는지 처음 앎..
		for(int start=1, len=1; start<=n; start*=10, len++) {
			int end = start*10-1;
			if(end>n) {
				end = n;
			}
			ans += (long)(end-start +1)*len;
		}
		System.out.println(ans);
		sc.close();
	}
}
