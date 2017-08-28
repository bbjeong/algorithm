import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/**
 * 
 * @author bbchu
 * 
 * 인접행렬과 DFS 를 이용한 바이러스 문제 
 *
 */
public class VirusDFS1 {
 final static int startVertex = 1;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  // 정점의 개수
  int vc = scan.nextInt();
  // 간선의 개수
  int ec = scan.nextInt();
  int[][] array = new int[vc + 1][vc + 1];
  for (int i = 0; i < ec; i++) {
   int v1 = scan.nextInt();
   int v2 = scan.nextInt();
   array[v1][v2] = 1;
   array[v2][v1] = 1;
  }
  boolean[] check = new boolean[vc + 1];
  Arrays.fill(check, false);
  int sv = startVertex;
  int vertexCount = dfs(array, check, sv);
  System.out.println(vertexCount);
 }
 public static int dfs(int[][] a, boolean[] c, int v) {
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
}

 