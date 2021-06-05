package com.company;

import java.util.ArrayList;
import java.util.List;

class Solutions {
    public String solution(String new_id) {
        String answer = "";
        String a = "";
        int k = 0;
        // 1단계 (대문자를 소문자로 변환)
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isUpperCase(ch) == true)
                answer += Character.toLowerCase(ch);
            else
                answer += ch;
        }
        // 2단계 (알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거)
        for (int j = 0; j < answer.length(); j++) {
            char ch = answer.charAt(j);
            if (Character.isLowerCase(ch) == true || Character.isDigit(ch) == true || ch == '-'
                    || ch == '_' || ch == '.')
                a += ch;
        }

        answer = a;
        a = "";

        // 3단계 (마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환)

        for (int j = 0; j < answer.length(); j++) {
            char c = answer.charAt(j);
            if (j == 0)
                a += c;
            if (j > 0) {
                if (c != '.' || a.charAt(a.length()-1) != '.') {
                    a += c;
                }
            }
        }
        answer = a;

        int le = answer.length();
        // 4단계 (마침표(.)가 처음이나 끝에 위치한다면 제거)
        if (answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());
        }
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')
            answer = answer.substring(0, answer.length() - 1);

        // 5단계 (빈 문자열이라면, new_id에 "a"를 대입)
        if (answer.length() == 0)
            answer += "a";

        // 6단계 (길이 16이상이면, 15개 제외 나머지 제거, 제거 후 마침표가 끝에 있으면 마침표도 제거)
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.')
                answer = answer.substring(0, answer.length() - 1);
        }
        // 7단계 (길이가 2 이하이면 마지막 문자를 길이가 3될때까지 문자열 뒤에 반복해서 붙임)
        if (answer.length() < 3) {
            while (true) {
                answer += answer.charAt(answer.length() - 1);
                if (answer.length() == 3)
                    break;
            }
        }


        return answer;
    }
}

public class NewID {
    public static void main(String[] args) {
        Solutions s = new Solutions();
        String k = s.solution("...!@BaT#*..y.abcdefghijklm");
    }
}
