import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int remainingPlayer = stages.length;
        int [] numberInStage = new int[N+2];
        int answer[] = new int[N+1];
        
        HashMap<Integer, Double> stage = new HashMap<>();
        
        for (int i=0; i < stages.length; i++) {
            numberInStage[stages[i]] += 1;
        }
        
        for(int i=1; i <= N; i++) {
            if(remainingPlayer == 0) {
                stage.put(i, 0.0);
                continue;
            }
            double fail = (double) numberInStage[i] / remainingPlayer;
            remainingPlayer -= numberInStage[i];
            stage.put(i, fail);
        }
        
        List<Integer> stageKey = new ArrayList<>(stage.keySet());
        
        stageKey.sort((o1,o2) -> stage.get(o2).compareTo(stage.get(o1)));
        
        
        
        answer = stageKey.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
