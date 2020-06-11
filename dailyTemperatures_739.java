import java.util.Stack;

class dailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        int l = T.length;
        int[] res = new int[l];
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < l; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node(T[i], i));
                continue;
            }
            while (!stack.isEmpty() && T[i] > stack.peek().getKey()) {
                Node cur = stack.pop();
                res[cur.getValue()] = i - cur.getValue();
            }
            stack.push(new Node(T[i], i));
        }
        return res;
    }

    private class Node{
        private int key;
        private int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }
}
//寻址思想，不需要维护node
// class Solution {
//     public int[] dailyTemperatures(int[] T) {
//         int length = T.length;
//         int[] ans = new int[length];
//         Deque<Integer> stack = new LinkedList<Integer>();
//         for (int i = 0; i < length; i++) {
//             int temperature = T[i];
//             while (!stack.isEmpty() && temperature > T[stack.peek()]) {
//                 int prevIndex = stack.pop();
//                 ans[prevIndex] = i - prevIndex;
//             }
//             stack.push(i);
//         }
//         return ans;
//     }
// }
