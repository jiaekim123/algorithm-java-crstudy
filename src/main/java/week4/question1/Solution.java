/*
    https://programmers.co.kr/learn/courses/30/lessons/17681
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 비밀지도 (level 1)
 */
package week4.question1;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        //variables
        String[] answer = new String[n]; 
        String sharp = "";
        int[][] decMap = new int[n][n];
        
        int[][] firstMap = encMap(arr1, n);
        int[][] secondMap = encMap(arr2, n);
        
        for(int i = 0; i < n; i++)
        {
            //reset
            sharp = "";
        
            for(int j = 0; j < n; j++)
            {
                //bit operation OR
                decMap[i][j] = firstMap[i][j] | secondMap[i][j];
                
                if(decMap[i][j] == 1)
                {
                    sharp += "#";
                }
                
                else
                {
                    sharp += " ";
                }
            }
            
            answer[i] = sharp;
        }
        
        return answer;
    }
    
    //get the binary map
    private int[][] encMap(int[] arr, int n)
    {
        //variables
        int[][] map = new int[n][n];
        String binary = "";
        
        //loop through array, arr.length == n
        for(int i = 0; i < n; i++)
        {
            //convert int to binary in right format
            binary = Integer.toBinaryString(arr[i]);
            
            while(binary.length() < n)
            {
                binary = "0" + binary;
            }
            
            //insult binary values in int[][]
            for(int j = 0; j < n ; j++)
            {
                map[i][j] = Character.getNumericValue(binary.charAt(j));
            }
        }
        
        return map;
    }
}