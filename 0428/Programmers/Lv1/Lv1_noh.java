import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = {};
		answer = new int[id_list.length];

		// key : 이름, value : 인덱스
		Map<String, Integer> nameToIndex = new HashMap<String, Integer>();
		for (int i = 0; i < id_list.length; ++i)
			nameToIndex.put(id_list[i], i);

		// key : 신고받은 사람, value : 신고한 사람들의 리스트
		Map<String, Set<String>> reportPeopleList = new HashMap<String, Set<String>>();

		for (int i = 0; i < report.length; ++i) {
			String reportPerson = report[i].substring(0, report[i].indexOf(" "));
			String reportedPerson = report[i].substring(report[i].indexOf(" ") + 1, report[i].length());

			if (reportPeopleList.get(reportedPerson) == null) {
				reportPeopleList.put(reportedPerson, new HashSet<String>());
			}
			reportPeopleList.get(reportedPerson).add(reportPerson);
		}

		for (String key : reportPeopleList.keySet()) {
			Set<String> set = reportPeopleList.get(key);
			if (set.size() >= k)
				for (String name : set)
					++answer[nameToIndex.get(name)];
		}

		return answer;
	}
}
