import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Map<Integer, Boolean> win = new HashMap<>();

        int unknown = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                unknown++;
                continue;
            }
            win.put(lotto, true);
        }
        

        int cnt = 0;

        for (int num : win_nums) {
            if(win.containsKey(num)) cnt++;
        }

        answer[0] = getRank(cnt+unknown);
        answer[1] = getRank(cnt);

        return answer;
    }

    private int getRank(int num) {
        int rank = 0;
        rank = 7 - num;
        if(rank > 6) rank = 6;
        return rank;
    }
}
