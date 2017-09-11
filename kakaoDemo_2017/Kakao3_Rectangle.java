import java.util.Scanner;
/**
 * 
 * @author bbchu
 * 카카오테스트 문제3
 * 
 *         problem - 직사각형 나머지 좌표 구하기 input - 직사각형을 이루는 좌표 3개 output - 직사각형을 이루는
 *         나머지 좌표 1개
 *
 */
public class Rectangle {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int[][] input = { { 1, 1 }, { 1, 2 }, { 2, 2 } };
  int[][] input2 = { { 1, 4 }, { 3, 4 }, { 3, 10 } };
  int[] answer = solution(input2);
  System.out.println("[" + answer[0] + "," + answer[1] + "]");
 }
 public static int[] solution(int[][] arr) {
  int[] answer = new int[2];
  int[] x = new int[3];
  int[] y = new int[3];
  for (int i = 0; i < arr.length; i++) {
   x[i] = arr[i][0];
   y[i] = arr[i][1];
  }
  answer[0] = difNum(x);
  answer[1] = difNum(y);
  return answer;
 }
 public static int difNum(int[] arr) {
  int x1 = arr[0];
  int x2 = arr[1];
  int x3 = arr[2];
  if (x1 == x2) {
   return x3;
  } else if (x1 == x3) {
   return x2;
  }
  return x1;
 }
}
