import java.util.*;

class Solution {

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int count = 1;

        int min = Arrays.stream(section).min().getAsInt();

        for (int i = min; i <= n; i++) {
            count++;
            if (count % m == 0) {
                answer++;
            }
        }

        return answer;
    }
}
