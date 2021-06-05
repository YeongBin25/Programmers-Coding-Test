package com.company;
import java.util.*;

class Sol {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        while(n != 0) {
            int k = n % 3;
            s.push(k);
            n /= 3;
        }
        int count = s.size();
        int ba = 1;
        for (int i = 0; i < count; i++) {
            answer += s.pop() * ba;
            ba *= 3;
        }
        return answer;
    }
}

public class ThridReverse {
    public static void main(String[] args) {
        Sol s = new Sol();
        s.solution(45);
    }
}
