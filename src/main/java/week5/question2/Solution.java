/*
    https://programmers.co.kr/learn/courses/30/lessons/64061
    [프로그래머스][2019 카카오 개발자 겨울 인턴십] 크레인 인형뽑기 게임
 */
package week5.question2;

//import
import java.util.Stack;

class Solution {
  public int solution(int[][] board, int[] moves) {
      
      //variables
      int answer = 0;
      Stack<Integer> picked = new Stack<>();
      
      //pick dolls from board
      for(int select : moves)
      {
          for(int i = 0; i < board.length; i++)
          {
              if(board[i][select - 1] != 0)
              {
                  if(!picked.isEmpty() && picked.peek() == board[i][select - 1])
                  {
                      picked.pop();
                      answer += 2;
                  }
                  
                  else
                  {
                      picked.push(board[i][select - 1]);
                  }
                  
                  board[i][select - 1] = 0;
                  break;
              }
          }
      }
      
      return answer;
  }
}