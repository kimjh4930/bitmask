package b_1182;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int S = Integer.parseInt(input[1]);
		
		String str[] = br.readLine().split(" ");
		int values[] = new int[N+1];
		
		for(int i=0; i<N; i++) {
			values[i+1] = Integer.parseInt(str[i]);
		}
		
		int index = 1, sum=0, count=0, times=1, j=1;
		
		times <<= N;
		
		for(int i=1; i<times; i++) {
			sum = 0;
			index = 1;
			j=1;
			
			while(index <= i) {
				if((i & index) == index) {
					sum += values[j];
				}
				index <<= 1;
				j++;
			}
			
			if(sum == S) {
				count++;
			}
		}
		
		System.out.println(count);
		
		br.close();
	}

}
