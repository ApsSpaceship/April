public class PRO_1차_비밀지도 {

	public static void main(String[] args) {
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] binary = solution(5, arr1, arr2);
		for(int i =0; i<5; i++)
			System.out.println(binary[i]);
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		String[][] binary = new String[2][n]; //2진수 배열

		for (int j = 0; j < n; j++) { //2진수로 만들어주기
			binary[0][j] = Integer.toBinaryString(arr1[j]);
		}
		for (int j = 0; j < n; j++) {
			binary[1][j] = Integer.toBinaryString(arr2[j]);
		}

		for (int i = 0; i < n; i++) {
			char c1 = '0';
			char c2 = '0';
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (n <= binary[0][i].length() + j) //만약 길이가 부족하다면 앞이 0이고 길이가 맞다면 뽑아내기
					c1 = binary[0][i].charAt(j + binary[0][i].length()- n);
				if (n <= binary[1][i].length() + j)
					c2 = binary[1][i].charAt(j + binary[1][i].length() - n);
				if (c1 == '1' || c2 == '1') //둘 중 하나라도 1이면 #
					sb.append("#");
				else
					sb.append(" ");
			}
			answer[i] = sb.toString(); //만든 스트링 넣어주기
		}

		return answer;
	}

}
