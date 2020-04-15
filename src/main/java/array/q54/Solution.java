package array.q54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (null == matrix || matrix.length == 0) {
            return new ArrayList<Integer>();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, up = 0;
        int right = n - 1, down = m - 1;
        int size = m * n;
        int index = 0;
        while (true) {
            for (int y = left; y <= right; y++) {
                result.add(matrix[up][y]);
                if(result.size() == size)
                    break;
            }
            if(result.size() == size)
                break;
            up++;
            for (int x = up; x <= down; x++) {
                result.add(matrix[x][right]);
                if(result.size() == size)
                    break;
            }
            if(result.size() == size)
                break;
            right--;
            for (int y = right; y >= left; y--) {
                result.add(matrix[down][y]);
                if(result.size() == size)
                    break;
            }
            if(result.size() == size)
                break;
            down--;
            for (int x = down; x >= up; x--) {
                result.add(matrix[x][left]);
                if(result.size() == size)
                    break;
            }
            if(result.size() == size)
                break;
            left++;
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(matrix));
    }
}
