class Solution {
    public int solution(String dartResult) {

		int[] score = new int[3];

		String[] dart = dartResult.split("");

		int num = 0;
		int idx = 0;

		for (int i = 0; i < dart.length; i++) {

			switch (dart[i]) {
			case "S":
				score[idx] = num;
				idx++;
				break;
			case "D":
				score[idx] = (int) Math.pow(num, 2);
				idx++;
				break;
			case "T":
				score[idx] = (int) Math.pow(num, 3);
				idx++;
				break;
			case "*":
				if (idx - 2 >= 0) {
					score[idx - 2] *= 2;
				}
				score[idx - 1] *= 2;
				break;
			case "#":
				score[idx - 1] *= -1;
				break;
            default:
				if (dart[i].equals("1") && dart[i + 1].equals("0")) {
                    i++;
                    num=10;
					
				}else {

					num = Integer.parseInt(dart[i]);
				}
				break;
			}// switch

		} // for

        int answer = 0;
        for (int i = 0; i < 3; i++) {

			answer += score[i];
		}
        return answer;
    }
}
