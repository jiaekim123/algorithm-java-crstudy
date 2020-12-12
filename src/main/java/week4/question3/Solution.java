/*
    https://programmers.co.kr/learn/courses/30/lessons/17676
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 추석 트래픽 (level 3)
 */
package week4.question3;

//import
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

class Solution {
  public int solution(String[] lines) {
      
      //variables
      int answer = 0;
      int throughput = 0;
      SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
      String[] strSplit;
      Date date;
      double sec = 0.0;
      long endTime = 0;
      long startTime = 0;
      
      //split
      for(int i = 0; i < lines.length; i++)
      {
          //reset
          throughput = 0;
          
          try
          {
              strSplit = lines[i].split(" ");
              
              //completion time
              date = format.parse(strSplit[1]);
              endTime = date.getTime();
              
              for(int j = i; j < lines.length; j++)
              {
                  strSplit = lines[j].split(" ");
              
                  //start time in ms
                  date = format.parse(strSplit[1]);
                  sec = Double.parseDouble(strSplit[2].substring(0, strSplit[2].length() - 1));
                  startTime = (long) (date.getTime() - sec * 1000 + 1);
                  
                  //1 sec prior to start time
                  startTime -= 1000;
                  
                  
                  //if 1 sec prior to start time is prior to the previous work's completion time
                  //add throughput
                  if(startTime - endTime < 0)
                  {
                      throughput++;
                  }
              }
              
              //get max
              answer = Math.max(answer, throughput);
          }
          
          catch(ParseException e)
          {
              e.printStackTrace();
          }
      }
      
      return answer;
  }
}