/*
 *  https://programmers.co.kr/learn/courses/30/lessons/1829
 *  프로그래머스 - 2017 카카오코드 예선 - 카카오프렌즈 컬러링북
 */
package week2.question2;

//import
import java.util.Queue;
import java.util.LinkedList;

class Solution {
  
  //Point class
  static class Point
  {
      //variables
      int x;
      int y;
      
      //constructor
      Point(int x, int y)
      {
          this.x = x;
          this.y = y;
      }
  }
  
  public int[] solution(int m, int n, int[][] picture) {
      
      //variables 
      int[] answer = new int[2];
      boolean[][] visited = new boolean[m][n];

      //loop
      for(int i = 0; i < m; i++)
      {
          for(int j = 0; j < n; j++)
          {
              //if already visited or value is 0 then pass
              if(visited[i][j] || picture[i][j] == 0)
              {
                  continue;
              }

              answer[0]++;
              answer[1] = Math.max(answer[1], searchSection(m, n, new Point(i, j), visited, picture));
          }
      }

      return answer;
  }
  
  //check if up, down, left, right are out of bound
  private boolean isLimit(int m, int n, Point current, int[] addRow, int[] addColumn, int index)
  {
      //variables
      int nextX = current.x + addRow[index];
      int nextY = current.y + addColumn[index];
      
      //out of bound
      if(nextX < 0 || nextX > m - 1 || nextY < 0 || nextY > n - 1)
      {
          return true;
      }
      
      return false;
  }
  
  //search sections BFS
  private int searchSection(int m, int n, Point current, boolean[][] visited, int[][] picture)
  {
      //variables
      Queue<Point> points = new LinkedList<>();
      
      //up, down, left, right
      int[] addRow = {0, 0, -1, 1};
      int[] addColumn = {1, -1, 0, 0};
      
      Point cur;
      int nextX = 0;
      int nextY = 0;
      int portion = 1;
      
      //visited
      visited[current.x][current.y] = true;
      points.offer(current);

      while(!points.isEmpty())
      {
          cur = points.poll();
          
          //check 4 directions up, down, left, right
          for(int i = 0; i < 4; i++)
          {
              if(isLimit(m, n, cur, addRow, addColumn, i))
              {
                  continue;
              }
              
              nextX = cur.x + addRow[i];
              nextY = cur.y + addColumn[i];
              
              //not visited, value is not 0, and they have same values
              if(!visited[nextX][nextY] && picture[nextX][nextY] != 0 && picture[nextX][nextY] == picture[cur.x][cur.y])
              {
                  visited[nextX][nextY] = true;
                  points.offer(new Point(nextX, nextY));
                  portion++;
              }
          }
      }

      return portion;
  }
}