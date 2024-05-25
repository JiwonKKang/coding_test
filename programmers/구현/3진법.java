import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder ternary = new StringBuilder();
        
        while(n > 0) {
            ternary.append(n % 3);
            n /= 3;
        }
        
        for (int i = 0; i < ternary.length(); i++) {
            answer = answer * 3 + (ternary.charAt(i) - '0');
        }
        
        return answer;
    }
}
