import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int [] score = new int[3];
        int opportunity = 0;
        int curr = Integer.MIN_VALUE;
        
        char [] dartArray = dartResult.toCharArray();
        
        for (int i = 0; i < dartArray.length; i++) {
            
            if (dartArray[i] - '0' >= 0 && dartArray[i] - '0' < 10 &&
               dartArray[i+1] - '0' == 0) {
                if(curr != Integer.MIN_VALUE) {
                    score[opportunity] = curr;
                    opportunity++;
                }
                curr = 10;
                i++;
                continue;
            }
            
            if(dartArray[i] - '0' >= 0 && dartArray[i] - '0' < 10) {
                if(curr != Integer.MIN_VALUE) {
                    score[opportunity] = curr;
                    opportunity++;
                }
                
                curr = dartArray[i] - '0';
                continue;
            }
            
            
            
            if (dartArray[i] == 'D') {
                curr = (int) Math.pow(curr, 2);
                continue;
            }
            
            if(dartArray[i] == 'T') {
                curr = (int) Math.pow(curr, 3);
                continue;
            }
            
            if(dartArray[i] == '*') {
                curr *= 2;
                if (opportunity > 0) score[opportunity - 1] *= 2; 
                continue;
            }
            
            if(dartArray[i] == '#') {
                curr *= -1;
                System.out.println(curr);
                continue;
            }
        }
        
        score[opportunity] = curr;
        
        for (int i : score ) {
            System.out.println(i);
        }
        
        int answer = Arrays.stream(score).reduce(0, Integer::sum);
        
        return answer;
    }
}
