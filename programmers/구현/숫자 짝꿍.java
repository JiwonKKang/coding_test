import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
    
        //1. 각 숫자의 갯수를 담는 크기 10의 배열 2개 선언(X,Y)
        //2. X와 Y를 반복문 돌면서 배열에 각 숫자 갯수를 할당
        //3. 배열을 반복문을 역순으로 돌면서 두 배열중에 더 갯수가 작은 값만큼 answer에 값 추가

        //참고. += 연산을 통해 String을 이어붙이는 연산은 계속해서 객체를 생성하여 시간복잡도가 상승 -> StringBuilder를 사용
        
        int [] xCount = new int[10];
        int [] yCount = new int[10];
        
        xCount = numCount(X);
        yCount = numCount(Y);
        
        for (int i = xCount.length-1; i >= 0 ; --i) {
            for (int j = 0; j < Math.min(xCount[i], yCount[i]); ++j) {
                answer.append(i);
            }
        }
        
        if (answer.toString().isBlank()) {
            return "-1";
        } else if(answer.toString().startsWith("0")) {
            return "0";
        }
        
        
        
        
        return answer.toString();
    }
    
    private int[] numCount(String number) {
        int [] arr = new int[10];
        for (int i = 0; i < number.length(); ++i) {
            int num =  number.charAt(i) - '0';
            arr[num]++;
        }
        return arr;
    }
}
