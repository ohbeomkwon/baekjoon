package no8111_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 0과 1 문제
//	<<문제>>
//	0과 1로만 이루어져 있어야 한다.
//	1이 적어도 하나 있어야 한다.
//	수의 길이가 100 이하이다.
//	수가 0으로 시작하지 않는다.
// 자연수 N이 주어졌을 때, N의 배수 중에서 위 조건에 만족하는 수를 구하라
public class ZeroAndOne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] from = new int[n];	// 어디서 왔는지
			int[] how = new int[n];	// 어떻게? 왔는지
			int[] dist = new int[n];	// 길이는?
			for(int i=0; i<n; i++) {
				from[i] = how[i] = dist[i] = -1;
			}
			
			Queue<Integer> q = new LinkedList<>();
			// n의 배수를 구하는 것이기 때문에 모듈러 연산을 이용하여 n의 배수인지 확인한다.
			// 제일 작은 수에서부터 계속해서 붙여나가면서 수를 완성하므로,
			// 수가 만들어질 때마다 모듈러 연산을 한 후에 붙여준다.
			q.add(1%n);
			dist[1%n] = 0;
			how[1%n] = 1;
			while(!q.isEmpty()) {
				int now = q.remove();
				for(int i=0; i<=1; i++) {
					int next = (now*10+i)%n;
					if(dist[next]==-1) {
						dist[next] = dist[now]+1;
						from[next] = now;
						how[next] = i;
						q.add(next);
					}
				}
			}
			if(dist[0]==-1) {
				System.out.println("BRAK");
			}
			else {
				StringBuilder ans = new StringBuilder();
				for(int i=0; i!=-1; i=from[i]) {
					ans.append(Integer.toString(how[i]));
				}
				System.out.println(ans.reverse());
			}
		}
	}
}
