import java.util.Scanner;
/**
 * 
 * @author bbchu
 * 카카오테스트 문제4 
 *         problem - 2차원 배열에 1로 이루어진 가장 큰 정사각형의 넓이 구하기
 *         input - 1 <= row <= 1000, 1 <= col <= 1000 
 *         output - 가장 큰 정사각형의 넓이
 *
 */
public class MaxMatrix {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int colSize = scan.nextInt();
  int rowSize = scan.nextInt();
  if (colSize < 1 || colSize > 1000 || rowSize < 1 || rowSize > 1000) {
   return;
  }
  int[][] board = new int[colSize][rowSize];
  for (int i = 0; i < colSize; i++) {
   String s = scan.next();
   for (int j = 0; j < rowSize; j++) {
    board[i][j] = Integer.parseInt(s.substring(j, j + 1));
   }
  }
  for (int i = 0; i < colSize; i++) {
   for (int j = 0; j < rowSize; j++) {
    System.out.print(board[i][j] + " ");
   }
   System.out.println("");
  }
  System.out.println(blog(board));
  // System.out.println(mySolution(board));
 }
 public static int blog(int[][] board) {
  int max = -1;
  for (int i = 1; i < board.length; i++) {
   for (int j = 1; j < board[0].length; j++) {
    if (board[i][j] == 1) {
     board[i][j] = min(board[i - 1][j - 1], board[i - 1][j],
       board[i][j - 1]) + 1;
     max = (max < board[i][j]) ? board[i][j] : max;
    }
   }
  }
  return max * max;
 }
 public static int min(int a, int b, int c) {
  int min = -1;
  min = (a > b) ? b : a;
  min = (min > c) ? c : min;
  return min;
 }
 public static boolean isSquare(int x, int y, int matrixSize, int[][] matrix) {
  for (int i = 0; i < matrixSize; i++) {
   for (int j = 0; j < matrixSize; j++) {
    System.out.println("isSquare i, j " + i + " " + j);
    if (matrix[x + i][y + j] == 0) {
     return false;
    }
   }
  }
  return true;
 }
 public static int mySolution(int[][] board) {
  int colSize = board.length;
  int rowSize = board[0].length;
  int matrixSize = (colSize > rowSize) ? rowSize : colSize;
  int z = 0;
  Label: for (z = matrixSize; z > 0; z--) {
   for (int i = 0; i <= colSize - z; i++) {
    for (int j = 0; j <= rowSize - z; j++) {
     if (board[i][j] == 0) {
      continue;
     }
     boolean b = isSquare(i, j, z, board);
     if (b) {
      break Label;
     }
    }
   }
  }
  return z * z;
 }
}

