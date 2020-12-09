/*
    https://programmers.co.kr/learn/courses/30/lessons/17677
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 뉴스 클러스터링 (level 2)
 */
package week4.question2;

//import
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int solution(String str1, String str2) {
      
      //variables
      int answer = 0;
      String str1Lower = "";
      String str2Lower = "";
      String[] str1Arry;
      String[] str2Arry;

      //to Lower case
      str1Lower = str1.toLowerCase();
      str2Lower = str2.toLowerCase();

      str1Arry = divAndSet(str1Lower);
      str2Arry = divAndSet(str2Lower);
      
      //get similarity
      answer = (int) (similarity(str1Arry, str2Arry) * 65536);
      
      return answer;
  }
  
  //divide string into 2 sequential characters
  //set String[] with alphabet characters
  private String[] divAndSet(String lowString)
  {
      //variables
      ArrayList<String> temp = new ArrayList<>();
      String[] output;
      char first = ' ';
      char last = ' ';
      
      for(int i = 0; i < lowString.length() - 1; i++)
      {
          first = lowString.charAt(i);
          last = lowString.charAt(i + 1);
          
          if(Character.isAlphabetic(first) && Character.isAlphabetic(last))
          {
              temp.add(Character.toString(first) + Character.toString(last));
          }
      }
      
      output = new String[temp.size()];
      
      for(int j = 0; j < output.length; j++)
      {
          output[j] = temp.get(j);
      }
      
      return output;
  }
  
  //get similarity between two sets
  private double similarity(String[] set1, String[] set2)
  {
      //variables
      HashMap<String, Integer> set1Val = new HashMap<>();
      HashMap<String, Integer> set2Val = new HashMap<>();
      int intersection = 0;
      int union = 0;

      //insert values to HashMap
      for(String keys : set1)
      {
          set1Val.put(keys, set1Val.getOrDefault(keys, 0) + 1);
      }
      
      for(String keys : set2)
      {
          set2Val.put(keys, set2Val.getOrDefault(keys, 0) + 1);
      }
      
      //intersection
      for(Map.Entry<String, Integer> val1 : set1Val.entrySet())
      {
          for(Map.Entry<String, Integer> val2 : set2Val.entrySet())
          {
              if(val1.getKey().equals(val2.getKey()))
              {
                  intersection += Math.min(val1.getValue(), val2.getValue());
              }
          }
      }
      
      //union = A + B - intersection
      union = set1.length + set2.length - intersection;
      
      return set1.length == 0 && set2.length == 0 ? 1 : (double) intersection / (double) union;
  }
}