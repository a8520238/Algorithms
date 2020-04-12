/**
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。

要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。

 

示例 1：

输入：
line1 = {0, 0}, {1, 0}
line2 = {1, 1}, {0, -1}
输出： {0.5, 0}
 * 
 */
//考察coding

/*
题解上说 这种办法可以考虑任意直线， 不用写那么多判断了
对于「参数方程式」，它可以表示任意的直线，并且它非常适合用于表示线段。假设我们给定两个点 (x1,y1)(x_1, y_1)(x1​,y1​) 以及 (x2,y2)(x_2, y_2)(x2​,y2​)，我们只需要令：
{x=x1+t(x2−x1)y=y1+t(y2−y1)\begin{cases}
x = x_1 + t(x_2 - x_1) \\
y = y_1 + t(y_2 - y_1)
\end{cases}
{x=x1​+t(x2​−x1​)y=y1​+t(y2​−y1​)​
并且将 ttt 限制在 [0,1][0, 1][0,1] 的范围内，就可以表示端点为 (x1,y1)(x_1, y_1)(x1​,y1​) 以及 (x2,y2)(x_2, y_2)(x2​,y2​) 的线段，十分方便。


因此，使用「参数方程式」表示线段是最适合本题的。在下面的题解中，我们会给出使用「参数方程式」解决本题的方法。

**/

class intersection_face_16_03 {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = 0, x2 = 0, x3 = 0, x4 = 0, y1 = 0, y2 = 0, y3 = 0, y4 =0;
        if (start1[0] > end1[0]) {
            x1 = end1[0]; x2 = start1[0];
            y1 = end1[1]; y2 = start1[1];
        } else if (start1[0] == end1[0]){
            if (start1[1] > end1[1]) {
                x1 = end1[0]; x2 = start1[0];
                y1 = end1[1]; y2 = start1[1];
            } else {
                x2 = end1[0]; x1 = start1[0];
                y2 = end1[1]; y1 = start1[1];
            }
        } else {
            x2 = end1[0]; x1 = start1[0];
            y2 = end1[1]; y1 = start1[1];
        }
        if (start2[0] > end2[0]) {
            x3 = end2[0]; x4 = start2[0];
            y3 = end2[1]; y4 = start2[1];
        } else if (start2[0] == end2[0]) {
            if (start2[1] > end2[1]) {
                x3 = end2[0]; x4 = start2[0];
                y3 = end2[1]; y4 = start2[1];
            } else {
                x4 = end2[0]; x3 = start2[0];
                y4 = end2[1]; y3 = start2[1];
            }
        } else {
            x4 = end2[0]; x3 = start2[0];
            y4 = end2[1]; y3 = start2[1];
        }
        // int x1 = Math.min(start1[0], end1[0]), x2 = Math.max(start1[0], end1[0]);
        // int y1 = Math.min(start1[1], end1[1]), y2 = Math.max(start1[1], end1[1]);
        // int x3 = Math.min(start2[0], end2[0]), x4 = Math.max(start2[0], end2[0]);
        // int y3 = Math.min(start2[1], end2[1]), y4 = Math.max(start2[1], end2[1]);
        double err = 10e-6;
        double[] res = new double[0];
        if (x2 == x1 && x3 == x4) {
            if (x1 == x3) {
                if (y3 - y2 > err || y1 - y4 > err) {
                    // System.out.println("ok");
                    // System.out.println(x1 + "," + x2 + "," + x3 + "," + x4);
                    // System.out.println(y1 + "," + y2 + "," + y3 + "," + y4);
                    return res;
                } else {
                    return y3 > y1? new double[] {x3, y3}: new double[] {x1, y1};
                }
            } else {
                return res;
            }
        } else if (x2 == x1 || x3 == x4) {
            if (x3 == x4) {
                int temp = x1;
                x1 = x3;
                x3 = temp;
                temp = x2;
                x2 = x4;
                x4 = temp;
                temp = y1;
                y1 = y3;
                y3 = temp;
                temp = y2;
                y2 = y4;
                y4 = temp;
            }
            
            if (x1 > x4 || x2 < x3) {
                return res;
            }
            double k = (double)(y4 - y3) / (x4 - x3);
            double b = y3 - x3 * k;
            double x0 = x1;
            double y0 = k * x0 + b;
            // System.out.println((double)(y4 - y3) / (x4 - x3) + k);
            // System.out.println(x1 + "," + x2 + "," + x3 + "," + x4);
            // System.out.println(y1 + "," + y2 + "," + y3 + "," + y4);

            if (y0 < y1 || y0 > y2) {
                return res;
            }
            return new double[]{x0, y0};
        }

        double k1 = (double)(y2 - y1) / (x2 - x1);
        double k2 = (double)(y4 - y3) / (x4 - x3);
        double b1 = y1 - x1 * k1;
        double b2 = y3 - x3 * k2;
        // System.out.println(b2 + "," + k2 + "," + b1 + "," + k1);
        // System.out.println(k2 - k1);
        if (Math.abs(k2 - k1) < err) {
            System.out.println("ok");
            if (x3 * k1 + b1 - y3 < err || k1 - 0 < err) {
                if (x3 - x2 > err || x1 - x4 > err) {
                    return res;
                } else {
                    return x3 > x1? new double[] {x3, y3}: new double[] {x1, y1};
                    // if (x3 - x1 < err) {
                    //     return y3 > y1? new double[] {x3, y3}: new double[] {x1, y1};
                    // } else {
                    //     return x3 > x1? new double[] {x3, y3}: new double[] {x1, y1};
                    // }
                }
            }
            else {
                return res;
            }
        }
        else {
            //System.out.println(b2 + "," + k2 + "," + b1 + "," + k1);
            double x0 = (b2 - b1) / (k1 - k2);
            double y0 = k1 * (b2 - b1) / (k1 - k2) + b1;
            if (x0 >= x1 && x0 <= x2 && x0 >= x3 && x0 <= x4) {
                return new double[]{x0, y0};
            }
        }
        return res;
    }
}