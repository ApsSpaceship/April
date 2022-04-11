import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P10814 {
	static class User {
		int age;
		String name;

		public User(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	static User[] user;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		user = new User[N];
		for (int i = 0; i < N; i++) {
			user[i] = new User(sc.nextInt(), sc.next());
		}
		Arrays.sort(user, new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				return u1.age - u2.age;
			}

		});
		for (int i = 0; i < N; i++) {
			System.out.println(user[i].age + " " + user[i].name);
		}

	}
}
