package b_14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static List<Integer> combiList = new ArrayList<>();
	static int[][] map;
	static int N;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		String[] input;
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		combination(0, 0, N, N/2, 0);
		
		int min = 0x7FFFFFFF;
		int homeScore = 0, awayScore = 0;
		int diff = 0;

		for(Integer homeTeam : combiList) {
			
			//home
			homeScore = getTotalScore(homeTeam);
			//away
			awayScore = getTotalScore(~homeTeam);
			
			diff = Math.abs(homeScore - awayScore);
			min = Math.min(min, diff);
		}
		
		System.out.println(min);
		
		br.close();
	}
	
	static void combination(int combi, int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			combiList.add(combi);
			return;
		}
		
		if(index == n) {
			return;
		}
		
//		combi |= (1<<index);
		combination(combi | (1<<index), arrSize+1, n, r, index+1);
//		combi ^= (1<<index);
		combination(combi, arrSize, n, r, index+1);
	}
	
	static int getTotalScore (int team) {
		int score = 0;
		
		int a, b;
		
		for(int i=0; i<N; i++) {
			
			a = (1<<i);
			
			if((team & a) != a) {
				continue;
			}
			
			for(int j=i+1; j<N; j++) {
				b = (1<<j);
				
				if(i != j && ((team & b) == b)) {
					score += map[i][j] + map[j][i];
				}
			}
		}
		
		return score;
	}
}
