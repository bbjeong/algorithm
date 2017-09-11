import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/**
 * 
 * @author bbchu
 * 
 * 2606번
 * BFS 와 DFS에서 인접행렬, 인접리스트를 사용
 *
 */
public class Virus {
 final static int startVertex = 1;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  // 정점의 개수
  int vc = scan.nextInt();
  // 간선의 개수
  int ec = scan.nextInt();
  ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
  // 정점 개수 + 1 개 만큼 리스트 초기화 (0 ~ 7)
  for (int i = 0; i < vc + 1; i++) {
   list.add(new ArrayList<Integer>());
  }
  // set matrix and list
  int[][] array = new int[vc + 1][vc + 1];
  for (int i = 0; i < ec; i++) {
   int v1 = scan.nextInt();
   int v2 = scan.nextInt();
   array[v1][v2] = 1;
   array[v2][v1] = 1;
   list.get(v1).add(v2);
   list.get(v2).add(v1);
  }
  // set check array
  boolean[] check = new boolean[vc + 1];
  Arrays.fill(check, false);
  System.out.println(dfsMatrix(array, check, startVertex));
  Arrays.fill(check, false);
  System.out.println(dfsList(list, check, startVertex));
  Arrays.fill(check, false);
  System.out.println(bfsMatrix(array, check, startVertex));
  Arrays.fill(check, false);
  System.out.println(bfsList(list, check, startVertex));
 }
 /* DFS - 행렬 이용 */
 public static int dfsMatrix(int[][] a, boolean[] c, int v) {
  Stack<Integer> stack = new Stack<Integer>();
  boolean flag;
  int n = a.length - 1;
  stack.push(v);
  c[v] = true;
  int count = 0;
  while (!stack.isEmpty()) {
   int vv = stack.peek();
   flag = false;
   for (int i = 0; i <= n; i++) {
    if (a[vv][i] == 1 && !c[i]) {
     stack.push(i);
     count++;
     c[i] = true;
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
 
 /* DFS - 리스트 이용 */
 public static int dfsList(ArrayList<ArrayList<Integer>> a, boolean[] c, int v) {
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
 
 /* BFS - 행렬 이용 */
 public static int bfsMatrix(int[][] a, boolean[] c, int v) {
  Queue<Integer> queue = new LinkedList<Integer>();
  queue.offer(v);
  c[v] = true;
  int count = 0;
  while (!queue.isEmpty()) {
   int q = queue.poll();
   for (int i = 1; i <= a.length - 1; i++) {
    if (a[q][i] == 1 && c[i] == false) {
     queue.offer(i);
     c[i] = true;
     count++;
    }
   }
  }
  return count;
 }
 
 /* BFS - 리스트 이용 */
 public static int bfsList(ArrayList<ArrayList<Integer>> a, boolean[] c, int v) {
  Queue<Integer> queue = new LinkedList<Integer>();
  queue.offer(v);
  c[v] = true;
  int count = 0;
  while (!queue.isEmpty()) {
   int q = queue.poll();
   for(int idx : a.get(q)){
    if (c[idx] == false) {
     queue.offer(idx);
     c[idx] = true;
     count++;
    }
   }
  }
  return count;
 }
}
