/*
    https://programmers.co.kr/learn/courses/30/lessons/43164
    [프로그래머스][DFS/BFS] 여행경로
 */
package week8.question3;

//import
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
  //global variables
  static String route = "";
  static List<String> sorted = new ArrayList<>();
  static boolean[] visited;

  public String[] solution(String[][] tickets) {

      //variables
      String[] answer = {};
      visited = new boolean[tickets.length];

      for(int i = 0; i < tickets.length; i++)
      {
          if(tickets[i][0].equals("ICN"))
          {
              visited[i] = true;
              
              //reset
              route = tickets[i][0] + ",";

              dfs(tickets, tickets[i][1], 1);

              visited[i] = false;
          }
      }

      Collections.sort(sorted);

      answer = sorted.get(0).split(",");

      return answer;
  }

  //DFS
  public void dfs(String[][] tickets, String destination, int count)
  {
      route += destination + ",";

      if(count == tickets.length)
      {
          sorted.add(route);

          return;
      }

      for(int i = 0; i < tickets.length; i++)
      {
          if(destination.equals(tickets[i][0]) && !visited[i])
          {
              visited[i] = true;

              dfs(tickets, tickets[i][1], count + 1);

              visited[i] = false;
          
              //delete in reverse order till beginning
              route = route.substring(0, route.length() - 4);
          }
      }
  }
}