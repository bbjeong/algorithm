import java.util.Scanner;
/**
 * 코딩인터뷰 p92 문제 1.5
 * 
 * 같은 문자를 압축하여 나타내는 알고리즘
 * 
 * 단, 단어를 압축하여 길이가 줄어들지 않으면 그대로 출력
 * 
 */
public class CompressChar {
 public static final int ALPHA_NUM = 26;
 public static final int START_IDX = 97;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  String input = scan.nextLine().toLowerCase();
  System.out.println(compress(input));
 }
 public static String compress(String str) {
  char c = str.charAt(0);
  StringBuffer sb = new StringBuffer();
  int len = str.length();
  int count = 1;
  for (int i = 1; i < len; i++) {
   if (str.charAt(i) != c) {
    sb.append(c + "" + count);
    c = str.charAt(i);
    count = 1;
   } else {
    count++;
   }
  }
  // 마지막 값 추가
  sb.append(c + "" + count);
  if (isLong(len, sb.length())) {
   return str;
  }
  return sb.toString();
 }
 // 길이가 줄어들지 않으면 그대로 출력
 public static boolean isLong(int a, int b) {
  if (a <= b) {
   return true;
  }
  return false;
 }
}
