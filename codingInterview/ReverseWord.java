import java.util.Scanner;
public class ReverseWord {
 /**
  * 
  * 문자열처리 - 공백을 기준으로 단어를 거꾸로 출력
  * 
  */
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  String[] str = scan.nextLine().split(" ");
   
  reverseWord(str);
 }
 
 public static void reverseWord(String[] s){
  int len = s.length;
  String[] result = new String[len];
  for (int i = 0; i < len; i++) {
   result[len - 1 - i] = s[i];
  }
  for (int i = 0; i < len; i++) {
   System.out.print(result[i] + " ");
  }
 }
}
