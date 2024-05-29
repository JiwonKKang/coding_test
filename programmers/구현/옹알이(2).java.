import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String [] arr = {"aya", "ye", "woo", "ma"};
        
        for (String babble : babbling) {
            
            if(babble.contains("ayaaya") || 
               babble.contains("yeye") || 
               babble.contains("woowoo") ||
               babble.contains("mama")) continue;
            
            for(int i = 0; i < 4; i++) {
                babble = babble.replace(arr[i], " ");
            }
                        
            if(babble.isBlank()) answer++;
        }
        return answer;
    }
}
