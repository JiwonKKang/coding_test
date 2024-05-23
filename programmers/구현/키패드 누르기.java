import java.util.*;

class Solution {
    //1. 왼손 마지막 번호 저장하면서 갱신
    //2. 오른손도 마찬가지
    //3. 중간버튼을 누를때 거리구하고 -> 거리 어떻게 구하지
    //왼손 버튼에서  +1 하고 3씩 더하면서 해당 중간번호까지 index++, 오른손은 -1
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        
        Set<Integer> leftSet = new HashSet<>(Arrays.asList(1,4,7));
        
        Set<Integer> middleSet = new HashSet<>(Arrays.asList(2,5,8,0));
        Set<Integer> rightSet = new HashSet<>(Arrays.asList(3,6,9));
        
        for (int number : numbers) {
            if (leftSet.contains(number)) {
                answer += "L";
                left = number;
                continue;
            }
            
            if (rightSet.contains(number)) {
                answer += "R";
                right = number;
                continue;
            }
            
            if (number == 0) number = 11;
            
            int leftDistance = (Math.abs(number - left) / 3) + (Math.abs(number - left) % 3);
            int rightDistance = (Math.abs(number - right) / 3) + (Math.abs(number - right) % 3);  

            if (leftDistance > rightDistance) {
                answer += "R";
                right = number;
                continue;
            } else if(leftDistance < rightDistance) {
                answer += "L";
                left = number;
                continue;
            } else {
                switch(hand) {
                        case "right" -> {
                            answer += "R";
                            right = number;
                        }
                        case "left" -> {
                            answer += "L";
                            left = number;
                        }
                }
            }
            
            
            
        }
        
        return answer;
    }
}
