/*
 * https://programmers.co.kr/learn/courses/30/lessons/68936
 * 프로그래머스 - 월간 코드 챌린지 시즌 1 - 쿼드압축 후 개수 세기(level 2)
 */

package week1.question2;

class Solution {
    public int[] solution(int[][] arr) {
        
        return square(arr, 0, 0, arr.length);
    }
    
    //calculate by square, recursively
    private int[] square(int[][] arr, int row, int column, int newLength)
    {
        //variables
        int zeroes = 0;
        int ones = 0;
        int[] upLeft = new int[2];
        int[] upRight = new int[2];
        int[] downLeft = new int[2];
        int[] downRight = new int[2];
        int[] tempAns = new int[2];
        
        //close statement
        if(isSame(arr, row, column, newLength))
        {
            if(arr[row][column] == 1)
            {
                ones++;
            }
            
            else
            {
                zeroes++;
            }
            
            return new int[] {zeroes, ones};
        }
        
        //recursive
        upLeft = square(arr, row, column, newLength / 2);
        upRight = square(arr, row, column + (newLength / 2), newLength / 2);
        downLeft = square(arr, row + (newLength / 2), column, newLength / 2);
        downRight = square(arr, row + (newLength / 2), column + (newLength / 2), newLength / 2);
        
        //calculate zeroes and ones
        for(int i = 0; i < 2; i++)
        {
            tempAns[i] += upLeft[i] + upRight[i] + downLeft[i] + downRight[i];
        }

        return tempAns;
    }
    
    //return if the square consists of same numbers
    private boolean isSame(int[][] arr, int row, int column, int newLength)
    {
        //variables
        int value = arr[row][column];
        
        for(int i = row; i < row + newLength; i++)
        {
            for(int j = column; j < column + newLength; j++)
            {
                if(value != arr[i][j])
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}