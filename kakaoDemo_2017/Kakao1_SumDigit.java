import java.util.Scanner;
/**
 * 
 * @author bbchu
 * 카카오테스트 문제1
 * 
 *         problem - 각 자리수의 합
 *         input - 100000000 이하의 정수
 *         output - 각 자리 수의 합
 *
 */
public class SumDigit {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int n = scan.nextInt();
  if (n > 100000000) {
   return;
  }
  System.out.println(sumDigit(n));
 }
 public static int sumDigit(int n) {
  int remain = n;
  int sum = 0;
  while (remain > 0) {
   int d = remain % 10;
   remain = (remain - d) / 10;
   sum += d;
  }
  return sum;
 }
}
