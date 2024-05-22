import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answerList = new ArrayList<>();

        HashMap<String, Integer> nameMap = new HashMap<>();

        for (int i = 0 ; i < name.length ; ++i) {
            nameMap.put(name[i], yearning[i]);
        }

        int i = 0;
        for (String[] eachPhoto : photo) {
            int sum = 0;
            for (String people : eachPhoto) {
                sum += nameMap.getOrDefault(people, 0);
            }
            answerList.add(sum);
        }

        return answerList.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();
    }
}
