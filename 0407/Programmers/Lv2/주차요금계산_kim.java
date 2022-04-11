import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Queue<String> queue = new LinkedList<>(); // 차량 번호 담을 queue
  		int l = records.length;
		for (int i = 0; i < l; i++) {
			String[] check = records[i].split(" ");
			if (!queue.contains(check[1])) {
				queue.add(check[1]);
			}
		}
        int q = queue.size();
		int[][] fee = new int[q][2]; // 차량번호, 주차시간
		int[] answer = new int[q];
		for (int j = 0; j < q; j++) {
			fee[j][0] = Integer.parseInt(queue.poll());
		}
		for (int i = 0; i < l; i++) {
			if (records[i].charAt(11) == 'I') {
				int where = -1;
				for (int j = i + 1; j < l; j++) {
					if (records[i].substring(6, 10).equals(records[j].substring(6, 10))) {
						where = j;
						break;
					}
				}
				String intime = records[i].substring(0, 6);
				String outtime="";
				if(where == -1) {
					outtime = "23:59";
				}else {
					outtime = records[where].substring(0, 6);
				}
				int min = timemin(intime, outtime);
				for (int k = 0; k < fee.length; k++) {
					if (fee[k][0] == Integer.parseInt(records[i].substring(6, 10))) {
						fee[k][1] += min;
					}
				}

			}
		}

		Arrays.sort(fee, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}		
		});
		
		for(int i = 0; i < fee.length; i++) {
			answer[i] = fee(fees,fee[i][1]);		
		}
		return answer;

	}

	private static int timemin(String intime, String outtime) {
		int inhour = Integer.parseInt(intime.substring(0, 2));
		int inmin = Integer.parseInt(intime.substring(3, 5));
		int outhour = Integer.parseInt(outtime.substring(0, 2));
		int outmin = Integer.parseInt(outtime.substring(3, 5));

		return ((outhour * 60 + outmin) - (inhour * 60 + inmin));
	}

	public static int fee(int[] fees, int min) {
		if (min < fees[0]) {
			return fees[1];  
		} else {
			double cash = Math.ceil((float) (min - fees[0]) / fees[2]) * fees[3] + fees[1];
			return (int) cash;
		}
	}
}
