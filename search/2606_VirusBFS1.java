import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 
 * @author bbchu
 * 
 * 인접행렬과 BFS 를 이용한 바이러스 문제 
 *
 */
public class VirusBFS1 {
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
  int vertexCount = bfs(array, check, startVertex);
  System.out.println(vertexCount);
 }
 public static int bfs(int[][] a, boolean[] c, int v) {
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
}