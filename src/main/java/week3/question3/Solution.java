/*
    https://programmers.co.kr/learn/courses/30/lessons/42860
    [프로그래머스][탐욕법] 조이스틱 (level 3)
 */
package week3.question3;

class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] nameArr = name.toCharArray();
        int totalMoveCount = nameArr.length - 1;
        for (int i = 0; i<nameArr.length; i++){
            answer += getAlphabetChangeCount(nameArr[i]);
            totalMoveCount = getMoveCount(nameArr, i, totalMoveCount);
        }

        return answer + totalMoveCount;
    }

    private int getMoveCount(char[] nameArr, int i, int count) {
        int moveTo = i + 1;
        while (moveTo < nameArr.length && nameArr[moveTo] == 'A') {
            moveTo++;
        }
        return Math.min(count, (i * 2) + nameArr.length - moveTo);

    }
    private int getAlphabetChangeCount(char alphabet){
        int A = 65;
        int Z = 90;
        int up = (int)alphabet - A;
        int down = Z - (int)alphabet + 1;
        return (up < down) ? up : down;
    }
}