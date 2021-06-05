package com.company;

class check {
    public int solution(String s) {
        int answer = 0;
        answer = Integer.parseInt(s);
        return answer;
    }
}

public class StringInt {
    public static void main(String[] args) {
        check s = new check();
        s.solution("1234");
    }
}
