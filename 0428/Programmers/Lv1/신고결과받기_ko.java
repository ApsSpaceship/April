import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public int[] solution(String[] id_list, String[] report, int k) {
    Map<String, Set<String>> map = new HashMap<>(); // key : 신고 당한 사람, value : 신고한 사람
    Map<String, Integer> idxMap = new HashMap<>(); // 사람의 id_list 위치
    int idLen = id_list.length;
    int reLen = report.length;
    int[] answer = new int[idLen];

    for (int i = 0; i < idLen; i++) { // 초기화
        map.put(id_list[i], new HashSet<>());
        idxMap.put(id_list[i], i);
    }
    for (int i = 0; i < reLen; i++) { // 신고 저장
        String[] now = report[i].split(" ");
        map.get(now[1]).add(now[0]);
    }
    for (int i = 0; i < idLen; i++) {
        int size = map.get(id_list[i]).size();
        if (size >= k) { // 신고 횟수 k 이상이면
            Object[] now = map.get(id_list[i]).toArray();
            for (Object o : now) // 신고자들 신고 성공 횟수 증가
                answer[idxMap.get(o.toString())]++;
        }
    }

    return answer;
}