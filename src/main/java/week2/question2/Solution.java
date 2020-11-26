/*
    https://programmers.co.kr/learn/courses/30/lessons/1829
    [프로그래머스][2017 카카오코드 예선] 카카오프렌즈 컬러링북
 */
package week2.question2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private final static int NUMBER_OF_AREA = 0;
    private final static int MAX_SIZE_OF_ONE_AREA = 1;
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        boolean[][] visited = new boolean[picture.length][picture[0].length];
        bfs(picture, visited, answer);
        return answer;
    }

    private void bfs(int[][] picture, boolean[][] visited, int[] answer){
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i<picture.length; i++){
            for (int j = 0; j<picture[0].length; j++){
                if (picture[i][j]!=0){
                    queue.offer(new Point( i, j, picture[i][j]));
                    visited[i][j] = true;
                    break;
                }
            }
        }
        while (!queue.isEmpty()){
            Point point = queue.poll();
            List<Point> connectList = new ArrayList<>();
            List<Point> disconnectList = new ArrayList<>();
            for (Direction direction : Direction.values()){
                int newX = point.x + direction.x;
                int newY = point.y + direction.y;
                if (newX >= 0 && newX < picture.length && newY >= 0 && newY < picture[0].length) {
                    if (!visited[newX][newY]) {
                        if (picture[point.x][point.y] != picture[newX][newY]) {
                            disconnectList.add(new Point(newX, newY, picture[newX][newY]));
                        } else {
                            connectList.add(new Point(newX, newY, picture[newX][newY]));
                        }

                    }
                }
            }
            if (connectList.size()==0){
                answer[NUMBER_OF_AREA]++;
            }

            for (Point newPoint : disconnectList){
                visited[newPoint.x][newPoint.y] = true;
                queue.offer(newPoint);
            }
            for (Point newPoint : connectList){
                visited[newPoint.x][newPoint.y] = true;
                queue.offer(newPoint);
            }

        }

    }
}
class Point {
    int x, y, color;
    public Point(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
enum Direction {
    DOWN(0,-1),
    RIGHT(1, 0),
    UP(0,1),
    LEFT(-1,0);

    int x;
    int y;

    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }
}
