package org.example;

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        //1. callings for문으로 반복
        //2. 각 반복의 call마다 players에서 해당 선수를 찾아서 앞 원소와 swap
        //3. answer 반환
        //4. 시간복잡도 너무큼 -> map 사용

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String call : callings) {
            int idx = map.get(call);
            String temp = players[idx];
            players[idx] = players[idx - 1];
            map.put(players[idx - 1], idx);
            players[idx - 1] = temp;
            map.put(temp, idx - 1);
        }

        return players;
    }
}

public class Main {
    public static void main(String[] ars)  {
        Solution solution = new Solution();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = solution.solution(players, callings);
        System.out.println(Arrays.toString(result));
    }
}
