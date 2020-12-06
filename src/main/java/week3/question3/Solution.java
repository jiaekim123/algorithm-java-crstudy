/*
 *	https://programmers.co.kr/learn/courses/30/lessons/42860 
 *	���α׷��ӽ� - Ž��� - ���̽�ƽ (level 3)
 */
package week3.question3;

class Solution {
    public int solution(String name) {
        
        //variables
        int answer = 0;
        int count = name.length() - 1;
        int next = 0;
        
        //loop through given string
        for(int i = 0; i < name.length(); i++)
        {
            answer += countUpDown(name.charAt(i));
            
            //find min left and right
            next = i + 1;
            
            while(next < name.length() && name.charAt(next) == 'A')
            {
                next++;
            }
            
            count = Math.min(count, (i * 2) + name.length() - next);
        }

        return answer + count;
    }
    
    //find min counts
    private int countUpDown(char change)
    {
        //variables
        int index = 0;
        int reverseIndex = 0;

        index = change - 'A';
        reverseIndex = 'Z' + 1 - change;
        
        return Math.min(index, reverseIndex);
    }
}