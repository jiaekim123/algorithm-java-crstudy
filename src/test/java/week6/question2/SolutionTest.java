package week6.question2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        assertEquals(2, new Solution().solution(new String[][] {{"100","ryan","music","2"}, {"200","apeach","math","2"}, {"300","tube","computer","3"},
                {"400","con","computer","4"}, {"500","muzi","music","3"}, {"600","apeach","music","2"}}));
        String[][] args1 = new String[][] {
                {"4", "4", "사랑", "2020-07-03 오전 12:00:00", "love"}
                , {"5", "4", "같은, 좋은, 와 비슷한", "2020-07-03 오전 12:00:00", "like"}
                , {"6", "4", "사과,대도시", "2020-07-03 오전 12:00:00", "apple"}
                , {"7", "4", "빌다,기도하다,에게 간청하다", "2020-07-03 오전 12:00:00", "pray"}
                , {"8", "3", "빌다,기도하다,에게 간청하다", "2020-06-27 오전 12:00:00", "pray"}
                , {"9", "4", "안녕", "2020-07-03 오전 12:00:00", "hi"}
                , {"10", "3", "같은, 좋은", "2020-06-29 오전 12:00:00", "like"}
                , {"11", "2", "나는 모자를 벗는다", "2020-06-27 오전 12:00:00", "I take off my hat"}};

        assertEquals(5,  new Solution().solution(args1));

        String[][] args2 = new String[][] {
                {"4", "4", "사랑", "2020-07-03 오전 12:00:00", "love"}
                , {"5", "4", "같은, 좋은, 와 비슷한", "2020-07-03 오전 12:00:00", "like"}
                , {"6", "4", "사과,대도시", "2020-07-03 오전 12:00:00", "apple"}
                , {"7", "4", "빌다,기도하다,에게 간청하다", "2020-07-03 오전 12:00:00", "pray"}
                , {"8", "4", "빌다,기도하다,에게 간청하다", "2020-06-27 오전 12:00:00", "pray"}
                , {"9", "4", "안녕", "2020-07-03 오전 12:00:00", "hi"}
                , {"10", "3", "같은, 좋은", "2020-06-29 오전 12:00:00", "like"}
                , {"11", "2", "나는 모자를 벗는다", "2020-06-27 오전 12:00:00", "I take off my hat"}};

        assertEquals(3,  new Solution().solution(args2));
    }

}