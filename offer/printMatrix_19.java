
package offer;
import java.util.ArrayList;
public class printMatrix_19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       int row = matrix.length;
       int col = matrix[0].length;
       ArrayList<Integer> list = new ArrayList<>();
       //这种思想就是四角思想， 细节很重要 
       for (int n = 0; n < (Math.min(row, col) + 1) / 2; n++) {
           int i = n, j = n;
           for (j = n; j < col - n; j++) {
               list.add(matrix[i][j]);
           }
           j--;
           for (i = n + 1; i < row - n; i++) {
               list.add(matrix[i][j]);
           }
           i--;
           if (n < row - n - 1) {
               for (j = col - n - 2; j > n; j--) {
                   list.add(matrix[i][j]);
               }
           }
           if (n < col - n - 1) {
               for (i = row - n - 1; i > n; i--) {
                   list.add(matrix[i][j]);
               }               
           }
       }      
        return list;
    }
}