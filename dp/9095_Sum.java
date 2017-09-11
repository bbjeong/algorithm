import java.util.Scanner;

/**
 * 
 * 9095번 
 * DP - 1, 2, 3을 이용해 합의 경우의 수 구하기
 * 
 * input 
 * - N : 입력 개수
 * - N개 만큼 입력
 * 
 * output
 * - 각 input 에 대한 합의 경우의 수 출력
 * 
 */
public class Sum {
 public static final int LIMIT_VAL = 11;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int N = scan.nextInt();
  int[] input = new int[N];
  int maxVal = -1;
  
  // read input value
  for (int i = 0; i < N; i++) {
   int val = scan.nextInt();
   // limit check
   if (val >= LIMIT_VAL || val <= 0) {
    return;
   }
   input[i] = val;
   if (maxVal < val) {
    maxVal = val;
   }
  }
  // write output
  int[] sum = new int[maxVal + 1];
  setSumArr(sum, maxVal + 1);
  for (int i = 0; i < N; i++) {
   System.out.println(sum[input[i]]);
  }
 }
 // f[n] = f[n-1] + f[n-2] + f[n-3]
 public static void setSumArr(int[] sum, int n) {
  sum[0] = 0;
  sum[1] = 1;
  sum[2] = 2;
  sum[3] = 4;
  for (int i = 4; i < n; i++) {
   sum[i] = sum[i - 1] + sum[i - 2] + sum[i - 3];
  }
 }
}
