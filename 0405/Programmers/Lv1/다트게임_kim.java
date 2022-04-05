package study_0405;

import java.util.Scanner;

public class programmers_다트게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String get = sc.next();
		int[] score = new int[4]; // 점수 배열(인덱스 사용하기 위해 한칸 더 크게 만듦)
		int count = 0; // 몇 번 던졌는지 체크
		for(int i = 0; i < get.length(); i++) {
			if(get.charAt(i) == '*') {
				if(count == 1) { // 한번만 던졌다면 앞에 점수가 없으니까 이번에 획득한 점수만 2배
					score[1] = score[1]*2;
				}else if(count > 1) { // 2번이상 던졌다면 앞의 점수까지 2배
					score[count] = score[count]*2;
					score[count-1] = score[count-1]*2;
				}
			}else if(get.charAt(i)=='#') {
				score[count] = score[count]*-1; // 현재 획득 점수 * -1
			}else { // 점수랑 영역 확인
				int num = get.charAt(i)-'0';
				if(num == 1) { // 하나의 char을 가져와서 확인했을 때 그 숫자가 1이면  뒤의 char도 확인!
					char c = get.charAt(i+1); //그 뒤에 0이 나오면 숫자 10!
					if(c == '0') {
						num = 10;
					}
				}
				count++; // 던진 횟수 ++
				char area = get.charAt(i+1);
				if(num == 10) {
					area = get.charAt(i+2); // 숫자가 10이면 1,0 두개를 가져와서 영역은 i+2에서 가져와야 함
				}
				if(area == 'S') {
					score[count] = num;
				}else if(area == 'D') {
					score[count] = (int) Math.pow(num, 2);
				}else if(area == 'T') {
					score[count] = (int) Math.pow(num, 3);
				}
				i++;
				if(num == 10) {
					i++;
				}
			}
		}
		System.out.println(score[1]+score[2]+score[3]);
	}
}
