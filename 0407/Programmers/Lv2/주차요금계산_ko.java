import java.util.Arrays;
import java.util.HashMap;

public class PRO_2차_주차요금 {
	static class Car {
		int startTime; // 들어온 시간
		int time; // 총 주차한 시간
		int id; // 차 번호
		boolean in; // 지금 주차장에 있는지

		public Car() {
		}
	}

	public static void main(String[] args) {
		int[] fees = { 120, 0, 60, 591 };
		String[] records = { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN" };
		System.out.println(Arrays.toString(solution(fees, records)));

	}

	public static int[] solution(int[] fees, String[] records) {
		int size = records.length; // 행 개수
		HashMap<Integer, Car> map = new HashMap<>(size); // 키는 차 번호
		for (int i = 0; i < size; i++) {
			if (records[i].substring(11).length() == 2) { // IN이면
				Car car = new Car();
				car.startTime = Time(records[i].substring(0, 5)); // 들어온 시간
				car.id = Integer.parseInt(records[i].substring(6, 10)); // 차 번호
				car.in = true; // 들어왔당
				if (map.containsKey(car.id)) { // 이전에 들어온 적 있으면
					car.time = map.get(car.id).time; // 이전 총 시간
				}
				map.put(car.id, car);
			} else { // OUT이면
				Car car = map.get(Integer.parseInt(records[i].substring(6, 10))); // 해당 차 데려오기
				car.in = false; // 나갔엉
				car.time += Time(records[i].substring(0, 5)) - car.startTime; // 총 시간에 이번 시간 - 들어온 시간 더해주기
				map.put(car.id, car);
			}
		}

		// 정렬
		Integer[] mapkey = map.keySet().toArray(new Integer[map.size()]); // key만 어레이로
		Arrays.sort(mapkey); // 정렬
		int[] answer = new int[map.size()];// 자동차 수 만큼
		int finishTime = Time("23:59"); // 나간 시간 없는 차 위해서 미리 계산해둠
		int idx = 0; // answer배열 인덱스
		for (Integer nKey : mapkey) { // 정렬된 key
			Car car = map.get(nKey);
			if (car.in) { // 지금 주차돼 있으면
				car.time += finishTime - car.startTime; // 총 시간에 23:59 - 들어온 시간 더해주기
			}
			answer[idx++] = Cost(fees, car.time); // 주차요금 답에 저장
		}

		return answer;

	}

	static int Time(String str) { // 시간 스트링 -> 분
		int time = (str.charAt(0) - '0') * 600;
		time += (str.charAt(1) - '0') * 60;
		time += (str.charAt(3) - '0') * 10;
		time += (str.charAt(4) - '0');
		return time;
	}

	static int Cost(int[] fees, int time) { // 주차요금 계산
		int cost = fees[1];
		time -= fees[0];
		if (time > 0) {
			cost += (time / fees[2]) * fees[3];
			if (time % fees[2] > 0)
				cost += fees[3];
		}

		return cost;
	}
}
