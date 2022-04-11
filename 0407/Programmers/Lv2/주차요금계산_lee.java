import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
	public static class ParkInfo {
		String carId;
		int inH;
		int inM;
		int min;

		public ParkInfo(String carId, int inH, int inM, int min) {
			this.carId = carId;
			this.inH = inH;
			this.inM = inM;
			this.min = min;
		}

		public ParkInfo(String carId, int inH, int inM) {
			this.carId = carId;
			this.inH = inH;
			this.inM = inM;
		}

		public void setMin(int min) {
			this.min = min;
		}
	}
    // 주차한 차량
	static Queue<ParkInfo> parkList;
    // 요금을 정산해야 하는 차량 리스트
	static ArrayList<ParkInfo> feeList;

	public static int[] solution(int[] fees, String[] records) {
		parkList = new LinkedList<>();
		feeList = new ArrayList<>();
		// records : 시각 차량번호 내역
		for (int r = 0; r < records.length; r++) {
			String[] record = records[r].split(" ");
			// 차량 입출차 구분
			if (record[2].equals("IN")) {
				// 입차 시간 분리
				String[] time = record[0].split(":");
				int inH = Integer.parseInt(time[0]);
				int inM = Integer.parseInt(time[1]);
				// 차량 입력
				parkList.add(new ParkInfo(record[1], inH, inM));
			} else {
				// 입력된 차량 찾기
				ParkInfo pInfo;
				while (true) {
					if (!(parkList.peek().carId.equals(record[1]))) {
						parkList.add(parkList.poll());
					} else {
						pInfo = parkList.poll();
						break;
					}
				}
				String[] time = record[0].split(":");
				int outH = Integer.parseInt(time[0]);
				int outM = Integer.parseInt(time[1]);
				// 시간 계산
				int min = calcMin(pInfo.inH, pInfo.inM, outH, outM);
				updateFeeList(pInfo, min);
			}
		}
		// parkList가 비워지지 않았으면 출차 시간을 23:59으로 시간 계산
		while (!parkList.isEmpty()) {
			if (parkList.isEmpty())
				break;
			ParkInfo pInfo = parkList.poll();
			// 시간 계산
			int min = calcMin(pInfo.inH, pInfo.inM, 23, 59);
			updateFeeList(pInfo, min);
		}
		// 차량번호로 오름차순 정렬
		Collections.sort(feeList, new Comparator<ParkInfo>() {
			@Override
			public int compare(ParkInfo p1, ParkInfo p2) {
				return (Integer.parseInt(p1.carId) - Integer.parseInt(p2.carId));
			}
		});
		// 요금 계산 및 정답 배열 생성
		int[] answer = new int[feeList.size()];
		for (int p = 0; p < feeList.size(); p++) {
			answer[p] = calcFee(fees, feeList.get(p).min);
		}
		return answer;
	}

	// 이미 출차 목록에 있는지 확인하여 요금 정산 리스트 갱신
	public static void updateFeeList(ParkInfo pInfo, int min) {
		int idx = -1;
		for (int i = 0; i < feeList.size(); i++) {
			if (feeList.get(i).carId.equals(pInfo.carId)) {
				idx = i;
			}
		}
		if (idx >= 0) {
			pInfo = feeList.get(idx);
			pInfo.setMin(pInfo.min + min);
			feeList.set(idx, pInfo);
		} else {
			feeList.add(new ParkInfo(pInfo.carId, pInfo.inH, pInfo.inM, min));
		}
	}

	// 시간 계산
	public static int calcMin(int inH, int inM, int outH, int outM) {
		int min = 0;
		// 입출차 시간 동일 -> 분만 계산
		// 입출차 시간 다름 -> 분 크기 비교 들어온 시간이 더 작거나 같으면 출차 분 - 입차 분
		// -> 크면 출차 시간 -1, (출차분+60) - 입차 분
		// -> 시간 계산은 (출차 시 - 입차 시) * 60
		if (inH == outH) {
			min = outM - inM;
		} else {
			if (inM <= outM) {
				min += outM - inM;
			} else {
				min += outM + 60 - inM;
				--outH;
			}
			min += (outH - inH) * 60;
		}
		return min;
	}

	// 요금 계산
	public static int calcFee(int[] fees, int min) {
		// fees 0 : 기본시간 (분) 1 : 기본요금(원) 2: 단위시간(분) 3: 단위요금(원)
		// 기본시간 이하 -> 기본요금
		// 분-기본시간 % 단위시간 != 0 -> +1
		// 기본시간 초과 -> 기본요금 + ((분 - 기본시간)/단위시간) * 단위요금
		int fee = fees[1];
		int cnt = 0;
		if (min > fees[0]) {
			if ((min - fees[0]) % fees[2] != 0) {
				++cnt;
			}
			fee += ((min - fees[0]) / fees[2] + cnt) * fees[3];
		}
		return fee;
	}
}
