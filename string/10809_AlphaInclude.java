import java.util.Arrays;
import java.util.Scanner;

/**
*
* https://www.acmicpc.net/problem/10809
* 알파벳 포함 여부 출력
* 
*
**/
public class Main {
 static final int ALPHA_NUM = 26;
 static final int START = 97;
 static final int END = 122;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  String s = scan.nextLine();
  int[] result = new int[ALPHA_NUM];
  Arrays.fill(result, -1);

  int tmp;
  for (int i = 0; i < s.length(); i++) {
   tmp = (int) s.charAt(i);
   if (tmp >= START && tmp <= END) {
    int idx = tmp - START;
    if (result[idx] == -1) {
     result[idx] = i;
    }
   }
  }
  for (int i = 0; i < result.length; i++) {
   System.out.print(result[i] + " ");
  }
 }
}