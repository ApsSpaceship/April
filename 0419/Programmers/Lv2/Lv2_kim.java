
public class programmers_문자열압축 {
	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
		int ans = s.length();
		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 1; // 반복횟수 체크
			String plus = ""; // 마지막에 남는 문자열 
			String check = s.substring(0, i); // 비교대상
			for (int j = i; j <= s.length(); j += i) {
				String compare = "";
				if (j + i > s.length()) {
					plus = s.substring(j, s.length()); // j+i가 s의 길이보다 크다면 마지막에 남는 문자열!
				} else {
					compare = s.substring(j, j + i);
				}
				if (check.equals(compare)) {
					count++; // 같다면 반복횟수 ++
				} else if (count == 1) { // 같지 않은데 카운트도 1이면
					sb.append(check); //비교대상 더해주고
					check = compare; // 다음 문자로 바꿈
				}else {
					sb.append(count).append(check);
					check = compare;
					count = 1; // 압축횟수는 초기화 해준다.
				}
			}
			sb.append(plus);
			ans = Math.min(ans, sb.length());
		}
		System.out.println(ans);
	}

}
