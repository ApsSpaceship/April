import java.util.ArrayList;
import java.util.List;

public class PRO_lv3_양과늑대 {
    static int shMax = 0;
	static int infoSize;
	static List<Integer>[] nodes;

	public static int solution(int[] info, int[][] edges) {
		infoSize = info.length; // 노드 수
		nodes = new List[infoSize];
		for (int i = 0; i < infoSize; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < infoSize - 1; i++) { // 부모리스트에 자식 저장
			nodes[edges[i][0]].add(edges[i][1]);
		}

		find(0, 0, 0, nodes[0], info);

		return shMax;
	}

	public static void find(int now, int sheep, int wolf, List<Integer> arr, int[] info) {
		if (info[now] == 0) // 매번 세어서 최댓값 비교
			sheep++;
		else
			wolf++;
		shMax = Math.max(sheep, shMax);

		if (sheep <= wolf) // 늑대가 크앙
			return;

		if (sheep + wolf == infoSize) // 다 센 경우
			return;

		int size = arr.size(); // 갈 수 있는 애들 만큼
		for (int i = 0; i < size; i++) {
			List<Integer> nArr = new ArrayList<Integer>();
			int arrBaby = arr.get(i); // 이번에 가려는 노드
			nArr.addAll(arr); // 나 제외 갈 수 있는 애들 다 추가
			nArr.remove(i);
			nArr.addAll(nodes[arrBaby]); // 이번에 가려는 노드의 자식 노드들 추가
			find(arrBaby, sheep, wolf, nArr, info);
		}

	}

}