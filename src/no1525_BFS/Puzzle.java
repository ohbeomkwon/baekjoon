package no1525_BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 퍼즐

// 3x3의 퍼즐에 1부터 8까지의 수와 빈칸이 하나 있다.
// 이 숫자들을 이동시켜서 순서대로 퍼즐을 맞추었을 때,
// 최소의 이동횟수를 구하여라

public class Puzzle {
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	// 동서남북으로 방향 지정
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=3;
		int start = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 2차원 배열에 넣는 것이아니라, 한줄로 긴 문자열로 문제를 해결할 것이라서 입력을 받는 부분이 다르다
				int temp = sc.nextInt();
				if(temp==0) {
					temp = 9;
				}
				start = start*10+temp;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> d = new HashMap<>();
		d.put(start, 0);
		q.add(start);
		while(!q.isEmpty()) {
			int now_num = q.remove();
			String now = Integer.toString(now_num);
			int z = now.indexOf('9');
			int x = z/3;
			int y = z%3;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny <n) {
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(x*3+y);
					next.setCharAt(x*3+y, next.charAt(nx*3+ny));;
					next.setCharAt(nx*3+ny, temp);
					int num = Integer.parseInt(next.toString());
					if(!d.containsKey(num)) {
						d.put(num, d.get(now_num)+1);
						q.add(num);
					}
				}
			}
		}
		if(d.containsKey(123456789)) {
			System.out.println(d.get(123456789));
		}
		else {
			System.out.println("-1");
		}
	}
}
