// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)



public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i=1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i=nums.length - 1; i>=0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}

//if no restriction had
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> re;
        long mul=1;
        int zeroNum = 0;

        for(int i=0; i < nums.size(); i++)
        {
            if(nums[i] != 0) mul *= nums[i];
            else zeroNum++;
        }

        for(int i = 0; i < nums.size(); i++)
        {
            if(zeroNum > 1) re.push_back(0);
            else if(zeroNum == 1)
            {
                if(nums[i] == 0) re.push_back(mul);
                else re.push_back(0);
            }
            else 
                re.push_back(mul/nums[i]);
        }
        return re;
    }
};