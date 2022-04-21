package study0421;

public class programmers_숫자문자열 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String s = "23four5six7";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int n = c - '0';
			if (n >= 0 && n <= 9) {
				sb.append(n);
			} else {
				switch (c) {
				case 'z':
					sb.append(0);
					i += 3;
					break;
				case 'o':
					sb.append(1);
					i += 2;
					break;
				case 't':
					if (s.charAt(i + 1) == 'w') {
						sb.append(2);
						i += 2;
					} else {
						sb.append(3);
						i += 4;
					}
					break;
				case 'f':
					if (s.charAt(i + 1) == 'o') {
						sb.append(4);
						i += 3;
					} else {
						sb.append(5);
						i += 3;
					}
					break;
				case 's':
					if (s.charAt(i + 1) == 'i') {
						sb.append(6);
						i += 2;
					} else {
						sb.append(7);
						i += 4;
					}
					break;
				case 'e':
					sb.append(8);
					i += 4;
					break;
				case 'n':
					sb.append(9);
					i += 3;
					break;

				}
			}
		}
		System.out.println(Integer.parseInt(sb.toString()));
	}

}
