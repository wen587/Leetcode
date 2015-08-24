// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].


//iterative  smart set
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        if(nums.length < 1) return new ArrayList<List<Integer>>(set);
        list.add(nums[0]);
        set.add(list);
        for(int i=1; i<nums.length; i++) {
            Set<List<Integer>> cur = new HashSet<List<Integer>>();
            for(int j=0; j<=i; j++) {
                for(List<Integer> l : set) {
                    List<Integer> temp = new ArrayList<Integer>(l);
                    temp.add(j, nums[i]);
                    cur.add(temp);
                }
            }
            set = cur;
        }
        return new ArrayList<List<Integer>>(set);
    }
}