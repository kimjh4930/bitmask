package b_11723;

import java.util.Scanner;

public class Main {
	
 	static int checker = 0;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int N = Integer.parseInt(scan.nextLine());
		
		String[] oper;
		
		StringBuffer result = new StringBuffer();
		for(int i=0; i<N; i++) {
			
			oper = scan.nextLine().split(" ");
			
			switch(oper[0]) {
			case "add" :
				add(Integer.parseInt(oper[1])-1);
				break;
			case "remove" :
				remove(Integer.parseInt(oper[1])-1);
				break;
			case "check" :
				result.append(check(Integer.parseInt(oper[1])-1));
				result.append("\n");
				break;
			case "toggle" :
				toggle(Integer.parseInt(oper[1])-1);
				break;
			case "all" :
				all();
				break;
			case "empty" :
				empty();
				break;
			}
			
		}
		
		System.out.println(result.toString());
		
		scan.close();
	}
	
	static void add (int num) {
		checker |= (1<<num);
	}
	
	static void remove (int num) {
		if((checker & (1<<num)) == (1<<num)) {
			checker ^= (1<<num);
		}
	}
	
	static int check (int num) {
		if((checker & (1<<num)) == (1<<num)) {
			return 1;
		}
		return 0;
	}
	
	static void toggle (int num) {
		checker ^= (1<<num);
	}
	
	static void all () {
		checker = 0x000FFFFF;
	}
	
	static void empty() {
		checker = 0x0;
	}

}
