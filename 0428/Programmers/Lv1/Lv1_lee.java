import java.util.ArrayList;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 유저 수
        int userCnt = id_list.length;
        // 메일 받는 횟수
        int[] answer = new int[userCnt];
        // 신고 당한 횟수
        int[] reportCnt = new int[userCnt];
        // 메일 수신 여부
        boolean[] mail = new boolean[userCnt];
        // 각 유저 별 신고한 타 회원 리스트
        ArrayList<Integer>[] reportUsers= new ArrayList[userCnt];
        // 초기화
        for(int i = 0; i < userCnt; i++) {
            reportUsers[i] = new ArrayList<>();
        }
        // 신고 정보
        String[] reportInfo = new String[2];
        // 신고 횟수만큼 반복
        for(int i =0; i < report.length; i++) {
            // 신고자와 신고 당한 사람 구분
            reportInfo = report[i].split(" ");
            // 신고자 idx
            int userIdx = 0;
            // 신고 당한 사람 idx
            int reportedIdx = 0;
            // 찾기
            for(int j = 0; j < userCnt; j++) {
                if(id_list[j].equals(reportInfo[0]))
                    userIdx = j;
                if(id_list[j].equals(reportInfo[1]))
                    reportedIdx = j;
            }
            // 신고 경력이 없는 경우
            if(!reportUsers[userIdx].contains(reportedIdx)){
                // 신고 리스트에 추가
                reportUsers[userIdx].add(reportedIdx);
                // 신고 당한 사람은 횟수 증가
                reportCnt[reportedIdx]++;
            }
        }
        // 신고 당한 횟수 확인해서 k 번 이상이면 메일 수신 여부 변경
        for(int i = 0; i < userCnt; i++) {
            if(reportCnt[i] >= k) 
                mail[i] = true;
        }
        // 유저 마다 신고한 회원 리스트에서 메일을 받은 회원이 있는 경우 처리결과 메일 횟수 증가
        for(int i = 0; i < userCnt; i++) {
            for(int j = 0; j < userCnt; j++) {
                if(mail[j]){
                    if(reportUsers[i].contains(j))
                       answer[i]++;
                }
            }
        }
        return answer;
    }
}