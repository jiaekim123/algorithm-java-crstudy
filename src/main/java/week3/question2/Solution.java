/*
 *	https://programmers.co.kr/learn/courses/30/lessons/42842
 *	���α׷��ӽ� - ����Ž�� - ī�� (level 2)
 */
package week3.question2;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        //variables
        int xSumY = (brown + 4) / 2;
        int xY = brown + yellow;
        
        int[] answer = {(int) (xSumY + Math.sqrt(xSumY * xSumY - 4 * xY)) / 2, 
                        (int) (xSumY - Math.sqrt(xSumY * xSumY - 4 * xY)) / 2};
        return answer;
    }
}