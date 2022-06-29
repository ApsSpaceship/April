import java.util.Stack;
class Solution {
    // 소스 코드에 작성된 모든 괄호를 뽑아서 올바른 순서대로 배치된 괄호 문자열을 알려주는 프로그램
    public String solution(String p) {
        // 올바른 괄호 문자열이면, 그대로 반환
        if(isCorrect(p))
            return p;
        // 올바른 괄호 문자열로 변환하여 반환
        return convert(p);
    }
    // 올바른 괄호 문자열인지 판단.
    public boolean isCorrect(String p) {
        // 짝을 맞추기 위한 스택
        Stack<Character> stack = new Stack<>();
        for(int i =0; i < p.length(); i++) {
            char c = p.charAt(i);
            switch(c) {
                case '(':
                    // 열린 괄호는 push
                    stack.push(c);
                    break;
                case ')':
                    // 비어있지 않고 마지막이 열린 괄호이면 마지막 pop
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else 
                        // 비어있거나 마지막이 열린 괄호가 아니면 push
                        stack.push(c);
                    break;  
            }
        }
        // 스택이 비어있으면 괄호가 짝이 맞는다는 것이므로 올바른 괄호 문자열이다. 따라서 true 반환
        if(stack.isEmpty())
            return true;
        else
            // 아니면 false 반환
            return false;
    }
    
    // 균형 잡힌 괄호 문자열인지 확인함과 동시에 변환
    public String convert(String w) {
        // 두 균형잡힌 괄호 문자열로 분리할 예정
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        // 빈 문자열의 경우 빈문자열 반환
        if(w.equals(null))
            return w;
        // 열린 괄호 개수
        int openCnt = 0;
        // 문자열 길이만큼 반복
        for(int i =0 ; i < w.length(); i++) {
            // 열린 괄호면 ++
            if(w.charAt(i) == '(')
                openCnt++;
            // 닫힌 괄호 만나면 열린 괄호 닫히므로 --
            else
                openCnt--;
            // 잘 닫혔으면 최소 단위의 균형잡힌 괄호 문자열이 됨
            if(openCnt == 0){
                // 균형잡힌 괄호 문자열이므로 이 인덱스를 기준으로 u와 v 분리
                u.append(w.substring(0, i+1));
                v.append(w.substring(i+1));
                // u가 올바른 괄호 문자열인지 확인
                if(isCorrect(u.toString())) {
                    // 올바른 괄호 문자열의 경우, v에 대해 1단계부터 다시 수행 (재귀)
                    u.append(convert(v.toString()));
                }else {
                    // 올바른 괄호 문자열이 아닌 경우, 4번 수행
                    // 새로운 올바른 괄호 문자열을 생성해야 하므로 새로운 스트링빌더 생성
                    StringBuilder sb = new StringBuilder();
                    // 열린 괄호 -> v에 대해 1단계부터 재귀적으로 수행한 결과 문자열 -> 닫힌 괄호 
                    sb.append('(').append(convert(v.toString())).append(')');
                    // 그 후, u의 첫 번째와 마지막 문자 제거하고 나머지 문자열의 괄호 방향 변환
                    // 현재 u의 문자열
                    String str = u.toString();
                    // 스트링빌더 초기화
                    u.setLength(0);
                    // 첫번째와 마지막 문자 제거해야하므로 반복문 길이 조정
                    for(int j = 1; j < str.length()-1; j++) {
                        // 괄호 방향 변환
                        if(str.charAt(j) == '(')
                            u.append(')');
                        else
                            u.append('(');
                    }
                    // 새로운 문자열 u 를 반환할 문자열에 +
                    sb.append(u.toString());
                    // 새롭게 올바르게 배치된 괄호 문자열 반환
                    return sb.toString();
                }
                // 여기까지 진행되었으면 반복문 중단
                break;
            }
        }
        // u가 올바른 괄호 문자열인 경우에만 반환됨
        return u.toString();
    }
}