package assignment.triconsumerlambda;

import java.util.Arrays;

public class MainClass {
	public static void main(String []args) {
		TriConsumer<Integer,Integer,Integer> compare=(a,b,c)->{
			if(a>b && a>c) {
				System.out.println(a+" is the greatest");
			}
			else if(b>c && b>a) {
				System.out.println(b+" is the greatest");
			}
			else {
				System.out.println(c+" is the greatest");
			}
		};
		
		MainClass mainClass=new MainClass();
		mainClass.compareUsingTriConsumer(3, 1, 2, compare);
		
		
		TriConsumer <String,String,String> sort=(a,b,c)->{
			String []sarr= {a,b,c};
			sarr=Arrays.stream(sarr).sorted().toArray(String[]::new);
			System.out.println(Arrays.toString(sarr));
		};
		
		mainClass.sortUsingTriConsumer("Hello", "World", "Everyone", sort);
		
	}
	
	void compareUsingTriConsumer(int a,int b,int c,TriConsumer<Integer,Integer,Integer> compare) {
		compare.accept(a, b, c);
	}
	
	void sortUsingTriConsumer(String a,String b,String c,TriConsumer<String,String,String> sort) {
		sort.accept(a, b, c);
	}
}
