import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class lv1_신고결과받기 {
	public static void main(String[] args) {

		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;

		int[] answer = new int[id_list.length];

		HashMap<String, Integer> index = new HashMap<>();

		for (int i = 0; i < id_list.length; i++) {
			index.put(id_list[i], i);
		}

		int[] blacklist = new int[id_list.length]; // 이름 불린 횟수 카운팅

		HashSet<String> dupli = new HashSet<>();

		for (int i = 0; i < report.length; i++) {
			dupli.add(report[i]);
		} // 중복제거

		Iterator<String> iter = dupli.iterator();

		if (dupli.size() == 0) {
			// return answer;
			//System.out.println(Arrays.toString(answer));
		} else {

			String[][] arr = new String[dupli.size()][2];

			for (int i = 0; i < dupli.size(); i++) {
				
				String[] temp = iter.next().split(" ");
				arr[i][0] = temp[0];
				arr[i][1] = temp[1];

				blacklist[index.get(temp[1])]++;
			}

			for (int i = 0; i < blacklist.length; i++) {
				if (blacklist[i] >= k) { // 정지!

					for (int j = 0; j < dupli.size(); j++) {
						if (arr[j][1].equals(id_list[i])) {// 정지대상 찾으면
							answer[index.get(arr[j][0])]++;
						}
					}
				}
			}

			//System.out.println(Arrays.toString(answer));
			// return answer;

		}

	}

}

