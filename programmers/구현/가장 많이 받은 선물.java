import java.util.*;

class Solution {
    private int[] nextMonth;
    private int[][] gift;
    private Map<String, Integer> friendIndex;
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        friendIndex = createIndexMap(friends);
        nextMonth = new int[friends.length];
        gift = new int[friendIndex.size()][friendIndex.size()];
        
        
        
        for (String relation : gifts) {
            String from = relation.split(" ")[0];
            String to = relation.split(" ")[1];
            int fromIndex = friendIndex.get(from);
            int toIndex = friendIndex.get(to);
            
            gift[fromIndex][toIndex]++;
        }

        
        for (int fromIndex = 0 ; fromIndex < friendIndex.size() ; ++fromIndex) {
            for (int toIndex = 0 ; toIndex < friendIndex.size() ; ++toIndex) {
                if (fromIndex == toIndex) continue;
                
                if(gift[fromIndex][toIndex] - gift[toIndex][fromIndex] > 0) {
                    nextMonth[fromIndex]++;
                } else if(gift[fromIndex][toIndex] - gift[toIndex][fromIndex] == 0) {
                    
                    int fromGiftScore = calcGiftScore(fromIndex);
                    int toGiftScore = calcGiftScore(toIndex);
                    
                    System.out.println(fromIndex +  ":" + toIndex + " "+ fromGiftScore + "," + toGiftScore);
                    
                    if (fromGiftScore > toGiftScore) {
                        nextMonth[fromIndex]++;
                    }
                }
            }
        }
        answer = Arrays.stream(nextMonth).max().getAsInt();

        return answer;
    }
    
    private Map<String, Integer> createIndexMap(String[] friends) {
        Map<String, Integer> friendIndex = new HashMap<>();
        for(int i = 0; i < friends.length ; ++i) {
            friendIndex.putIfAbsent(friends[i], i);
        }
        return friendIndex;
    }
    
    private int calcGiftScore(int index) {
        int give = Arrays.stream(gift[index]).sum();
                    
        int receive = 0; 
        for (int i = 0; i < gift.length; i++) {
            if (index < gift.length) {
                receive += gift[i][index];
            }
        }   

        return give - receive;
    }
    
}
