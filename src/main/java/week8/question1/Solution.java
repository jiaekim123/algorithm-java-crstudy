/*
    https://programmers.co.kr/learn/courses/30/lessons/12945
    [프로그래머스][연습문제] 피보나치의 수
 */
package week8.question1;

class Solution {
    public int solution(int n) {
        
        //variables
        int answer = 0;
        int n2 = 0;
        int n1 = 1;
        
        //0, 1
        if(n < 2)
        {
            return n == 0 ? 0 : 1;
        }

        //increase
        for(int i = 2; i <= n; i++)
        {
            answer = (n1 + n2) % 1234567;
            
            //update
            n2 = n1;
            n1 = answer;
        }
        
        return answer;
    }
}