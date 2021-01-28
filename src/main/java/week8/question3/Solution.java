/*
    https://programmers.co.kr/learn/courses/30/lessons/43164
    [프로그래머스][DFS/BFS] 여행경로
 */
package week8.question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        dfs(visited, "ICN", tickets, "ICN", 1, answer);
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }

    private void dfs(boolean[] visited, String city, String[][] tickets, String cities, int count, List<String> answer) {
        if (count == tickets.length + 1) {
            answer.add(cities);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(city)) {
                visited[i] = true;
                dfs(visited, tickets[i][1], tickets, cities + " " + tickets[i][1], count + 1, answer);
                visited[i] = false;
            }
        }
        return;
    }
}