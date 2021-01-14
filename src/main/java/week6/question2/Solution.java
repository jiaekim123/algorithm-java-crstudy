/*
    https://programmers.co.kr/learn/courses/30/lessons/42890
    [프로그래머스][2019 KAKAO BLIND RECRUITMENT] 후보키
 */
package week6.question2;

//import
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
  public int solution(String[][] relation) {
      
      //variables
      int row = relation.length;
      int column = relation[0].length;
      ArrayList<Integer> answer = new ArrayList<>();

      //loop till all possible subsets
      for(int i = 1; i < (1 << column); i++)
      {
          //is Unique
          if(!isUnique(i, column, row, relation) || !isMinimal(i, answer))
          {
              continue;
          }
          
          answer.add(i);   
      }
      
      return answer.size();
  }
  
  //get subsets (bitmask)
  private ArrayList<Integer> getSubset(int subset, int numColumn)
  {
      //variables
      ArrayList<Integer> al = new ArrayList<>();
      
      //using shifting to check equal to 1 if & with 1
      for(int i = 0; i < numColumn; i++)
      {
          if(((subset >> i) & 1) == 1)
          {
              al.add(i);
          }
      }
      
      return al;
  }
  
  //uniqueness
  private boolean isUnique(int subset, int numColumn, int numRow, String[][] relation)
  {
      //variables
      ArrayList<Integer> al = getSubset(subset, numColumn);
      HashSet<String> hs = new HashSet<>();
      StringBuilder sb;

      for(int i = 0; i < numRow; i++)
      {
          sb = new StringBuilder();
          
          for(int j : al)
          {
              sb.append(relation[i][j]);
          }
          
          hs.add(sb.toString());
      }
      
      return hs.size() == numRow;       
  }
  
  //minimality
  private boolean isMinimal(int subset, ArrayList<Integer> answer)
  {
      for(int key : answer)
      {
          if((subset & key) == key)
          {
              return false;
          }
      }
      
      return true;
  }
}