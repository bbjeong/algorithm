import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author bbchu
 * 카카오테스트 문제2
 * 
 *         problem - 배열 안에 1 ~ 배열크기의 수가 포함되는지 체크
 *         input - n크기의 배열
 *         output - 포함 여부(true, false)  
 *
 */
public class FullArrayCheck {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int n = scan.nextInt();
  if (n > 100000) {
   return;
  }
  int[] input = new int[n];
  for (int i = 0; i < n; i++) {
   input[i] = scan.nextInt();
  }
  System.out.println(solution(input));
 }
 public static boolean solution(int[] arr) {
  int n = arr.length;
  
  boolean[] check = new boolean[n];
  Arrays.fill(check, false);
  for (int i = 0; i < n; i++) {
   int idx = arr[i];
   if (idx > n || idx < 1) {
    continue;
   }
   check[idx - 1] = true;
  }
  for (int i = 0; i < n; i++) {
   if (check[i] == false) {
    return false;
   }
  }
  return true;
 }
}
