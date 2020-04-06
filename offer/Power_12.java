
package offer;
public class Power_12 {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        double res = 1.;
        boolean f = false;
        if (exponent < 0) {
            exponent = -exponent;
            f = true;
        }
        
        while (exponent > 1) {
            if (exponent % 2 == 1) {
                res *= base;
                exponent--;
            }
            base *= base; 
            exponent /= 2;
        }
        
        //下面这种判断条件为exp>0的写法较好， 可以避免判断exponent为0的情况
        // double ans = 1;        
        // while (exp > 0) {            
        //     if ((exp & 1) == 1) {                
        //         ans = ans * base;            
        //     }            
        //     exp >>= 1;            
        //     base *= base;        
        // }        
        // return flag ? 1 / ans : ans;    
        return f? 1/(res*base): res*base;
        //return Math.pow(base, exponent);
  }
  public static void main(String[] args) {
    Power_12 test = new Power_12();
    double res = test.Power(2, -3);
    System.out.println(res);
  }

}