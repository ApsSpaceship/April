package study0428;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_Lv1_신고결과받기 {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		int[] ans = new int[id_list.length];
		Map<String, Integer> map = new HashMap<>(); // 아이디와 번호를 맵핑시킨다.
		for(int i = 0; i < id_list.length; i++) {
			map.put(id_list[i], i);
		}
		List<String>[] list = new ArrayList[id_list.length]; // 나를 신고한 신고자들을 입력받는다.
		for(int i = 0; i < id_list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < report.length; i++) {
			String[] check = report[i].split(" ");
			String from = check[0]; //신고한사람
			String to = check[1]; // 신고당한사람
			if(!list[map.get(to)].contains(from)) { // 신고당한사람 리스트에 신고한사람이 없으면
				list[map.get(to)].add(from); // 신고당한사람의 리스트에 신고한사람 추가
			}
		}
		for(int i = 0; i < list.length; i++) {
			if(list[i].size() >= k) { // 신고한사람을 담은 리스트의 사이즈가 정지 기준보다 크거나 같으면
				for(String p : list[i]) {
					ans[map.get(p)]++; // 신고한사람 번호 ++
				}
			}
		}
		System.out.println(Arrays.toString(ans));
		
		
		
	}

}
