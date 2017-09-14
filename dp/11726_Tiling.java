import java.util.Scanner;
/**
 * @author   : bbchu
 * @date     : 2017. 9. 14.
 * @desc     : 백준 11726
 * @problem  : 2 X N 크기의 행렬이 있을때 2X1, 1X2 사이즈의 사각형이 배치되는 경우의 수
 * @input    : N
 * @output   : 배치 경우의 수
 *
 */
public class Tiling_11726 {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int n = scan.nextInt();
  int[] dp = new int[n + 1];
  tiling(dp, n);
  System.out.println(dp[n]);
 }
 public static void tiling(int[] dp, int n) {
  dp[0] = 1;
  dp[1] = 1;
  for (int i = 2; i <= n; i++) {
   dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
  }
 }
}
