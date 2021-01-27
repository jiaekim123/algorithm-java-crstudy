/*
    https://programmers.co.kr/learn/courses/30/lessons/42628
    [프로그래머스][힙] 이중우선순위 큐
 */
package week8.question2;

//import
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
  public int[] solution(String[] operations) {
      
      //variables
      PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Integer> minQ = new PriorityQueue<>();
      char inst = ' ';
      int value = 0;
      
      //loop
      for(String info : operations)
      {
          //instruction
          inst = info.charAt(0);
          
          //value
          value = Integer.parseInt(info.substring(2));
          
          //insert
          if(inst == 'I')
          {
              maxQ.add(value);
              minQ.add(value);
              
              continue;
          }
          
          //delete max
          if(value == 1)
          {
              minQ.remove(maxQ.poll());
              continue;
          }
          
          //delete min
          maxQ.remove(minQ.poll()); 
      }
      
      //if empty 0,0 otherwise max, min
      return maxQ.isEmpty() ? new int[] {0, 0} : new int[] {maxQ.peek(), minQ.peek()};
  }
}