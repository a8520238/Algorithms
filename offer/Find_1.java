/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

package offer;
//二维数组中的查找
//蛇形查找
public class Find_1 {
    public boolean Find(int target, int [][] array) {
        int lenX = array.length;
        int lenY = array[0].length;
        int j = lenY - 1;
        int i = 0;
        while (j >= 0 && i < lenX) {
            if (array[i][j] < target) {
                i++;
            }
            else if (array[i][j] > target) {
                j--;
            }
            else {
                return true;
            }
        }
        return false;
    }
}