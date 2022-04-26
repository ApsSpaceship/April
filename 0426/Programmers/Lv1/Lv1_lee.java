class Solution {
    public String solution(String new_id) {
        // Lv 1
        new_id = new_id.toLowerCase();
        // Lv 2
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if(Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c=='.')
                sb.append(c);
        }
        // Lv 3
        new_id = sb.toString();
        if(new_id.contains("..")) {
            while(true) {
                new_id = new_id.replace("..", ".");
                if(!new_id.contains(".."))
                    break;
            }
        }
        // Lv 4
        if(new_id.length() > 0 && new_id.charAt(0) == '.') {
                new_id = new_id.substring(1, new_id.length());
        }
        if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
        }
        // Lv 5
        if(new_id.length() == 0)
            new_id = "a";
        // Lv 6
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(14) == '.')
                new_id = new_id.substring(0, 14);
        }
        // Lv 7
        if(new_id.length() <= 2) {
            char c = new_id.charAt(new_id.length()-1);
            sb.setLength(0);
            sb.append(new_id);
            while(true) {
                sb.append(c);
                if(sb.length() == 3)
                    break;
            }
            new_id = sb.toString();
        }
        return new_id;
    }
}