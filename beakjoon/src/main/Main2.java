package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
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
				if(n%h==0) {
					sb.append(h).append("0").append(n/h).append("\n");
				}else {
					sb.append(n%h);
					if(n/h<10) {
						sb.append("0");
					}
					sb.append(n/h+1).append("\n");
				}
				System.out.print(sb);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
