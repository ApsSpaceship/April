import java.util.LinkedList;
import java.util.List;

public class lv1_신규아이디추천 {
public static void main(String[] args) {
	
	String new_id = "=.=";
	
	// 모든 대문자를 대응되는 소문자로 치환합니다.
	new_id = new_id.toLowerCase();
	
	// 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
	
	int n = new_id.length();
	
	char[] idarr = new_id.toCharArray();
	
	List<Character> idlist = new LinkedList<>();
	
	for(int i=0; i<idarr.length; i++) {
		if(idarr[i] == '-' || idarr[i] == '_' || idarr[i] == '.' || (idarr[i] >= '0' && idarr[i] <='9') || (idarr[i]>= 'a' && idarr[i] <='z')) {
			idlist.add(idarr[i]);
		}
	}
	
	// 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	for(int i=0; i<idlist.size()-1; i++) {
		if(idlist.get(i) == '.' && idlist.get(i+1) == '.') {
			idlist.remove(i);
			i--;
		}
	}
	
	// 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	if(idlist.get(0) == '.') {
		idlist.remove(0);
	}
	
	if(idlist.size()>0 && idlist.get(idlist.size()-1) == '.') {
		idlist.remove(idlist.size()-1);
	}
	
	// 빈 문자열이라면, new_id에 "a"를 대입합니다.
	if(idlist.size() == 0) {
		idlist.add('a');
	}
	
	// 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	if(idlist.size()>=16) {
		while(idlist.size() != 15) {
			idlist.remove(15);
		}
	}
	
	// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	if(idlist.get(idlist.size()-1) == '.') {
		idlist.remove(idlist.size()-1);
	}
	
	// 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	
	if(idlist.size()<=2) {
		char addword = idlist.get(idlist.size()-1);
		while(idlist.size()<=2) {
			idlist.add(addword);
		}
	}
	
	StringBuilder sb = new StringBuilder();
	
	for(int i=0; i<idlist.size(); i++) {
		sb.append(idlist.get(i));
	}
	System.out.println(sb.toString());
}
}
