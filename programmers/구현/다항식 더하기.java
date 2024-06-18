import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int xnum = 0;
        int constNum = 0;
        String[] polys = polynomial.split(" ");
        for(String poly : polys) {
            if(poly.contains("x")) {
                // "x"만 있을 경우, 계수는 1로 처리
                if(poly.equals("x")) {
                    xnum += 1;
                } else {
                    // "2x", "10x" 등 숫자가 있는 경우
                    String coeff = poly.replace("x", "");
                    if (coeff.isEmpty()) {
                        xnum += 1;
                    } else {
                        xnum += Integer.parseInt(coeff);
                    }
                }
            } else if(!poly.equals("+") && !poly.isEmpty()) {
                // 상수 항을 처리
                constNum += Integer.parseInt(poly);
            }
        }
        
        // xnum과 constNum에 따라 최종 결과 생성
        if(xnum > 0 && constNum > 0) {
            answer = (xnum == 1 ? "x" : xnum + "x") + " + " + constNum;
        } else if(xnum > 0) {
            answer = xnum == 1 ? "x" : xnum + "x";
        } else if(constNum > 0) {
            answer = String.valueOf(constNum);
        } else {
            answer = "0";
        }
        return answer;
    }
}
