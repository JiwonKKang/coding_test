import java.util.*;

class Solution {
    //1. 반복문을 돌며 원소가 0보다 큰값이 나올때까지 해당 열에서 한 행씩 내려감
    //2. 0보다 큰 즉 원소가 들어있는 위치에오면 해당 원소를 스택에 넣고 0으로 바꿈
    //3. 큐에 넣을때 탑이 해당 원소와 같다면 스택에서 pop하고 answer + 2
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {
            for(int row = 0; row < board.length; ++row) {
                int element = board[row][move-1];
                if (element > 0) {
                    board[row][move-1] = 0;
                    if(!stack.empty() && stack.peek().equals(element)) {
                        stack.pop();
                        answer += 2;
                        break;
                    }
                    stack.push(element);
                    break;
                }
            }
        }
        
        return answer;
    }
}
