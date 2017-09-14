import java.util.Scanner;
/**
 * @author : bbchu
 * @date : 2017. 9. 13.
 * @desc : 백준 1924번
 * @problem : 2007년의 요일 구하기
 * @input : 월 일 (ex. 1 1)
 * @output : 해당하는 날짜의 요일 (ex. MON / TUE ..)
 *
 */
public class DayOfWeek_1924 {
 public static int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
   31 };
 public static String[] week = { "SUN", "MON", "TUE", "WED", "THU", "FRI",
   "SAT" };
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int m = scan.nextInt();
  int d = scan.nextInt();
  System.out.println(calDay(m, d));
 }
 public static String calDay(int m, int d) {
  int day = 0;
  for (int i = 0; i < m - 1; i++) {
   day += month[i];
  }
  day += d;
  ;
  int result = day % 7;
  return week[result];
 }
}
