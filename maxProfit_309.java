/**
 * 
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:
输入: [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */

//dp
class maxProfit_309 {
    //变量版本，节省空间
    public int maxProfit(int[] prices) {
        // if (prices.length < 2) {
        //     return 0;
        // }
        // int hold = -prices[0];
        // int nothing = 0;
        // int freezing = Integer.MIN_VALUE;


        int hold = Integer.MIN_VALUE;
        int nothing = 0;
        int freezing = 0;
        for (int p :prices) {
            int pre_hold = hold;
            hold = Math.max(hold, nothing-p);
            nothing = Math.max(nothing, freezing);
            freezing = pre_hold + p;
        }
        return Math.max(freezing, nothing);
    }
    //数组版本
    // public int maxProfit(int[] prices) {
    //     if (prices.length < 2) {
    //         return 0;
    //     }
    //     int[] hold = new int[prices.length];
    //     int[] nothing = new int[prices.length];
    //     int[] freezing = new int[prices.length];
    //     hold[0] = -prices[0];
    //     nothing[0] = 0;
    //     freezing[0] = Integer.MIN_VALUE;
    //     for (int i = 1; i < prices.length; i++) {
    //         hold[i] = Math.max(hold[i-1], nothing[i-1]-prices[i]);
    //         freezing[i] = hold[i-1] + prices[i];
    //         nothing[i] = Math.max(nothing[i-1], freezing[i-1]);
    //     }
    //     return Math.max(freezing[prices.length-1], nothing[prices.length-1]);
    // }
}