package no16235_treeInvestment;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MyCode {
	static int[] dr = {-1,-1,-1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0,-1,-1};
	static int N, M, K;
	static int[][] A;
	static Queue<Tree> q;
	static PriorityQueue<Tree> pq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();		// 땅의 크기 NxN
		M = sc.nextInt();		// 구매한 나무의 갯수
		K = sc.nextInt();		// K년 후..
		A = new int[N+1][N+1];	// 각 칸의 영양분의 양
//		q = new LinkedList<>();
//		for(int i=0; i<M; i++) {
//			q.add(new Tree(sc.nextInt(), sc.nextInt(), sc.nextInt()));
//		}
		pq = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			pq.add(new Tree(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		bfs(0);
		
		sc.close();
	}
	
	public static void bfs(int years) {
		if(years==K) {
			return;
		}
		
		while(!pq.isEmpty()) {
			Tree tree = pq.poll();
			int i = tree.i;
			int j = tree.j;
			int age = tree.age;
			
			int ground = A[i][j];
			
			// 봄
			
			// 여름
			
			// 가을
			
			// 겨울
			
		}
		
	}
	
}
class Tree implements Comparable<Tree>{
	int i, j, age;
	public Tree(int i, int j, int age) {
		this.i = i;
		this.j = j;
		this.age = age;
	}
	@Override
	public int compareTo(Tree tree) {
		if(this.age<= tree.age) {
			return -1;
		}
		return 1;
	}
}