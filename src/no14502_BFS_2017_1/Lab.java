package no14502_BFS_2017_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 연구소 문제

// 항상 3개의 벽을 세워야 한다
// 바이러스가 퍼지지 않는 안전영역의 최댓값을 구하라

 
public class Lab {
	static int n, m;
	static int[][] a = new int[10][10];
	static int[][] b = new int[10][10];
	// 행렬을 최대 크기로 초기화 해 놓는다.
	static int ans;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};//	동서남북의 순서;
	
	static void bfs() {	// 바이러스가 퍼지는 것을 계산
		Queue<Pair> q = new LinkedList<>();
		// 입출력의 편의를 위해서 좌표 객체를 생성한다.
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				b[i][j] = a[i][j];
				if(b[i][j]==2) {
					q.add(new Pair(i,j));
					// 최초 오염지를 찾아서 입력한다.
				}
			}
		}
		while(!q.isEmpty()) {	// 바이러스가 퍼지는 걸 구현
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {// 4방향에 퍼짐
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {// nx, ny가 주어진 범위 내에 있을 때
					if(b[nx][ny]==0) {
						b[nx][ny]=2;
						q.add(new Pair(nx,ny));
						// 바이러스 오염 후 큐에 입력한다.
					}
				}
			}
		}
		int cnt =0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(b[i][j]==0) {// 오렴되지 않았으면
					cnt++;
				}
			}
		}
		if(ans<cnt) {
			ans = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		// 세로의 크기
		m = sc.nextInt();		// 가로의 크기
		//	3<=N,M <=8
		a = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		//	BFS 경우의 수가 많지 않으므로 모든 경우의 수를 해본다
		// 세개의 벽을 칠 경우를 계산
		for(int x1=0; x1<n; x1++) {
			for(int y1=0; y1<m; y1++) {
				if(a[x1][y1] !=0) continue;	
				// 0이 아니고 벽(1)이나 바이러스(2)이면 다시 탐색
				for(int x2=0; x2<n; x2++) {
					for(int y2=0; y2<m; y2++) {
						if(a[x2][y2] !=0) continue;
						for(int x3=0; x3<n; x3++) {
							for(int y3=0; y3<m; y3++) {
								if(a[x3][y3] !=0) continue;
								
								if(x1==x2 && y1==y2) continue;
								if(x2==x3 && y2==y3) continue;
								if(x3==x1 && y3==y1) continue;
								// 세 벽이 겹치면 다시 탐색
								
								a[x1][y1]=1;
								a[x2][y2]=1;
								a[x3][y3]=1;
								// 세 벽을 세움
								
								bfs(); // 빈 공간을 세어봄
								
								a[x1][y1]=0;
								a[x2][y2]=0;
								a[x3][y3]=0;
								// 원상 복귀 시킴
							}
						}
					}
				}
			}
		}
		// 모든 경우의 값을 다 계산해본다.
		System.out.println(ans);
		// 결과값 출력
	}
}
class Pair {	// 좌표를 객체로 생성
	// 객체를 생성하지 않으면 추가하거나 뺄 때 마다 두개씩 추가제거 해야한다.
	int x;
	int y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
