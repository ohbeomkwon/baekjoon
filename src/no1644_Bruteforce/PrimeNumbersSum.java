package no1644_Bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 소수의 합
// 수가 주어질 때 이 수를 연속된 소수의 합으로 표현할 수 있는 경우의 수를 구하여라
public class PrimeNumbersSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] c = new boolean[n+1];
		
		List<Integer> p = new ArrayList<>();
		for(int i=2; i<=n; i++) {
			if(!c[i]) {	// 처음에 2는 소수가 아니므로 들어간다..
				p.add(i);
				for(int j=i*2; j<=n; j+=i) {	// 계속해서 수를 더해주면 그 수만큼 약수가 되므로, 소수의 조건을 충족하지 않는다.
					c[j] = true;
				}
			}
		}
		
		int left =0; 
		int right=0;
		int sum = p.size() == 0? 0 : p.get(0);
		// 소수리스트의 크기가 0이면 0을 리턴
		// 크기가 있으면 첫번째 값을 리턴
		int ans =0;
		
		while(left<=right && right < p.size()) {
//		앞에서 풀어보았던 부분합(1806)에서의 식을 간소화 시킴 
			if(sum <= n) {
				if(sum==n) {
					ans++;
				}
				right++;
				if(right<p.size()) {
					sum += p.get(right);
				}
			}
			else {
				sum -= p.get(left--);
			}
		}
		System.out.println(ans);
		
		sc.close();
	}
}
