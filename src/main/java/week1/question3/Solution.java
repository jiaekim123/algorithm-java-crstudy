/*
 * https://programmers.co.kr/learn/courses/30/lessons/68646
 * 프로그래머스 - 월간 코드 챌린지 시즌1 - 풍선 터트리기(level 3)
 */

package week1.question3;

class Solution {
    public int solution(int[] a) {
        
        //variables
        int answer = 2;
        int first = a[0];
        int last = a[a.length - 1];
        
        //always first and last ballons are possible
        //divide into three groups, first, middle and last
        //only fail, if both first and last ballons are less than middle ballon
        for(int i = 1; i < a.length - 1; i++)
        {
            //check left
            if(first > a[i])
            {
                answer++;
                first = a[i];
            }
            
            //check right
            if(last > a[a.length - 1 - i])
            {
                answer++;
                last = a[a.length - 1 - i];
            }  
        }
        
        //duplication check
        return first == last ? answer - 1 : answer;
    }
}