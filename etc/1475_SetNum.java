import java.util.Scanner;
/**
 * @author : bbchu
 * @date : 2017. 9. 12.
 * @desc : 백준 1475번 문제
 * @problem : 0-9 수가 있는 세트가 있을 때, N 을 만드는데 필요한 최소의 세트 개수
 * @input : N (1 <= N <= 1,000,000)
 * @output : 최소의 세트 개수
 *
 */
public class SetNum_1475 {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  String N = scan.next();
  int[] arr = new int[10];
  setArray(arr, N);
  int result = getMax(arr);
  System.out.println(result);
 }
 public static void setArray(int[] arr, String N) {
  for (int i = 0; i < N.length(); i++) {
   int s = Integer.parseInt(N.substring(i, i + 1));
   if (s == 6 || s == 9) {
    int tmp = (arr[6] > arr[9]) ? 9 : 6;
    arr[tmp]++;
   } else {
    arr[s]++;
   }
  }
 }
 public static int getMax(int[] arr) {
  int max = -1;
  for (int i = 0; i < arr.length; i++) {
   max = (arr[i] > max) ? arr[i] : max;
  }
  return max;
 }
}
