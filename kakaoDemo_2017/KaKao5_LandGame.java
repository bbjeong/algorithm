import java.util.Scanner;
/**
 * @author : bbchu
 * @date : 2017. 9. 14.
 * @desc : 카카오 모의테스트 문제5
 * @problem : 땅따먹기 게임
 * @input : N X 4 행렬
 * @output : 가장 큰 합
 *
 */
public class KaKao5_LandGame {
 public final static int ROW = 4;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int n = scan.nextInt();
  int[][] land = new int[n][4];
  // int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
  System.out.println(Solution(land));
 }
 public static int Solution(int[][] land) {
  int n = land.length;
  int[][] dp = new int[n][ROW];
  // 첫번째 행 대입
  dp[0] = land[0];
  for (int i = 1; i < n; i++) {
   for (int j = 0; j < ROW; j++) {
    int max = -1;
    for (int k = 0; k < ROW; k++) {
     if (j != k) {
      max = Math.max(max, dp[i - 1][k] + land[i][j]);
     }
    }
    dp[i][j] = max;
   }
  }
  int answer = -1;
  for (int i = 0; i < ROW; i++) {
   answer = Math.max(answer, dp[n - 1][i]);
  }
  return answer;
 }
}
