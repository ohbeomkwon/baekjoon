package no2294_Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 동전2
// n 개의 동전을 이용하여 k원을 나타내고 싶다.
// 사용한 동전의 갯수가 최소가 되도록!!
// 불가능한 경우 -1을 출력
//	1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000
public class Coin2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n];
		for(int i=0; i<coin.length; i++) {
			coin[i] = sc.nextInt();
		}
		int[] d = new int [k+1];
		Arrays.fill(d, -1);
		d[0] = 0;
		
		for(int j=0; j<coin.length; j++) {
			for(int i=0; i<d.length; i++) {
				if(i-coin[j]>=0 && d[i-coin[j]] != -1) {
//				이전 조합횟수가 -1이라는 것은 조합된 적이 없다는 뜻이므로 불가능
					if(d[i]==-1 || d[i] >d[i-coin[j]]+1) {
//					현재 조합된 적이 없거나, 동전 하나를 더 추가한 것 보다 많은 동전을 사용하였다면.
						d[i] = d[i-coin[j]] + 1;
						// 얼마가 되었든, 코인이 하나 추가되었음을 나타냄
					}
				}
			}
		}
		System.out.println(d[k]);
		sc.close();
	}
}
