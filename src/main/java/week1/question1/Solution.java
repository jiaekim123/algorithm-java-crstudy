/*
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 * 프로그래머스 - 월간 코드 챌린지 시즌1 - 삼각 달팽이 (level 2)
 */
package week1.question1;

class Solution {
    public int[] solution(int n) {
        
        //variables
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] pyramid = new int[n][n];
        
        int row = -1;
        int column = 0;
        int num = 1;
        int index = 0;

        //from first row, each column goes down
        //next row is decreased by one, and goes right
        //then lasts are goes up
        for(int i = 0; i < pyramid.length; i++)
        { 
            for(int j = i; j < pyramid[i].length; j++)
            {
                //down
                if(i % 3 == 0)
                {
                    row++;
                }
                
                //right
                else if(i % 3 == 1)
                {
                    column++;
                }
                
                //up
                else if(i % 3 == 2)
                {
                    row--;
                    column--;
                }
                
                pyramid[row][column] = num++;  
            }
        }
        
        //int[][] to int[]
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++) 
            {
                if(pyramid[i][j] != 0)
                {
                    answer[index++] = pyramid[i][j];
                }
            }
        }
        
        return answer;
    }
}