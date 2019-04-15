package samsung_2018_2_no5373;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 오전 1번 큐브 맞추는 문제

//	4
//	1
//	L-
//	2
//	F+ B+
//	4
//	U- D- L+ R+
//	10
//	L- U- L+ U- L- U- U- L+ U+ U+

//	입력값 중 4번째 케이스에서 틀림..


public class Cubing {
	static char[][] up;
	static char[][] down;
	static char[][] left;
	static char[][] right;
	static char[][] front;
	static char[][] back;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			up = new char[][] {{'w','w','w'},{'w','w','w'},{'w','w','w'}};
			down = new char[][] {{'y','y','y'},{'y','y','y'},{'y','y','y'}};
			left = new char[][] {{'g','g','g'},{'g','g','g'},{'g','g','g'}};
			right = new char[][] {{'b','b','b'},{'b','b','b'},{'b','b','b'}};
			front = new char[][] {{'r','r','r'},{'r','r','r'},{'r','r','r'}};
			back = new char[][] {{'o','o','o'},{'o','o','o'},{'o','o','o'}};
			
			int n = sc.nextInt();
			sc.nextLine();
			for(int i=0; i<n; i++) {
				String input = sc.next();
				if(input.equals("U+")) {
					turnRight(up);
					upRight();
				}
				else if(input.equals("U-")) {
					turnLeft(up);
					upLeft();
				}
				else if(input.equals("D+")) {
					turnRight(down);
					downRight();
				}
				else if(input.equals("D-")) {
					turnLeft(down);
					downLeft();
				}
				else if(input.equals("F+")) {
					turnRight(front);
					frontRight();
				}
				else if(input.equals("F-")) {
					turnLeft(front);
					frontLeft();
				}
				else if(input.equals("B+")) {
					turnRight(back);
					backRight();
				}
				else if(input.equals("B-")) {
					turnLeft(back);
					backLeft();
				}
				else if(input.equals("L+")) {
					turnRight(left);
					leftRight();
				}
				else if(input.equals("L-")) {
					turnLeft(left);
					leftLeft();
				}
				else if(input.equals("R+")) {
					turnRight(right);
					rightRight();
				}
				else if(input.equals("R-")) {
					turnLeft(right);
					rightLeft();
				}
			}
			
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					sb.append(up[i][j]);
				}
				sb.append('\n');
			}
			
		}
		
		System.out.println(sb.toString());
		sc.close();
	}

	public static void turnRight(char[][] face) {
		char[][] clone = new char[3][3];
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				q.add(up[i][j]);
			}
		}
		for (int j = 2; j >= 0; j--) {
			for (int i = 0; i < 3; i++) {
				clone[i][j] = q.remove();
			}
		}
		face = clone;
	}

	public static void turnLeft(char[][] face) {
		char[][] clone = new char[3][3];
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				q.add(up[i][j]);
			}
		}
		for (int j = 0; j < 3; j++) {
			for (int i = 2; i >= 0; i--) {
				clone[i][j] = q.remove();
			}
		}
		face = clone;
	}

	public static void upRight() {
		char[] temp = { back[2][0], back[2][1], back[2][2] };
		back[2][2] = left[0][2];
		back[2][1] = left[1][2];
		back[2][0] = left[2][2];
		left[0][2] = front[0][0];
		left[1][2] = front[0][1];
		left[2][2] = front[0][2];
		front[0][0] = right[2][0];
		front[0][1] = right[1][0];
		front[0][2] = right[0][0];
		right[2][0] = temp[2];
		right[1][0] = temp[1];
		right[0][0] = temp[0];
	}
	public static void upLeft() {
		char[] temp = { back[2][0], back[2][1], back[2][2] };
		back[2][0] = right[0][0];
		back[2][1] = right[1][0];
		back[2][2] = right[2][0];
		right[0][0] = front[0][2];
		right[1][0] = front[0][1];
		right[2][0] = front[0][0];
		front[0][2] = left[2][2];
		front[0][1] = left[1][2];
		front[0][0] = left[0][2];
		left[2][2] = temp[0];
		left[1][2] = temp[1];
		left[0][2] = temp[2];
	}

	public static void downRight() {
		char[] temp = { back[0][2], back[0][1], back[0][0] };
		back[0][0] = right[0][2];
		back[0][1] = right[1][2];
		back[0][2] = right[2][2];
		right[0][2] = front[2][2];
		right[1][2] = front[2][1];
		right[2][2] = front[2][0];
		front[2][2] = left[2][0];
		front[2][1] = left[1][0];
		front[2][0] = left[0][0];
		left[2][0] = temp[2];
		left[1][0] = temp[1];
		left[0][0] = temp[0];
	}
	public static void downLeft() {
		char[] temp = { back[0][2], back[0][1], back[0][0] };
		back[0][2] = left[0][0];
		back[0][1] = left[1][0];
		back[0][0] = left[2][0];
		left[0][0] = front[2][0];
		left[1][0] = front[2][1];
		left[2][0] = front[2][0];
		front[2][0] = right[2][2];
		front[2][1] = right[1][2];
		front[2][2] = right[0][2];
		right[2][2] = temp[0];
		right[1][2] = temp[1];
		right[0][2] = temp[2];
	}
	
	public static void frontRight() {
		char[] temp = {up[2][0], up[2][1], up[2][2]};
		up[2][0] = left[2][0];
		up[2][1] = left[2][1];
		up[2][2] = left[2][2];
		left[2][2] = down[2][2];
		left[2][1] = down[2][1];
		left[2][0] = down[2][0];
		down[2][2] = right[2][2];
		down[2][1] = right[2][1];
		down[2][0] = right[2][0];
		right[2][2] = temp[2];
		right[2][1] = temp[1];
		right[2][0] = temp[0];
	}
	public static void frontLeft() {
		char[] temp = {up[2][0], up[2][1], up[2][2]};
		up[2][0] = right[2][0];
		up[2][1] = right[2][1];
		up[2][2] = right[2][2];
		right[2][0] = down[2][0];
		right[2][1] = down[2][1];
		right[2][2] = down[2][2];
		down[2][0] = left[2][0];
		down[2][1] = left[2][1];
		down[2][2] = left[2][2];
		left[2][0] = temp[0];
		left[2][1] = temp[1];
		left[2][2] = temp[2];
	}
	
	public static void backRight() {
		char[] temp = {down[0][2], down[0][1], down[0][0]};
		down[0][0] = left[0][0];
		down[0][1] = left[0][1];
		down[0][2] = left[0][2];
		left[0][0] = up[0][0];
		left[0][1] = up[0][1];
		left[0][2] = up[0][2];
		up[0][0] = right[0][0];
		up[0][1] = right[0][1];
		up[0][2] = right[0][2];
		right[0][0] = temp[2];
		right[0][1] = temp[1];
		right[0][2] = temp[0];
	}
	public static void backLeft() {
		char[] temp = {down[0][2], down[0][1], down[0][0]};
		down[0][2] = right[0][2];
		down[0][1] = right[0][1];
		down[0][0] = right[0][0];
		right[0][2] = up[0][2];
		right[0][1] = up[0][1];
		right[0][0] = up[0][0];
		up[0][2] = left[0][2];
		up[0][1] = left[0][1];
		up[0][0] = left[0][0];
		left[0][2] = temp[0];
		left[0][1] = temp[1];
		left[0][0] = temp[2];
	}
	
	public static void leftRight() {
		char[] temp = {back[0][0], back[1][0], back[2][0]};
		back[2][0] = down[0][2];
		back[1][0] = down[1][2];
		back[0][0] = down[2][2];
		down[0][2] = front[2][0];
		down[1][2] = front[1][0];
		down[2][2] = front[0][0];
		front[2][0] = up[2][0];
		front[1][0] = up[1][0];
		front[0][0] = up[0][0];
		up[2][0] = temp[2];
		up[1][0] = temp[1];
		up[0][0] = temp[0];
	}
	public static void leftLeft() {
		char[] temp = {back[0][0], back[1][0], back[2][0]};
		back[0][0] = up[0][0];
		back[1][0] = up[1][0];
		back[2][0] = up[2][0];
		up[0][0] = front[0][0];
		up[1][0] = front[1][0];
		up[2][0] = front[2][0];
		front[0][0] = down[2][2];
		front[1][0] = down[1][2];
		front[2][0] = down[0][2];
		down[2][2] = temp[0];
		down[1][2] = temp[1];
		down[0][2] = temp[2];
	}
	
	public static void rightRight() {
		char[] temp = {back[2][2], back[1][2], back[0][2]};
		back[0][2] = up[0][2];
		back[1][2] = up[1][2];
		back[2][2] = up[2][2];
		up[0][2] = front[0][2];
		up[1][2] = front[1][2];
		up[2][2] = front[2][2];
		front[0][2] = down[2][0];
		front[1][2] = down[1][0];
		front[2][2] = down[0][0];
		down[2][0] = temp[2];
		down[1][0] = temp[1];
		down[0][0] = temp[0];
	}
	public static void rightLeft() {
		char[] temp = {back[2][2], back[1][2], back[0][2]};
		back[2][2] = down[0][0];
		back[1][2] = down[1][0];
		back[0][2] = down[2][0];
		down[0][0] = front[2][2];
		down[1][0] = front[1][2];
		down[2][2] = front[0][2];
		front[2][2] = up[2][2];
		front[1][2] = up[1][2];
		front[0][2] = up[0][2];
		up[2][2] = temp[0];
		up[1][2] = temp[1];
		up[0][2] = temp[2];
	}

}
