/*
 *	https://programmers.co.kr/learn/courses/30/lessons/42747
 *	프로그래머스 - 정렬 - H-Index (level 2)
 */
package week3.question1;

//import
import java.util.Arrays;

class Solution {
  public int solution(int[] citations) {
      
      //variables
      int answer = 0;
      
      Arrays.sort(citations);

      for(int i = 0; i < citations.length; i++)
      {
          if(citations[i] >= citations.length - i)
          {
              answer = Math.max(answer, citations.length - i);
          }
      }
      
      return answer;
  }
}