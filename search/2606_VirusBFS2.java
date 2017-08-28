 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 
 * @author bbchu
 * https://www.acmicpc.net/problem/2606
 * 인접리스트 BFS 를 이용한 바이러스 문제 
 *
 */
public class VirusBFS2 {
 final static int startVertex = 1;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  // 정점의 개수
  int vc = scan.nextInt();
  // 간선의 개수
  int ec = scan.nextInt();
  ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
  for (int i = 0; i < vc + 1; i++) {
   array.add(new ArrayList<Integer>());
  }
  for (int i = 0; i < ec; i++) {
   int v1 = scan.nextInt();
   int v2 = scan.nextInt();
   array.get(v1).add(v2);
   array.get(v2).add(v1);
  }
  boolean[] check = new boolean[vc + 1];
  Arrays.fill(check, false);
  int vertexCount = bfs(array, check, startVertex);
  System.out.println(vertexCount);
 }
 public static int bfs(ArrayList<ArrayList<Integer>> a, boolean[] c, int v) {
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