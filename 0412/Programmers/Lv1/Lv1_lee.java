import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Lv1 {
	// Solution으로 바꾸기
	public static int[] solution(int N, int[] stages) {
		// 전체 스테이지의 개수 N = 1 이상 500 이하의 자연수
		// 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수 - 1 이상 200,000 이하
		// stages에는 1 이상 N + 1 이하의 자연수가 담겨있다
		// 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호
		// 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자

		// 플레이어 수
		int pCnt = stages.length;

		// 스테이지 별 통과한 플레이어 수 
		int[] passCnt = new int[N + 2];
		// 스테이지에 도전중인 플레이어 수
		int[] failCnt = new int[N + 2];
		for (int i = 0; i < pCnt; i++) {
			for (int j = 1; j <= stages[i]; j++) {
				passCnt[j]++;
			}
			failCnt[stages[i]]++;

		}
		// 스테이지 별 실패율 배열
		// 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for (int i = 1; i <= N; i++) {
			// 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의
			if (passCnt[i] == 0)
				map.put(i, 0.0);
			else
				map.put(i, ((double) failCnt[i] / (double) passCnt[i]));
		}
		// Map.Entry 리스트 작성
		List<Entry<Integer, Double>> failRate = new ArrayList<Entry<Integer, Double>>(map.entrySet());
		Collections.sort(failRate, new Comparator<Entry<Integer, Double>>() {
			// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return
			@Override
			public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
				// 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		int[] answer = new int[failRate.size()];
		for (int i = 0; i < failRate.size(); i++) {
			answer[i] = failRate.get(i).getKey();
		}

		return answer;
	}

}
