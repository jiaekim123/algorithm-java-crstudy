/*
    https://programmers.co.kr/learn/courses/30/lessons/17684
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT][3차] 압축
 */
package week7.question2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
//        assertArrayEquals(new int[]{11, 1, 27, 15}, new Solution().solution("KAKAO"));
        assertArrayEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}, new Solution().solution("TOBEORNOTTOBEORTOBEORNOT"));
        assertArrayEquals(new int[]{1, 2, 27, 29, 28, 31, 30}, new Solution().solution("ABABABABABABABAB"));
    }
}