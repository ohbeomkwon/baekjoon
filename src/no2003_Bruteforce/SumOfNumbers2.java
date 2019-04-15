package no2003_Bruteforce;

import java.util.Scanner;

public class SumOfNumbers2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n+1];
		// 연산의 마지막 부분에서 배열을 넘어가는 것을 방지하기 위해 1칸 더 생성
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		int left =0;
		int right = 0;
		int sum = a[0];
		int ans = 0;
		
		// left right 피봇을 정하고 left가 right를 따라가는 테크닉은
		// 문제에 주어지는 숫자가 양수일 때만 가능하다.
		while(left <= right && right <n) {
			if(sum<m) {
				right++;	// right 값을 증가 시킨 후 
				sum += a[right];	// sum에 값을 더해준다.
			}
			else if(sum==m) {
				ans++;
				right++;
				sum+=a[right];
			}
			else if(sum>m) {
				sum -= a[left];	// left가 가리키던 값을 빼고
				left++;	// left를 오른쪽으로 한칸 옮긴다.
				if(left>right && left < n) {// left가 범위내에 있는데 right를 넘어갈 경우
					right = left;
					sum = a[left];
				}
			}
		}
		System.out.println(ans);
		
		sc.close();
	}
}
