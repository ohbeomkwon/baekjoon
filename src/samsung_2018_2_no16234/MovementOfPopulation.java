package samsung_2018_2_no16234;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MovementOfPopulation {
	static int n, l, r;
	static int[][] cell;
	static boolean[][] check;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<HashSet<Pair>> setList = new LinkedList<>();
	static Queue<Integer> ave = new LinkedList<>();

	public static void bfs(int i, int j) {
		HashSet<Pair> pairSet = new HashSet<>();
		Queue<Pair> q = new LinkedList<>();
		int sum=0;
		int cnt = 0;
		q.add(new Pair(i, j));

		while (!q.isEmpty()) {
			Pair p = q.remove();
			pairSet.add(p);
			int x = p.x;
			int y = p.y;
			sum += cell[x][y];
			cnt++;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || check[nx][ny] == true)
					continue;
				int c = cell[x][y] - cell[nx][ny];
				c = (int) Math.sqrt(c * c);
				if (c >= l && c <= r) {
					q.add(new Pair(nx, ny));
					check[nx][ny] = true;
				}
			}
		}
		setList.add(pairSet);
		ave.add(sum/cnt);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		cell = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cell[i][j] = sc.nextInt();
			}
		}
		int ans=0;
		check = new boolean[n][n];
		while (true) {
			int visit = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j] == false) {
						check[i][j] = true;
						bfs(i, j);
						visit++;
					}
				}
			}
			
			while(!setList.isEmpty() ) {
				int average = ave.remove();
				for(HashSet<Pair> s : setList) {
					for(Pair p : s) {
						cell[p.x][p.y] = average;
					}
				}
			}
			ans++;
			if (visit == n * n)
				ans--;
				break;
		}
		System.out.println(ans);
		sc.close();
	}
}

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}