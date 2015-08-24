// Given a sorted integer array without duplicates, return the summary of its ranges.

// For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].


//best
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();
        for(int i=0; i<nums.length; i++) {
            int a = nums[i];
            while(i + 1 < nums.length && (nums[i + 1] - nums[i] == 1)) {
                i++;
            }
            if(a == nums[i]) {
                list.add(a+"");
            } else {
                list.add(a+"->"+nums[i]);
            }
        }
        return list;
    }
    
}

//complicate two pointer
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length < 1) return res;
        if(nums.length == 1) {
            res.add("" + nums[0]);
            return res;
        }
        int l = 0;
        int r = 0;
        for(int i=0; i<nums.length - 1; i++) {
            if(nums[i] + 1 == nums[i + 1]) {
                r++;
            } else {
                if(l == r) {
                    res.add("" + nums[l]);
                    l++; r++;
                }
                else {
                    res.add("" + nums[l] + "->" + nums[r]);
                    r++;
                    l = r;
                }
            }
        }
        if(l == r) res.add("" + nums[nums.length - 1]);
        else {
            res.add("" + nums[l] + "->" + nums[r]);
        }
        return res;
    }
}

//stack
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length < 1) return res;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int cnt = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1) {
                if(i == nums.length - 1) res.add("" + stack.pop() + "->" + nums[i]);
                cnt++;
                continue;
            }
            if(stack.isEmpty()) res.add("" + nums[i]);
            else {
                if(cnt == 1) {
                    res.add("" + nums[i - 1]);
                    stack.pop();
                }  else {
                    res.add("" + stack.pop() + "->" + nums[i - 1]);
                }
                stack.push(nums[i]);
                cnt = 1;
            }
        }
        if(!stack.isEmpty()) res.add("" + stack.pop());
        return res;
    }
}