/*
    https://programmers.co.kr/learn/courses/30/lessons/17684
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 3차 압축 (level 2)
 */
package week7.question2;

//import
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
  public int[] solution(String msg) {
      
      //variables
      int[] answer;
      int lastIdx = 27;
      HashMap<String, Integer> dictionary = new HashMap<>();
      ArrayList<Integer> convertAns = new ArrayList<>();
      StringBuilder sb;
      
      //initialize
      initDict(dictionary);
      
      //loop msg
      for(int i = 0; i < msg.length(); i++)
      {
          //reset
          sb = new StringBuilder();
          
          //add w
          sb.append(msg.charAt(i));
          
          while(dictionary.containsKey(sb.toString()))
          {
              i++;
              
              //end
              if(i == msg.length())
              {
                  break;
              }
              
              //add c
              sb.append(msg.charAt(i));
          }
         
          if(i == msg.length())
          {
              //end
              convertAns.add(dictionary.get(sb.toString()));
              break;
          }

          //add to dictionary
          dictionary.put(sb.toString(), lastIdx++);

          //save it into answer
          convertAns.add(dictionary.get(sb.toString().substring(0, sb.length() - 1)));
              
          //reset
          i--;
      }
      
      //convert
      System.out.println("convertAns.size: " + convertAns.size());
      answer = new int[convertAns.size()];
      
      for(int j = 0 ; j < answer.length; j++)
      {
          answer[j] = convertAns.get(j);
      }
      
      return answer;
  }
  
  //initialize dictionary with alphabets
  private void initDict(HashMap<String, Integer> dict)
  {
      //variables
      char alphabet= 'A';
      
      //total alphabet 26
      for(int i = 1; i < 27; i++)
      {
          dict.put(Character.toString(alphabet), i);
          alphabet++;
      }
  }
}