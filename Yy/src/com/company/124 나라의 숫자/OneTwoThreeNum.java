package com.company;

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder("");

        while (n > 0) {
            int rem = n % 3;
            if (rem == 1)
                sb.append(1);
            else if (rem == 2)
                sb.append(2);
            else
                sb.append(4);

            System.out.println(rem);
            if (rem == 0)
                n -= 1;

            n /= 3;

        }
        sb.reverse();
        return sb.toString();
    }
}


public class OneTwoThreeNum {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(4);
    }
}
