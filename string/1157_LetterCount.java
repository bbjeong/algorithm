import java.util.Scanner;

/**
*
* https://www.acmicpc.net/problem/1157
* 가장 많이 사용된 알파벳 구하기 구하기
* 
*
**/
public class LetterCount {
 public static final int ALPHA_NUM = 26;
 public static final int START = 65;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  String s = scan.nextLine().trim().toUpperCase();
  int[] arr = new int[ALPHA_NUM];
  
  // 배열에 알파벳 개수 저장
  for (int i = 0; i < s.length(); i++) {
   int idx = (int) s.charAt(i) - START;
   arr[idx]++;
  }
  // calculate max value
  int max = -1;
  String result = "";
  for (int i = 0; i < arr.length; i++) {
   if (arr[i] > max) {
    max = arr[i];
    result = Character.toString((char)(i + START));
   }
  }
  // max 값 중복 여부 확인
  int maxCnt = 0;
  for (int i = 0; i < arr.length; i++) {
   if (arr[i] == max) {
    maxCnt++;
   }
  }
  if (maxCnt > 1) {
   result = "?";
  }
  System.out.println(result);
 }
}
 