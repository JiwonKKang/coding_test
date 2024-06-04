import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int command[] : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int index = command[2] - 1;

            List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());

            List<Integer> subList = arrayList.subList(start, end);
            subList.sort(Comparator.naturalOrder());
            answer.add(subList.get(index));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
