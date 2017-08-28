import java.util.Scanner;

/**
*
* https://www.acmicpc.net/problem/1152
* 단어 개수 구하기
* 
*
**/
public class WordCount {
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner scan = new Scanner(System.in);
  String s = scan.nextLine().trim();
  String[] result = s.split(" ");
  int spaceCnt = 0;
  for (int i = 0; i < result.length; i++) {
   if (result[i].equals("")) {
    spaceCnt++;
   }
  }
  System.out.println(result.length - spaceCnt);
 }
}