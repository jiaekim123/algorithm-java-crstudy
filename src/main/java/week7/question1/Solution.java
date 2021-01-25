/*
    https://programmers.co.kr/learn/courses/30/lessons/62048
    [프로그래머스][Summer/Winter Coding(2019)] 멀쩡한 사각형 (leven 2)
 */
package week7.question1;

import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        // 최대공약수 구하기
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();

        // (전체 크기) - (한 패턴 직사각형 당 사용하지 못하는 정사각형 크기 * 반복횟수)
        // (w * h) - (((w / 최대공약수) + (h / 최대공약수) - 1) * 최대공약수)
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }
}