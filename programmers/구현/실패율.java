import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int [] answer = new int[N];
        
        Map<Integer, Double> fail = new HashMap<>();
        
        for(int i = 1; i <= N; i++) {
            int challenger = countChallenger(stages, i);
            if(challenger == 0) {
                fail.put(i, 0.0);
                continue;
            }
            fail.put(i, (double) countFail(stages, i)/challenger);
        }
        
        System.out.println(fail);
        
        List<Integer> keySet = new ArrayList<>(fail.keySet());
        
        keySet.sort((o1,o2) -> {
            int compare = fail.get(o2).compareTo(fail.get(o1));
            if(compare == 0) {
                return o1.compareTo(o2);
            } else {
                return compare;
            }
            });
        
        answer = keySet.stream().mapToInt(Integer::intValue).toArray();
    
        return answer;
    }
    
    private int countChallenger(int[] stages, int step) {
        int count = 0;
        
        for (int stage : stages) {
            if(stage >= step) {
                count++;
            }
        }
        return count;
    }
    
    private int countFail(int[] stages, int step) {
        int count = 0;
        for(int stage : stages) {
            if(stage == step) {
                count++;
            }
        }
        return count;
    }
}
