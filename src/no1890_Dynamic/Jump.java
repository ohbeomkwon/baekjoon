package no1890_Dynamic;

import java.util.Scanner;

public class Jump {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		long[][] result = new long[n][n];
		// 이동하는 경우의 수의 합을 나타낸다.
		result[0][0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j]==0) continue;	// 마지막에 도착했으므로 끝
				// (i, j) -> (i, j+board[i][j]) 로 이동한다.
				if(j+board[i][j] <n) {	// 밖으로 나가지 않는다면..
					result[i][j+board[i][j]] = result[i][j+board[i][j]] + result[i][j];
				}
				// (i, j) -> (i+board[i][j], j) 로 이동한다.
				if(i+board[i][j]<n) {
					result[i+board[i][j]][j] = result[i+board[i][j]][j] + result[i][j]; 
				}
			}
		}
		System.out.println(result[n-1][n-1]);
	}
}
