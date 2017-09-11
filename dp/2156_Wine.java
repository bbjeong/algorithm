import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * 2156번 DP를 이용한 포도주 계산 문제 블로그 따라함
 */
public class Wine {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int N = scan.nextInt();
  int[] arr = new int[N + 1];
  int[] dp = new int[10010];
  Arrays.fill(arr, 0);
  for (int i = 1; i <= N; i++) {
   arr[i] = scan.nextInt();
  }
  setDp(dp, arr, N);
  System.out.println(dp[N]);
 }
 public static void setDp(int[] dp, int[] arr, int N) {
//  for (int i = 1; i < 3 && i <= N; i++) {
  for (int i = 1; i < 3; i++) {
   if (i == 1) {
    dp[i] = arr[i];
   } else {
    dp[i] = arr[i] + arr[i - 1];
   }
  }
  for (int i = 3; i <= N; i++) {
   int result = 0;
   result = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
   result = Math.max(result, arr[i] + arr[i - 1] + dp[i - 3]);
   dp[i] = result;
  }
 }
}
