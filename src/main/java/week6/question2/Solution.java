/*
    https://programmers.co.kr/learn/courses/30/lessons/42890
    [프로그래머스][2019 KAKAO BLIND RECRUITMENT] 후보키
 */
package week6.question2;

import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        List<int[]> attributeList = new ArrayList<>();
        boolean[] visited = new boolean[relation[0].length];
        for (int i = 0; i < relation[0].length; i++){
            powerSet(relation, visited, i, 0, attributeList);
        }
        return attributeList.size();
    }

    private void powerSet(String[][] tuples, boolean[] visited, int n, int idx, List<int[]> attributeList) {
        if(idx == n) {
            int[] attributes = new int[n+1];
            int num= 0;
            for (int i = 0; i<visited.length; i++){
                if (visited[i]==true) attributes[num] = i;
            }
            if (!isDuplicate(tuples, attributes)) attributeList.add(attributes);
            return;
        }
        // idx 포함
        visited[idx] = false;
        powerSet(tuples, visited, n, idx + 1, attributeList);

        // idx 포함x
        visited[idx] = true;
        powerSet(tuples, visited, n, idx + 1, attributeList);
    }

    private boolean isDuplicate(String[] tuples){
        Set<String> set = new HashSet<>();
        for (String tuple : tuples){
            set.add(tuple);
        }
        return tuples.length == set.size() ? false : true;
    }

    private boolean isDuplicate(String[][] tuples, int[] attributes){
        Set<String> set = new HashSet<>();
        for (String[] tuple : tuples){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<attributes.length;i++){
                sb.append(tuple[i]);
            }
            set.add(sb.toString());
        }
        return tuples.length == set.size() ? false : true;
    }

}