/*
 * Given an unsorted array, find the maximum difference 
 * between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative 
 * integers and fit in the 32-bit signed integer range.
 */


// 因此要调整一下思路，我原来的方法相当于先做了一个“计数排序”，这种特殊的排序方法使得
// 线性时间复杂度成为可能，还有一些排序方法也具备接近线性时间复杂度的，比如基数排序，
// 比如桶排序，这些思路从实质上说起来有很多类似的地方。我下面采用类似基数排序的思路，
// 由于所有数值都不会超过十位数，因此构建一棵树，每个非叶子节点都有10个子节点（十叉树
// ），从根节点开始，每深一层（深度从0开始算起），从根到叶子路径上位于第i层的节点就是
// 从最高位开始数第i位数值的表示。比如123可表示为0000000123，进而表示为这样的从根到
// 叶子节点的路径：
// root – nexts[0] - nexts[0] - nexts[0] - nexts[0] - nexts[0] - nexts[0]
//  - nexts[0] - nexts[1] - nexts[2] – value: 123

// 在这种方式下，空间复杂度和入参数组的长度是线性相关的，时间复杂度也是（因为树的深度
// 只有10）。注意代码中Item节点里面的nextIndex的作用，这个指的是在求max gap的过程
// 中，我实际做的是深度优先遍历，因此需要一个stack保存前一层节点访问的状态，而这个ne
// xtIndex表示的是该节点再出栈时应该访问第几个孩子节点了。


class Item {
    Item[] nexts = new Item[10];
    Integer val = null;
    int nextIndex = 0;
}
public class Solution {
    public int maximumGap(int[] num) {
 
        Item head = new Item();
 
        // build tree
        for (int i = 0; i < num.length; i++) {
            // 0~2147483647
            Item node = head;
            int n = num[i];
 
            for (int j = 1000000000; j >= 1; j = j / 10) {
                int digit = n / j;
                n = n % j;
 
                if (node.nexts[digit] == null)
                    node.nexts[digit] = new Item();
 
                node = node.nexts[digit];
 
                if (j == 1)
                    node.val = num[i];
            }
        }
 
        Stack<Item> stack = new Stack<Item>();
        stack.push(head);
        Integer last = null;
        int maxGap = 0;
        Item node = null;
 
        // calculate gaps, DFS
        while (!stack.isEmpty()) {
            if (node == null)
                node = stack.pop();
 
            if (node.val != null) {
                if (last != null)
                    maxGap = Math.max(maxGap, node.val - last);
 
                last = node.val;
                node = null;
            } else {
                int index = node.nextIndex;
                if (index != 9) {
                    node.nextIndex++;
                    stack.push(node);
                }
                node = node.nexts[index];
            }
        }
 
        return maxGap;
    }
}

//桶排序
public class Solution {
    public int maximumGap(int[] num) {
        if (num.length < 2)
            return 0;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int value : num) {
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);
        }
        double w = (double) (maxValue - minValue) / (num.length + 1);
        int[][] bucket = new int[2][num.length + 1];
        Arrays.fill(bucket[0], minValue);
        Arrays.fill(bucket[1], maxValue);
        for (int value : num) {
            int k = (int) Math.floor((value - minValue) / w);
            if (k == num.length + 1)
                k--;
            bucket[0][k] = Math.max(bucket[0][k], value);
            bucket[1][k] = Math.min(bucket[1][k], value);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1, j = 0; i < num.length + 1; i++) {
            if (bucket[0][i] != minValue) {
                result = Math.max(result, bucket[1][i] - bucket[0][j]);
                j = i;
            }
        }
        return result;
    }
}