/*
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 * 프로그래머스 - 2020 카카오 인턴십 - 키패드 누르기    
 */
package week2.question1;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        //variables
        String answer = "";
        String letter = "";
        int[][] phone = new int[4][3];
        
        //initial position
        int[][] thumPos = { {3, 0}, {3, 2} };
        
        //2, 5, 8, 0 position
        int[][] undeterminedPos = { {0, 1}, {1, 1}, {2, 1}, {3, 1} };
        
        insultValue(phone);
        
        for(int nums : numbers)
        {
            //Left
            if(nums == 1 || nums == 4 || nums == 7)
            {
                answer += "L";
                
                //Move thumbs position
                moveThumbs(phone, nums, "L", thumPos);
                continue;
            }
            
            //Right
            if(nums != 0 && nums % 3 == 0)
            {
                answer += "R";
                
                //Move thumbs position
                moveThumbs(phone, nums, "R", thumPos);
                continue;
            }

            //Undetermined
            letter = getLR(thumPos, nums, undeterminedPos, hand);
            moveThumbs(phone, nums, letter, thumPos);
            answer += letter;
        }
        
        return answer;
    }
    
    //insult values to the 2D array from 1 to #(12)
    private int[][] insultValue(int[][] phone)
    {
        for(int i = 0; i < phone.length; i++)
        {
            for(int j = 0; j < phone[i].length; j++)
            {
                phone[i][j] = i * 3 + j + 1;
            }
        }
        
        return phone;
    }
    
    //move thumbs position
    private int[][] moveThumbs(int[][] phone, int nums, String finger, int[][] thumbPos)
    {
        //0 is 11 in 2D array
        if(nums == 0)
        {
            nums = 11;
        }
        
        loop:
        for(int i = 0; i < phone.length; i++)
        {
            for(int j = 0; j < phone[i].length; j++)
            {                
                //find match position and move
                if(nums == phone[i][j])
                {                   
                    //left
                    if(finger == "L")
                    {                                   
                        thumbPos[0][0] = i;
                        thumbPos[0][1] = j;
                    }
                            
                    //right
                    else
                    {
                        thumbPos[1][0] = i;
                        thumbPos[1][1] = j;            
                    }
                    
                    break loop;
                }
            }
        }
        
        return thumbPos;
    }
    
    //get L or R
    private String getLR(int[][] thumbPos, int nums, int[][] undeterminedPos, String hand)
    {
        //variables
        int left = 0;
        int right = 0;

        //2
        if(nums == 2)
        {
            left = Math.abs(thumbPos[0][0] - undeterminedPos[0][0]) + Math.abs(thumbPos[0][1] - undeterminedPos[0][1]);
            right = Math.abs(thumbPos[1][0] - undeterminedPos[0][0]) + Math.abs(thumbPos[1][1] - undeterminedPos[0][1]);
        }
        
        //5
        else if(nums == 5)
        {
            left = Math.abs(thumbPos[0][0] - undeterminedPos[1][0]) + Math.abs(thumbPos[0][1] - undeterminedPos[1][1]);
            right = Math.abs(thumbPos[1][0] - undeterminedPos[1][0]) + Math.abs(thumbPos[1][1] - undeterminedPos[1][1]);
        }
        
        //8
        else if(nums == 8)
        {
            left = Math.abs(thumbPos[0][0] - undeterminedPos[2][0]) + Math.abs(thumbPos[0][1] - undeterminedPos[2][1]);
            right = Math.abs(thumbPos[1][0] - undeterminedPos[2][0]) + Math.abs(thumbPos[1][1] - undeterminedPos[2][1]);
        }
        
        //0
        else
        {
            left = Math.abs(thumbPos[0][0] - undeterminedPos[3][0]) + Math.abs(thumbPos[0][1] - undeterminedPos[3][1]);
            right = Math.abs(thumbPos[1][0] - undeterminedPos[3][0]) + Math.abs(thumbPos[1][1] - undeterminedPos[3][1]);
        }
        
        //if distances are same
        if(left == right)
        {
            if(hand.equals("left"))
            {
                return "L";
            }
            
            else
            {
                return "R";
            }
        }
        
        return left > right ? "R" : "L";  
    }
}