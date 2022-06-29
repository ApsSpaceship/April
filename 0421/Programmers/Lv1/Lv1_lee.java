class Lv1_lee {
    static final String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static StringBuilder sb = new StringBuilder();
    public int solution(String s) { 
        // 정답용 스트링빌더 초기화
        sb.setLength(0);
        // 문자로 입력된 숫자용 스트링 빌더
        StringBuilder tmp = new StringBuilder();
        // 문자열 길이 만큼 반복
        for(int i = 0 ; i < s.length(); i++) {
            // 문자
            char c = s.charAt(i);
            // 숫자 그대로면 정답스트링빌더에 append
            if((c - '0') <= 9 && (c - '0') >= 0)
                sb.append(c);   
            else { 
                // 문자이고, tmp 길이가 2보다 작으면 일단 tmp에 append ( 모든 숫자의 문자열 길이는 3이상)
                if(tmp.length() < 2) {
                     tmp.append(c);
                     continue;
                } 
                else {
                    // tmp 길이가 2보다 크면 tmp에 문자 더하고
                    tmp.append(c); 
                    // 일단 한번 문자열 확인
                    for(int j = 0; j < 10; j++) {
                        // 일치하면 
                        if(tmp.toString().equals(words[j])){
                            // 정답 스트링빌더에 j 숫자 append
                            sb.append(j);
                            // tmp 초기화
                            tmp.setLength(0);
                            // 문자열 확인 for문 빠져나오기
                            break;
                        }   
                    }
                }
            }
        }
        // 정답 = int로 변환
        int answer = Integer.parseInt(sb.toString()); 
        // 반환
        return answer;
    }

}