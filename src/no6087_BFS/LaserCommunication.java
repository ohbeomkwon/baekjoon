package no6087_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LaserCommunication {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		String[] a = new String[n];
		int sx, sy, ex, ey;
		sx=sy=ex=ey=-1;
		//	(sx,sy) 시작점에서 (ex,ey) 도착점까지 가는 문제
		for(int i=0; i<n; i++) {
			a[i] = sc.next();
			for(int j=0; j<m; j++) {
				if(a[i].charAt(j)=='C') {
					if(sx==-1) {	// 시작점이 초기화되지 않았을 때, 시작점을 초기화
						sx = i;
						sy = j;
					}
					else {// 도착점을 초기화
						ex = i;
						ey = j;
					}
				}
			}
		}
		int[][] d = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				d[i][j] = -1;
			}
		}
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(sx,sy));
		d[sx][sy] = 0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.first;
			int y = p.second;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				while(nx>=0 && nx<n && ny>=0 && ny<m) {
				// while 반복문을 이용하여 큐에 한칸씩 추가하지 않고 큐에 직선 전체를 추가한다.	
					if(a[nx].charAt(ny)=='*') break;	// 벽이면 멈춘다.
					if(d[nx][ny]== -1) {
						d[nx][ny] = d[x][y] +1;
						q.add(new Pair(nx,ny));
					}
					nx+=dx[k];
					ny+=dy[k];
				
				}
			}
		}
		System.out.println(d[ex][ey]-1);
		// 도착지점까지 직선의 수를 더한 것에 1을 빼서 거울의 수를 구한다
	}
}
class Pair {
	int first;
	int second;
	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}