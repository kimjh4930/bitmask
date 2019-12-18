package b_11811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int value = 0;
		int[] inputnum = new int[N];
		String[] input;
		
		StringBuffer result = new StringBuffer();
		
		for(int i=0; i<N; i++) {
			value = 0;
			
			input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				inputnum[j] = Integer.parseInt(input[j]);
			}
			
			for(int j=0; j<N; j++) {
				value |= inputnum[j];  
			}
			
			result.append(value + " ");
			
		}
		
		System.out.println(result.toString());
		
		br.close();
	}
}