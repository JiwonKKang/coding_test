import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int t = 0; t < targets.length; t++) {
            String target = targets[t];
            int sum = 0;
            
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                
                int minIndex = Integer.MAX_VALUE;
                for (String key : keymap) {
                    int index = key.indexOf(c);
                    if (index >= 0) {
                        minIndex = Math.min(minIndex, index);
                    }
                }
                
                // 문자가 keymap에 없는 경우
                if (minIndex == Integer.MAX_VALUE) {
                    sum = -1; // 문자를 찾을 수 없음을 표시
                    break;
                }
                
                sum += minIndex + 1;
            }
            answer[t] = sum;
        }

        return answer;
    }
}
