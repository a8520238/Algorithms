/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
package offer;
//import java.util.ArrayList;
import java.util.Arrays;

public class PrintMinNumber_32 {
    public String PrintMinNumber(int [] numbers) {
        //这种方法不行，因为如果使用比较器 类型必须为T， 即对象
        /*
        Arrays.sort(numbers, ((x, y) -> 
                   Integer.parseInt(String.valueOf(x) + String.valueOf(y)) -
                   Integer.parseInt(String.valueOf(y) + String.valueOf(x))));
        StringBuffer buffer = new StringBuffer();
        for (int n : numbers) {
            buffer.append(n);
        }
        return buffer.toString();*/
        //使用流方法
        StringBuffer buffer = new StringBuffer();
        Arrays.stream(numbers).boxed().map(x -> x.toString()).sorted((x, y) -> 
                (x + y). compareTo(y + x)).forEach(x -> buffer.append(x));
        return buffer.toString();
    }
}