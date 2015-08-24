// Given a collection of numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

//iterative 
// Then, 2 can be added in front or after 1. So we have to copy the List 
// in answer (it's just {1}), add 2 in position 0 of {1}, then copy the 
// original {1} again, and add 2 in position 1. Now we have an answer of
 // {{2,1},{1,2}}. There are 2 lists in the current answer.

// Then we have to add 3. first copy {2,1} and {1,2}, add 3 in position
 // 0; then copy {2,1} and {1,2}, and add 3 into position 1, then do the
  // same thing for position 3. Finally we have 2*3=6 lists in answer,
   // which is what we want.
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 1) return res;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        res.add(list);
        for(int i=1; i<nums.length; i++) {
            List<List<Integer>> cur = new ArrayList<List<Integer>>();
            for(int j=0; j<=i; j++) {
                for(List<Integer> l : res) {
                    List<Integer> newList = new ArrayList<Integer>(l);
                    newList.add(j, nums[i]);
                    cur.add(newList);
                }
            }
            res = cur;
        }
        return res;
    }
}