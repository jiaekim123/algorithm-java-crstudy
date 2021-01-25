/*
    https://programmers.co.kr/learn/courses/30/lessons/62048
    [프로그래머스][Summer/Winter Coding(2019)] 멀쩡한 사각형 (leven 2)
 */
package week7.question1;

class Solution {
    public long solution(int w, int h) {
        //variables
        long gcd = getGCD((long) w, (long) h);

        return (long) w * (long) h - ((long) w + (long) h - gcd);
    }
    
    //get Greatest Common Divisor
    private long getGCD(long w, long h)
    {
        if(h == 0)
        {
            return w;
        }
        
        return getGCD(h, w % h);
    }
}