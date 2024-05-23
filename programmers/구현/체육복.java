import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        Set<Integer> lostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        Set<Integer> reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        
        Set<Integer> intersection = new HashSet<>(lostSet);
        intersection.retainAll(reserveSet);
        lostSet.removeAll(intersection);
        reserveSet.removeAll(intersection);
        
        for (int elem : reserveSet) {
            if(lostSet.contains(elem - 1)) {
                lostSet.remove(elem - 1);
            } else if(lostSet.contains(elem + 1)) {
                lostSet.remove(elem + 1); 
            }
        }
        return answer - lostSet.size();
    }
}
