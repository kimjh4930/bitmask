package b_11811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int value = 0;
		String[] input;
		StringBuffer result = new StringBuffer();
		
		for(int i=0; i<N; i++) {
			value = 0;
			input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				value |= Integer.parseInt(input[j]);
			}
			result.append(value + " ");
		}
		
		System.out.println(result.toString());
		br.close();
	}
}