class Solution {
    public String solution(int n, int t, int m, int p) {
        String test = Integer.toString(0,n);
		int l = 1;
		
		while(true) {
			test += Integer.toString(l,n);
			
			if(test.length() >= t*m) break;
			
			l++;
		}
		
		String[] tt = test.split("");
		
		String ans = "";
		
		for(int i=p-1, tc=0; tc<t; i+=m, tc++) {
			ans += tt[i].toUpperCase();
		}
        return ans;
    }
}
