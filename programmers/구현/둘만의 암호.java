import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder resultBuilder = new StringBuilder();
        List<Character> alphabetList = new ArrayList<>();
        
        //1. List에 알파벳 모두 넣기
        //2. skip 삭제
        //3. s의 인덱스에서 index만큼 앞의 값 answer에 추가
        //4. 만약 s의 인덱스 + index가 26-skip 초과일 경우 (26-skip) - (s의 인덱스 + index)의 값 추가
        
        for (char currentChar = 'a'; currentChar <= 'z'; ++currentChar) {
            alphabetList.add(currentChar);
        }
        
        for (int i = 0; i < skip.length(); ++i) {
            Character skipChar = skip.charAt(i);
            alphabetList.remove(skipChar);
        }
        
        for (int i = 0; i < s.length(); ++i) {
            int currentIndex = alphabetList.indexOf(s.charAt(i));
            if (currentIndex + index >= alphabetList.size()) {
                int newIndex = currentIndex + index;
                while(newIndex >= alphabetList.size()) {
                    newIndex -= alphabetList.size();
                }
                resultBuilder.append(alphabetList.get(newIndex));
                continue;
            }
            
            resultBuilder.append(alphabetList.get(currentIndex + index));
        }
        
        return resultBuilder.toString();
    }
}
