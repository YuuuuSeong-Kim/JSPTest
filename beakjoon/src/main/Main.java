package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int re = Integer.parseInt(br.readLine());
			for(int i=0; i<re; i++) {
				StringBuilder sb = new StringBuilder();
				StringTokenizer st = new StringTokenizer(br.readLine());
				int h = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int [][]arr = new int[h][w];
				int count=0;
				for(int k=0; i<w; i++) {
					for(int f=0; f<h; f++) {
						count++;
						arr[f][k] = count;
						if(count==n) {
							sb.append(f+1);
							if(k<10) {
								sb.append("0"+(k+1));
							}else {
								sb.append(k+1);
							}
						}
					}
				}
				System.out.println(sb);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
