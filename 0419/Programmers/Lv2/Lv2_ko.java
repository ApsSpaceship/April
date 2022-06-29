public static int solution(String s) {
    int answer = 0;
    int size = s.length();
    int min = size; // 최솟값은 문자열 길이
    char[] str = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    
    for (int l = 1; l <= size / 2; l++) { // 문자열 길이 절반 만큼만
        int idx = 0;
        int cnt = 1;
        
        while (idx + l * 2 <= size) {
            boolean find = true; // 반복 확인 플래그
            for (int i = 0; i < l; i++) {
                if (str[i + idx] != str[i + l + idx]) { // 다른게 있다면 반복 아님
                    find = false;
                    break;
                }
            }
            
            if (find) // 반복된다면 cnt증가
                cnt++;
            else { // 반복이 아니면
                if (cnt > 1) // 여태 모인 반복 횟수
                    sb.append(cnt);

                cnt = 1; // 반복 횟수 초기화
                sb.append(s.substring(idx, idx + l)); // 이번 문자열 추가
            }
            
            idx += l; // 시작점 인덱스 l만큼 추가
        }

        if (cnt > 1) // 마지막 확인
            sb.append(cnt);
        sb.append(s.substring(idx)); // 남은거 넣기

        min = Math.min(min, sb.length()); // 최솟값 비교
        sb.setLength(0); // 스트링빌더 초기화
    }

    answer = min;

    return answer;
}