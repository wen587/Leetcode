/*
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */


// 使用long是因为考虑可能溢出的情况；
// 这题有点恶心的地方在于，要求返回int型，比如当x是2的时候，要求返回1，所以
// while (min <= max)这行就是起这个作用的，当min==max的时候，并不意味着找到
// 	这个数了，如果不符合条件（比如x=2的时候，第二遍循环后min会变成2，max会
// 变成1），这时候离开了while，必须返回max。


//
public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        int l = 1, r = x, res = 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(mid > x/mid) {
                r = mid;
            } else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}
//

public class Solution {
    public int sqrt(int x) {
        long min = 0;
        long max = x/2 + 1;
        while(min<=max) {
            long mid = (min + max) / 2;
            long product = mid * mid;
            if(product == x) return (int) mid;
            else if(product < x) min = mid + 1;
            else max = mid - 1;
        }
        return (int) max;
    }
}