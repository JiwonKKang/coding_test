import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        //1. stack에 차례대로 push
        //2. 빵(1)이 들어왔을때 3번 pop 3,2,1면 answer++
        //3. 아니라면 다시 push 3번
        
        Stack<Integer> stack = new Stack<>();
        
        for (int elem : ingredient) {
            if (stack.size() >= 3 && elem == 1) {
                int n3 = stack.pop();
                int n2 = stack.pop();
                int n1 = stack.pop();
                
                if(n1 == 1 && n2 == 2 && n3 == 3) {
                    answer++;
                    continue;
                }
                
                stack.push(n1);
                stack.push(n2);
                stack.push(n3);
            }
            stack.push(elem);
        }
        return answer;
    }
}
