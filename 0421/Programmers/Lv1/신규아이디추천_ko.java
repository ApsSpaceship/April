public String solution(String new_id) {
    return step7(step6(step5(step4(step3(step2(step1(new_id)))))));
}

static String step1(String str) { // 소문자로 변환
    return str.toLowerCase();
}

static String step2(String str) { // 숫자, 소문자, -, _, . 만 남기기
    StringBuilder ret = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        char now = str.charAt(i);
        if ('0' <= now && now <= '9' || 'a' <= now && now <= 'z' || now == '-' || now == '_' || now == '.')
            ret.append(now);
    }
//		str = str.replaceAll("[^a-z0-9_.-]","");
    return ret.toString();
}

static String step3(String str) { // .여러 개 -> .
    StringBuilder ret = new StringBuilder();
    char pre = '.';
    char now = '.';
    if (str.length() > 0) {
        now = str.charAt(0);
        pre = str.charAt(0);
    }
    for (int i = 1; i < str.length(); i++) {
        now = str.charAt(i);
        if (!(pre == '.' && now == '.')) { // ..인경우 .아닐 때까지 가서 .하나만 추가
            ret.append(pre);
            pre = now;
        }
    }

    if (now != '.')
        ret.append(now); // 뒤가 .인 경우 어차피 삭제될 거라서 그냥 추가 안 함
    return ret.toString();
}

static String step4(String str) {
    if (str.equals("."))
        str = "";
    else if (str.length() > 1) {
        if (str.charAt(0) == '.')
            str = str.substring(1);
        if (str.charAt(str.length() - 1) == '.')
            str = str.substring(0, str.length() - 1);
    }
    return str;
}

static String step5(String str) { // 빈 문자열이면 a대입
    if (str.length() == 0)
        str = "a";
    return str;
}

static String step6(String str) {
    if (str.length() > 15) { // 문자열 길이가 16자 이상이면
        str = str.substring(0, 15); // 앞 15자만 사용
        if (str.charAt(14) == '.') // 맨 뒤에 .있으면 제거
            str = str.substring(0, 14);
    }
    return str;
}

static String step7(String str) {
    while (str.length() < 3) { // 길이가 2자 이하면
        str += str.charAt(str.length() - 1); // 길이 3 될 때까지 마지막 문자 붙이기
    }
    return str;
}