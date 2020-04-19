/**写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。 */
package offer;
public class Add_48 {
    public int Add(int num1,int num2) {
        int add = num1 & num2;
        int ori = num1 ^ num2;
        while (add != 0) {
            int temp = ori & (add << 1);
            ori = ori ^ (add << 1);
            add =temp;
        }
        return ori;
    }
}