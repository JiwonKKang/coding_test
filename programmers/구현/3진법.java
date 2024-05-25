import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder ternary = new StringBuilder();
        
        while(n > 0) {
            ternary.append(n % 3);
            n /= 3;
        }
        
        for (int i = 0; i < ternary.length(); i++) {
            answer = answer * 3 + (ternary.charAt(i) - '0');
        }
        
        return answer;
    }
}

// 자바 활용
// import java.util.*;

// class Solution {
//     public int solution(int n) {
//         int answer = 0;
        
//         String ternary = Integer.toString(n, 3);
        
//         String reversed= new StringBuilder(ternary).reverse().toString();
        
//         answer = Integer.parseInt(reversed, 3);
        
//         return answer;
//     }
// }
