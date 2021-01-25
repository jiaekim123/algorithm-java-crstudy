/*
    https://programmers.co.kr/learn/courses/30/lessons/17687
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] [3차] n진수 게임 (level 2)
 */
package week7.question3;

//import
import java.util.HashMap;

class Solution {
  public String solution(int n, int t, int m, int p) {
      
      //variables
      StringBuilder init = new StringBuilder();
      StringBuilder answer = new StringBuilder();
      int maxVal = t * m;
      
      //total possible nums
      for(int i = 0; i < maxVal; i++)
      {
          init.append(getConverted(n, i));
      }
      
      //find answer
      for(int j = p - 1; j < maxVal; j += m)
      {
          answer.append(init.charAt(j));
      }
      
      return answer.toString();
  }
  
  //get converted value
  private String getConverted(int n, int value)
  {
      //variables
      StringBuilder newStr = new StringBuilder();
      HashMap<Integer, String> hexaVal = new HashMap<>();
      int remainder = 0;
      
      //initialize
      hexaVal.put(10, "A");
      hexaVal.put(11, "B");
      hexaVal.put(12, "C");
      hexaVal.put(13, "D");
      hexaVal.put(14, "E");
      hexaVal.put(15, "F");
      
      //0 value
      if(value == 0)
      {
          newStr.append("0");
      }
      
      //convert
      while(value != 0)
      {
          //remainder
          remainder = value % n;
          
          //11 ~ 16
          if(n > 10 && remainder > 9)
          {
              newStr.append(hexaVal.get(remainder));
          }

          else
          {
              newStr.append(remainder);
          }

          value /= n;
      }
      
      return newStr.reverse().toString();
  }
}