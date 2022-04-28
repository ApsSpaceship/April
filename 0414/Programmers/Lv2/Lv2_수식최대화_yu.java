
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class lv2_수식최대화 {

	static String[] cal;
	static List<String> list, copy;
	static int N;
	static long ans;

	public static void main(String[] args) {

		String expression = "50*6-3*2";

		// 여러분 이건 70점짜리니까 잘 찾아보세요^^ 제가 잘 설명하세요^^ 

		String[] sep = expression.split("");

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < sep.length; i++) {
			if (sep[i].equals("+") || sep[i].equals("*") || sep[i].equals("-")) {
				set.add(sep[i]);
			}
		}

		Iterator<String> calcu = set.iterator();

		N = set.size();
		cal = new String[N]; // 연산자ㅂㅐ열

		for (int i = 0; i < cal.length; i++) {
			cal[i] = calcu.next();
		}

		String num = "";

		list = new ArrayList<>();
		copy = new ArrayList<>();

		for (int i = 0; i < sep.length; i++) {

			if (sep[i].equals("+") || sep[i].equals("*") || sep[i].equals("-")) {
				list.add(num);
				list.add(sep[i]);
				num = "";
			} else {
				num += sep[i];
			}

		}

		list.add(num);
		
		for(int i=0; i<list.size(); i++) {
			copy.add(list.get(i));
		}
		

		//
		ans = 0;
		permutation(0);

		System.out.println(ans);

	}// main

	static void swap(int a, int b) {

		String temp = cal[a];
		cal[a] = cal[b];
		cal[b] = temp;
	}

	static void permutation(int idx) {

		if (idx == N) {
			long sum = 0;
			list.clear();
			for(int i=0; i<copy.size(); i++) {
				list.add(copy.get(i));
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < list.size(); j++) {
					
					if (cal[i].equals(list.get(j))) {
						long a = Long.parseLong((list.get(j - 1)));
						long b = Long.parseLong((list.get(j + 1)));

						if (cal[i].equals("*")) {
							a *= b;
						} else if (cal[i].equals("+")) {
							a += b;
						} else {
							a -= b;
						}

					
						list.set(j - 1, Long.toString(a));
						list.remove(j);
						list.remove(j);
						j--;
					}
				}
			}
			sum = Math.abs(Long.parseLong(list.get(0)));
		
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = idx; i < N; i++) {
			swap(i, idx);
			permutation(idx + 1);
			swap(i, idx);
		}
	}

}
