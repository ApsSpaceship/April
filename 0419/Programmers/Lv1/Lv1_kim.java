
public class programmers_키패드2 {
	public static class position {
		int r;
		int c;

		public position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static position left, right;
	public static StringBuilder sb;
	public static String same;

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		int[][] num = new int[4][3];
		left = new position(3, 0); // 왼손 엄지의 위치 *
		right = new position(3, 2); // 어른손 엄지의 위치 #

		String hand = "right"; // 손잡이에 따라 둘의 거리가 같을 때 사용할 손가락을 고른다.
		if (hand.charAt(0) == 'r') {
			same = "R";
		} else {
			same = "L";
		}
		int cr = 0;
		sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			switch (numbers[i]) {
			case 1:
			case 4:
			case 7:
				sb.append("L");
				left.r = numbers[i] / 3; 
				left.c = 0;
				break;
			case 3:
			case 6:
			case 9:
				sb.append("R");
				right.r = (numbers[i] / 3) - 1;
				right.c = 0;
				break;
			case 0:
				cr = 3;
				check(cr, 1);
				break;
			case 2:
			case 5:
			case 8:
				cr = numbers[i] / 3;
				check(cr, 1);
				break;
			}

		}
		System.out.println(sb.toString());
	}

	public static void check(int cr, int cc) {
		// 두 엄지의 거리가 같을 때
		if ((Math.abs(right.r - cr) + Math.abs(right.c - cc)) == (Math.abs(left.r - cr) + Math.abs(left.c - cc))) {
			sb.append(same);
			if (same.charAt(0) == 'L') { // 왼손잡이 일 경우 왼쪽엄지의 위치를 변경
				left.c = cc;
				left.r = cr;
			} else { // 오른손잡이 일 경우 오른쪽엄지의 위치 변경
				right.r = cr;
				right.c = cc;
			}
		}// 왼손이 더 가까울 때 
		else if ((Math.abs(right.r - cr) + Math.abs(right.c - cc)) > (Math.abs(left.r - cr)
				+ Math.abs(left.c - cc))) {
			sb.append("L");
			left.r = cr;
			left.c = cc;
		} else { // 오른손이 더 가까울 때
			sb.append("R");
			right.r = cr;
			right.c = cc;
		}
	}

}
