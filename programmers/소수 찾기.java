import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean[] visited = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;

        recursive("", numbers);

        return set.size();
    }

    private void recursive(String current, String others) {
        if (!current.isEmpty()) {
            Integer num = Integer.valueOf(current);
            if (isPrime(num)) set.add(num);
        }

        for(int i=0; i < others.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                recursive(current + others.charAt(i), others);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i=2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
