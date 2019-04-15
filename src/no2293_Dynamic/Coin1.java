package no2293_Dynamic;

import java.util.Scanner;

// 동전1
// n 개의 동전을 사용하여 k의 가치를 나타내고 싶다
// 순서가 다른 경우는 같은 것으로 본다.
//	1<=n<=100, 1<=k<=100000
public class Coin1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n];
		for(int i=0; i<coin.length; i++) {
			coin[i] = sc.nextInt();
		}
		int[] d = new int [k+1];
		d[0] = 1;
		for(int j=0; j<coin.length; j++) {
			for(int i=0; i<d.length; i++) {
				if(i-coin[j]>=0) {
					d[i] += d[i-coin[j]];
				}
			}
		}
		System.out.println(d[k]);
		sc.close();
	}
}
