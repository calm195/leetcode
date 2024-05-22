import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wjx
 * @date 4/16/2024 5:07 PM
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {
                        0,0,0,5
                }, {
                4,3,1,4
                }, {
                0,1,1,4
                }, {
                1,2,1,3
        }, {
                0,0,1,1
        }
        };
        SetMatrixZeroes test = new SetMatrixZeroes();
        test.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        System.out.println(rowSet);
        System.out.println(colSet);

        for (int i : rowSet) {
            for (int j = 0; j < colLength; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j: colSet) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
