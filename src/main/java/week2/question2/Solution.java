/*
    https://programmers.co.kr/learn/courses/30/lessons/1829
    [프로그래머스][2017 카카오코드 예선] 카카오프렌즈 컬러링북
 */
package week2.question2;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int maxSizeOfOneArea = Integer.MIN_VALUE;
        int numberOfArea = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    int size = getArea(i, j, m, n, picture, visited);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static class XY {
        int x, y, c;

        XY(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    private int getArea(int x, int y, int m, int n, int[][] picture, boolean[][] visited) {

        int size = 0;
        int[] moveX = {0, 1};
        int[] moveY = {1, 0};
        Queue<XY> que = new LinkedList<>();
        visited[x][y] = true;
        que.offer(new XY(x, y, picture[x][y]));

        while (!que.isEmpty()) {
            XY now = que.poll();
            size++;

            for (int i = 0; i < 2; i++) {
                int xx = now.x + moveX[i];
                int yy = now.y + moveY[i];
                if (0 <= xx && xx < m && 0 <= yy && yy < n) {
                    if (!visited[xx][yy] && picture[xx][yy] == now.c) {
                        visited[xx][yy] = true;
                        que.offer(new XY(xx, yy, picture[xx][yy]));
                    }
                }
            }
        }
        return size;
    }
}
