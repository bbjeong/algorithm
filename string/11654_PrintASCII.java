import java.util.Scanner;

/**
*
* https://www.acmicpc.net/problem/11654
* 알파벳 입력에 대한 아스키코드값 출력
* 
*
**/
public class Main {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  String s = scan.nextLine();
  
  System.out.println((int)s.charAt(0));
 }
}
 