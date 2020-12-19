/*
    https://programmers.co.kr/learn/courses/30/lessons/17678
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 1차 셔틀버스
 */
package week5.question3;

//import
import java.util.PriorityQueue;

class Solution {
  public String solution(int n, int t, int m, String[] timetable) {
      
      //variables
      PriorityQueue<Integer> crews = new PriorityQueue<>();
      int maxHeadCount;
      int busSchedule = 9 * 60;
      int lastCrew = 0;
      int ans = 0;
      
      //insert crews to queue
      for(String crew : timetable)
      {
          //save in minute
          crews.offer(Integer.parseInt(crew.substring(0, 2)) * 60 + Integer.parseInt(crew.substring(3)));
      }
      
      //loop till no more bus left
      while(n-- > 0)
      {
          //reset
          maxHeadCount = m;
          
          //check crews
          while(!crews.isEmpty())
          {
              
              if(crews.peek() > busSchedule || maxHeadCount == 0)
              {
                  break;
              }
              
              maxHeadCount--;
              lastCrew = crews.poll();
          }

          //if last bus
          if(n == 0)
          {
              //available
              if(maxHeadCount != 0)
              {
                  ans = busSchedule;
              }
              
              //not available then get time 1min prior to last crew
              else
              {
                  ans = lastCrew - 1; 
              }
          }
          
          //not last bus, but no one waits
          if(n > 0 && crews.isEmpty())
          {
              //last bus
              ans = busSchedule + ((n * t) - t);
              break;
          }
          
          //next bus
          busSchedule += t;
      }

      return String.format("%02d", ans / 60) + ":" + String.format("%02d", ans % 60);
  }
}