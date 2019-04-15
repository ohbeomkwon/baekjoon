package no11058_Dynamic;

import java.util.Scanner;

// 크리보드
// 4개의 키를 가지고 있는 키보드를 이용하여 키를 n번 눌러서
// A의 갯수를 최대로 출력
// 1. A를 출력
// 2. 화면 복사
// 3. 화면 버퍼에 저장
// 4. 화면에 붙여넣기 (단, 버퍼가 비어있지 않아야 함)
// 1<= n <=100
public class KriiiBoard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] d = new int [n+1];	// 출력되는 A의 갯수
		
		for(int i=1; i<d.length; i++) {
			d[i] = d[i-1] + 1; 
			for(int j=1; j<i-3; j++) {
				int cur = d[i-j-2] * (j+1);
				if(cur > d[i]) {
					d[i] = cur;
				}
			}
		}
		System.out.println(d[n]);
		sc.close();
	}
}
