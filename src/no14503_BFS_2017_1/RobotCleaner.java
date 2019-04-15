package no14503_BFS_2017_1;

import java.util.Scanner;

// 로봇청소기 문제
public class RobotCleaner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 세로크기
		int M = sc.nextInt();	// 가로크기
		//	(3<= N,M <=50)
		int r = sc.nextInt();		// 청소기의 세로좌표
		int c = sc.nextInt();		// 청소기의 가로좌표
		int d = sc.nextInt();		// 청소기의 방향
		// 북쪽이면 0, 동쪽이면 1, 남쪽이면 2, 서쪽이면 3
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		// 문제요건 입력 종료
		
		
		int cnt = 0;	//	청소기가 움직인 횟수
		int count=0;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		//	북동남서의 순서로 x와 y가 한쌍의 인덱스 값을 가진다.
		
		while(true) {
			if(map[r][c]==0) {	// 청소하지 않은 방이면?
				map[r][c] = 2;		// 청소 했다고 표시한다
				count++;
			}
			if(map[r+1][c] !=0 && map[r][c+1] !=0 && map[r-1][c] !=0 && map[r-1][c] !=0) {
				// 청소기의 상하좌우가 모두 청소를 했거나 벽이면?
				if(map[r-dx[d]][c-dy[d]] == 1) { 
					// 청소기가 보고있는 반대방향(뒷방향)이 벽이면?
					//	반대방향을 보기 때문에 - 를 수행해준다.
					break;		// 청소를 종료한다.
				}
				else {
					r = r-dx[d];
					c = c-dy[d];
					// 청소기의 위치를 한칸 뒤로 이동한다
				}
			}
			else {
				d = (d+3)%4;	// 왼쪽으로 한칸 회전은 오른쪽으로 3칸 회전과 동일하다고 볼 수 있다.
				if(map[r+dx[d]][c+dy[d]] == 0) { // 청소기가 바라본 방향이 청소하지 않은 바닥이면?
					r+=dx[d];
					c+=dy[d];
					//	 청소기를 이동시킨다.
				}
			}
		}
		// 청소기의 이동이 모두 끝났다.
		
		//	청소기의 이동이 모두 끝난 후 방 전체를 탐색한다.
		for(int i=0; i<N; i++ ) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2 ) {
					cnt++;
				}
			}
		}
		System.out.println("청소 후 재 검색 : "+cnt);
		System.out.println("청소 중 검색 : "+ count);
		
	}
}
