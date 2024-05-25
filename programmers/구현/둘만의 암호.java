import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        List<Character> alphabets = new ArrayList<>();
        
        //1. List에 알파벳 모두 넣기
        //2. skip 삭제
        //3. s의 인덱스에서 index만큼 앞의 값 answer에 추가
        //4. 만약 s의 인덱스 + index가 26-skip 초과일 경우 (26-skip) - (s의 인덱스 + index)의 값 추가
        
        for (char c = 'a'; c <= 'z'; ++c) {
            alphabets.add(c);
        }
        
        for (int i = 0; i < skip.length(); ++i) {
            Character c = skip.charAt(i);
            alphabets.remove(c);
        }
        
        
        for (int i = 0; i < s.length(); ++i) {
            int idx = alphabets.indexOf(s.charAt(i));
            if (idx + index >= alphabets.size()) {
                int newIndex = (idx + index) % alphabets.size();
                answer.append(alphabets.get(newIndex));
                continue;
            }
            
            answer.append(alphabets.get(idx + index));
        }
        
        return answer.toString();
    }
}
