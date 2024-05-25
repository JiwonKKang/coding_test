import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        char init = s.charAt(0);
        
        
        for (char c : s.toCharArray()) {
            if (cnt == 0) {
                init = c;
            }
            
            if (init == c) {
                cnt++;
            } else {
                cnt --;
            }
            
            if (cnt == 0) {
                answer++;
            }
        }
        
        if(cnt != 0) {
            answer++;
        }
        
        return answer;
    }
}
