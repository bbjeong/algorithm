import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/**
 * 
 * @author bbchu
 * https://www.acmicpc.net/problem/2606
 * 인접리스트와 DFS 를 이용한 바이러스 문제 
 *
 */
public class VirusDFS2 {
 final static int startVertex = 1;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  // 정점의 개수
  int vc = scan.nextInt();
  // 간선의 개수
  int ec = scan.nextInt();
  ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
  // 정점 개수 + 1 개 만큼 리스트 초기화 (0 ~ 7)
  for (int i = 0; i < vc + 1; i++) {
   array.add(new ArrayList<Integer>());
  }
  // 간선개수만큼 읽어서 리스트에 추가
  for (int i = 0; i < ec; i++) {
   int v1 = scan.nextInt();
   int v2 = scan.nextInt();
   array.get(v1).add(v2);
   array.get(v2).add(v1);
  }
  // check 배열 초기화
  boolean[] check = new boolean[vc + 1];
  Arrays.fill(check, false);
  
  int vertexCount = dfs(array, check, startVertex);
  System.out.println(vertexCount);
 }
 public static int dfs(ArrayList<ArrayList<Integer>> a, boolean[] c, int v) {
  Stack<Integer> stack = new Stack<Integer>();
  c[v] = true;
  stack.push(v);
  int count = 0;
  while (!stack.isEmpty()) {
   boolean flag = false;
   int top = stack.peek();
   for (int idx : a.get(top)) {
    if (!c[idx]) {
     stack.push(idx);
     count++;
     c[idx] = true;
     flag = true;
     break;
    }
   }
   if (!flag) {
    stack.pop();
   }
  }
  return count;
 }
}
