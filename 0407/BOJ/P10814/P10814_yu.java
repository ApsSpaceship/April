import java.util.Arrays;
import java.util.Scanner;

public class bj_10814_나이순정렬 {
	
	static class user implements Comparable<user>{
		
		int age;
		String name;
		
		public user(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(user o) {
			
			if(this.age > o.age)
			return 1;
			
			if(this.age == o.age) {
				return 0;
			}
			
			return -1;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 몇명인지
		
		user[] u = new user[T];
		
		for(int i=0; i<T; i++) {
			
			u[i] = new user(sc.nextInt(), sc.next());
		}
		
		Arrays.sort(u);
		
		for(int i = 0; i<T; i++) {
			System.out.println(u[i].age+" "+u[i].name);
		}
	}

}
