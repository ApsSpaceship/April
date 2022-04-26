package study0426;

public class programmers_lv1_신규아이디추천 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String new_id = "a...a";
		new_id = new_id.toLowerCase(); // 대문자 -> 소문자
		int check = 0; // . 연속 체크
		for(int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if((c-'a' >=0 && c-'a'<=25)||(c-'0' >=0 && c-'0'<=9)||c=='.'||c=='-'||c=='_') {
				if(c=='.') {
					check++;
				}
				if(c=='.'&&(check >1 || sb.length()==0)){
					continue;
				}
				if(c != '.') {
					check = 0;
				}
				sb.append(c); //연속하지 않은 . , 소문자, 숫자, -, _ 저장				
			}
		}
		String id = sb.toString();
		if(id.length()==0) {
			id = "a";
		}else if(id.length() >= 16) { //길이가 16보다 크거나 같으면 자른다.
			id = id.substring(0,15);
		}
		if(id.charAt(id.length()-1)=='.') {
			id = id.substring(0,id.length()-1); // 마지막 . 이면 잘라내기
		}
		if(id.length()<=2) {
			while(id.length()!=3) {
				id+=id.charAt(id.length()-1); // 길이가 2 이하면 마지막 글자 그대로 붙이기
			}
		}
		System.out.println(id);
	
	}

}
