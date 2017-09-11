import java.util.Scanner;
/**
 * 
 * 11052번 DP : 붕어빵 세트를 팔 수 있는 최대가격 구하기
 *
 */
public class FishBun {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int N = scan.nextInt();
  int[] P = new int[N + 1];
  // set array P
  P[0] = 0;
  for (int i = 1; i < N + 1; i++) {
   P[i] = scan.nextInt();
  }
  int[] dp = new int[N + 1];
  setDp(dp, P, N);
  System.out.println(dp[N]);
 }
 public static void setDp(int[] dp, int[] P, int N) {
  for (int i = 1; i <= N; i++) {
   dp[i] = 0;
   for (int j = 1; j <= i; j++) {
    dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
   }
  }
 }
}
