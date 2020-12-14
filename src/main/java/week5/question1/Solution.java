/*
    https://programmers.co.kr/learn/courses/30/lessons/60057
    [프로그래머스][2020 KAKAO BLIND RECRUITMENT] 문자열 압축
 */
package week5.question1;

class Solution {
    public int solution(String s) {
        
        //variables
        int answer = s.length();
        int posComb = s.length() / 2;
        int count = 1;
        String comp1st = "";
        String comp2nd = "";
        StringBuilder result;
        
        //loop through possible number of character combination
        for(int i = 1; i <= posComb; i++)
        {
            //reset
            result = new StringBuilder();
            
            //loop for checking all characters
            for(int j = 0; j < s.length(); j += i)
            {             
                comp1st = divChar(j, i, s);
                count = 1;
                
                //to check next characters compare to above for loop
                for(int k = j + i; k < s.length(); k += i)
                {                    
                    comp2nd = divChar(k, i, s);
                    
                    //if equals then increase count
                    if(comp1st.equals(comp2nd))
                    {
                        count++;
                        j = k;
                        continue;
                    }
                    
                    //not equal
                    break;
                }
                
                //matched
                if(count != 1)
                {
                    result.append(count).append(comp1st);
                    continue;
                }
                
                //no match
                result.append(comp1st);
            }
            
            //find min length
            answer = Math.min(answer, result.toString().length());
        }
        
        return answer;
    }
    
    //return set of divided characters
    private String divChar(int index, int div, String s)
    {
        //exceed
        if(index + div >= s.length())
        {
            return s.substring(index, s.length());
        }
        
        return s.substring(index, index + div);
    }
}