package com.company;

import java.util.ArrayList;
import java.util.List;
class FailureTest {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N]; // 결과(result)
        List<Integer> answer_list = new ArrayList<>(); // 결과 순서 리스트
        List<Double> failure_list = new ArrayList<>(); // 실패율 리스트
        List<Integer> challenger_list = new ArrayList<>(); // 도전자 리스트

        double fail = 0.0; // 실패율
        int failCnt = 0, totalCnt = 0;

        for(int i = 0; i < stages.length; i++) {
            challenger_list.add(stages[i]);
        }

        // 스테이지 수 N개
        for (int i = 1; i <= N; i++) {
            totalCnt = challenger_list.size();
            for(int j = 0; j < challenger_list.size(); j++) {
                if(i >= challenger_list.get(j)) {
                    failCnt++;
                    challenger_list.remove(j);
                    j--;
                }
            }

            // 실패율 = 실패 수 / 도전자 리스트 수
            fail = (double)failCnt / totalCnt;
            failCnt = 0;
            failure_list.add(fail);

            // 실패율 정렬
            for(int j = 0; j < failure_list.size(); j++) {
                if(j == failure_list.size() - 1) {
                    answer_list.add(i);
                    break;
                }

                if(fail > failure_list.get(answer_list.get(j)-1)) {
                    answer_list.add(j, i);
                    break;
                }
            }
        }


        for(int i = 0; i < answer.length; i++) {
            answer[i] = answer_list.get(i);
        }
        return answer;
    }
}

public class FailureRate {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
        FailureTest f = new FailureTest();
        f.solution(5, arr);
    }
}
