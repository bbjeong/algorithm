import java.util.Arrays;
import java.util.Scanner;
public class CheckUnique {
 /**
  * 코딩인터뷰 p92 문제 1.1
  * 
  * 문자열에 포함된 문자들이 전부 유일한지 검사하는 알고리즘
  * 
  * 영어로만 체크한다고 가정
  * 
  */
 public static final int ALPHA_NUM = 26;
 public static final int START_IDX = 97;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  String input = scan.nextLine().toLowerCase();
  System.out.println(checkUniqueChar(input));
 }
 public static boolean checkUniqueChar(String str) {
  
  // 알파벳 개수보다 많은 경우 중복 존재
  if (str.length() > ALPHA_NUM) {
   return false;
  }
  // count할 배열 0으로 초기화 
  int[] result = new int[ALPHA_NUM];
  Arrays.fill(result, 0);
  boolean isUnique = true;
  
  // 문자열을 순서대로 체크하여 2개 이상인 경우 false 
  for (int i = 0; i < str.length(); i++) {
   int idx = (int) str.charAt(i) - START_IDX;
   if (result[idx] == 0) {
    result[idx]++;
   } else {
    isUnique = false;
    break;
   }
  }
  return isUnique;
 }
}
