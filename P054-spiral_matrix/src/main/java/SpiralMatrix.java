import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wjx
 * @date 4/16/2024 8:25 PM
 */
public class SpiralMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}, {13, 14, 15}, {17, 18, 19}};
        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7}, {9, 10, 11, 12, 13, 14, 15}, {16, 17, 18, 19, 20, 21, 22}};
        SpiralMatrix test = new SpiralMatrix();

        System.out.println(test.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int top_row = 0;
        int top_col = n - 1;
        int bottom_row = m - 1;
        int bottom_col = 0;

        int top_j = 0;
        int top_i = 0;
        int bottom_j = n - 1;
        int bottom_i = m - 1;

        List<Integer> list = new ArrayList<>();

        while (top_row <= bottom_row) {
            while (top_j < top_col) {
                list.add(matrix[top_row][top_j]);
                top_j++;
            }
            top_j = bottom_col + 1;
            while (top_i < bottom_row) {
                list.add(matrix[top_i][top_col]);
                top_i++;
            }
            top_i = top_row + 1;
            if (bottom_row != top_row) {
                while (bottom_j > bottom_col) {
                    list.add(matrix[bottom_row][bottom_j]);
                    bottom_j--;
                }
            }
            bottom_j = top_col - 1;
            if (top_col != bottom_col){
                while (bottom_i > top_row) {
                    list.add(matrix[bottom_i][bottom_col]);
                    bottom_i--;
                }
            }
            bottom_i = bottom_row - 1;

            top_col--;
            bottom_row--;
            bottom_col++;
            top_row++;
        }
        if (m % 2 == 1 && n % 2 == 1){
            list.add(matrix[m / 2][n / 2]);
        }
        return list;
    }
}
