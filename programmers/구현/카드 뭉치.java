import java.util.*;

class Solution {
    // public String solution(String[] cards1, String[] cards2, String[] goal) {
    //     String answer = "Yes";
    //     int cards1LastIndex = 0;
    //     int cards2LastIndex = 0;
        
    //     //1. goal 하나씩 반복
    //     //2. 각 card lastIndex 설정
    //     //3. indexOf로 lastIndex 업데이트
    //     //4. 해당 index가 lastIndex보다 낮다면 No
    
    //     for(int i = 0; i < goal.length; ++i) {
    //         String word = goal[i];
    //         int card1Index = Arrays.asList(cards1).indexOf(word);
    //         int card2Index = Arrays.asList(cards2).indexOf(word);
            
    //         if (card1Index > card2Index && card1Index == cards1LastIndex) {
    //             cards1LastIndex++;
    //         } else if (card2Index > card1Index && card2Index == cards2LastIndex){
    //             cards2LastIndex++;
    //         } else {
    //             return "No";
    //         }
    //     }
    //     return answer;
    // }
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cards1LastIndex = 0;
        int cards2LastIndex = 0;
        
        //1. goal 하나씩 반복
        //2. 각 card lastIndex 설정
        //3. indexOf로 lastIndex 업데이트
        //4. 해당 index가 lastIndex보다 낮다면 No
    
        for(int i = 0; i < goal.length; ++i) {
            String word = goal[i];
            
            if (cards1LastIndex < cards1.length && cards1[cards1LastIndex].equals(word)) {
                cards1LastIndex++;
            } else if (cards2LastIndex < cards2.length && cards2[cards2LastIndex].equals(word)){
                cards2LastIndex++;
            } else {
                return "No";
            }
        }
        return answer;
    }
}
