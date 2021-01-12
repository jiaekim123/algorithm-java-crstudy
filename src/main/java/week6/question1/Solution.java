/*
    https://programmers.co.kr/learn/courses/30/lessons/42888
    [프로그래머스][2019 KAKAO BLIND RECRUITMENT] 오픈채팅방 (level 2)
 */
package week6.question1;

//import
import java.util.HashMap;

class Solution {
  public String[] solution(String[] record) {
      
      //variables
      String[] answer;
      String[] eachStr;
      int size = 0;
      int index = 0;
      HashMap<String, String> userName = new HashMap<>();

      //split by empty space
      for(String infos : record)
      {
          eachStr = infos.split(" ");
          
          //Enter
          if(eachStr[0].equals("Enter"))
          {
              size++;
              userName.put(eachStr[1], eachStr[2]);
          }
          
          //Leave
          else if(eachStr[0].equals("Leave"))
          {
              size++;
          }
          
          //Change
          else
          {
              userName.put(eachStr[1], eachStr[2]);
          }
      }

      //number of "Enter" and "Leave" in records
      answer = new String[size];
      
      //save answers
      for(String infos : record)
      {
          eachStr = infos.split(" ");
          
          //Enter
          if(eachStr[0].equals("Enter"))
          {
              answer[index++] = userName.get(eachStr[1]) + "님이 들어왔습니다.";
          }
          
          //Leave
          if(eachStr[0].equals("Leave"))
          {
              answer[index++] = userName.get(eachStr[1]) + "님이 나갔습니다.";
          }
      }
      
      return answer;
  }
}