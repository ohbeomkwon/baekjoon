package no1806_Bruteforce;

import java.util.Scanner;

// 부분합
// 부분합이 s이상이 되는 결과값 중
// 최소길이를 출력하는 문제
public class PartialSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] a = new int[n+1];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int left=0;
		int right=0;
		int sum=a[0];
		int ans=n+1;	// 주어진 모든 값을 더한 것보다 1개 더 긴 길이
		
		while(right<n && left<=right) {
			if(sum<s) {
				right++;
				sum+=a[right];
			}
			else if(sum==s) {
				ans = Math.min(ans, right-left+1);
				right++;
				sum += a[right];
			}
			else if(sum>s) {
				ans = Math.min(ans, right-left+1);
				sum -= a[left];
				left++;
			}
		}
		
		if(ans > n) {// 만족하는 값이 없다는 뜻이므로
			ans = 0;
		}
		System.out.println(ans);
		
		sc.close();
	}
}
