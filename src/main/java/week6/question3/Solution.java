/*
    https://programmers.co.kr/learn/courses/30/lessons/42892
    [프로그래머스][2019 KAKAO BLIND RECRUITMENT] 길찾기 게임
 */
package week6.question3;

//import
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

class Solution {

  //Node class
  static class Node
  {
      //variables
      int x;
      int y;
      int nodeNum;
      Node left;
      Node right;
      
      Node(int nodeNum, int x, int y)
      {
          this.nodeNum = nodeNum;
          this.x = x;
          this.y = y;
          left = null;
          right = null;
      }
  }
  
  public int[][] solution(int[][] nodeinfo) {
      
      //variables
      //pre-order, post-order
      int ways = 2;
      int[][] answer = new int[ways][nodeinfo.length];
      LinkedList<Node> nodes = new LinkedList<>();
      LinkedList<Integer> preNodes = new LinkedList<>();
      LinkedList<Integer> postNodes = new LinkedList<>();
      Node root;
      
      //initialize
      nodes = initNodes(nodeinfo);
      root = new Node(nodes.get(0).nodeNum, nodes.get(0).x, nodes.get(0).y);
      
      //insert
      for(int i = 1; i < nodes.size(); i++)
      {
          insert(root, nodes.get(i));
      }
      
      //preorder, postorder
      visitPreorder(root, preNodes);
      visitPostorder(root, postNodes);
      
      for(int j = 0; j < nodes.size(); j++)
      {
          answer[0][j] = preNodes.get(j);
          answer[1][j] = postNodes.get(j);
      }

      return answer;
  }
 
  //initialize nodes in order
  private LinkedList<Node> initNodes(int[][] nodeinfo)
  {
      //variables
      LinkedList<Node> init = new LinkedList<>();
      
      //initialize nodes
      for(int i = 0; i < nodeinfo.length; i++)
      {
          init.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
      }
      
      Collections.sort(init, new Comparator<Node>() 
      {
          public int compare(Node n1, Node n2)
          {
              return n2.y == n1.y ? n1.x - n2.x : n2.y - n1.y;
          }
      });

      return init;
  }
 
  //node insertion
  private void insert(Node root, Node next)
  {
      //left
      if(root.x > next.x)
      {
          //exist, left subtree
          if(root.left != null)
          {
              insert(root.left, next);
          }
          
          //empty
          else
          {
              root.left = next;
          }
      }
      
      //right
      else
      {
          //exist, right subtree
          if(root.right != null)
          {
              insert(root.right, next);
          }
          
          //empty
          else
          {
              root.right = next;
          }
      }         
  }
  
  //root > left subtree > right subtree : preorder 
  private void visitPreorder(Node root, LinkedList<Integer> preNodes)
  {
      if(root != null)
      {
          preNodes.add(root.nodeNum);
          visitPreorder(root.left, preNodes);
          visitPreorder(root.right, preNodes);
      }
  }
  
  //left subtree > right subtree > root : postorder
  private void visitPostorder(Node root, LinkedList<Integer> postNodes)
  {
      if(root != null)
      {
          visitPostorder(root.left, postNodes);
          visitPostorder(root.right, postNodes);
          postNodes.add(root.nodeNum);
      }
  }
}