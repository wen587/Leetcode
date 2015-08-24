/*
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b 
 * <= c)
 * The solution set must not contain duplicate triplets.
 *   For example, given array S = {-1 0 1 2 -1 -4},
 *   A solution set is:
 *   (-1, 0, 1)
 *   (-1, -1, 2)
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<>();
        if (num.length<3)
            return list;
             
        Arrays.sort(num);
         
        for (int i=0; i<num.length-2; i++) {
            if(i!=0 && num[i]==num[i-1])
                continue;
                 
            int left = i+1;
            int right = num.length-1;
            while (left<right) {
                if (left>i+1 && num[left]==num[left-1]) {
                    left++;
                    continue;
                }
                if (right<num.length-1 && num[right]==num[right+1]) {
                    right--;
                    continue;
                }
                 
                int sum = num[i] + num[left] + num[right];
                if (sum==0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(num[i]);
                    item.add(num[left]);
                    item.add(num[right]);
                    list.add(item);
                     
                    left++;
                    right--;
                } else if (sum>0) {
                    right--;
                } else {
                    left++;
                }
            } // while
        } // for
         
        return list;
    }
}

//I love this one
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; ++i) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			
			int j = i + 1;
			int k = num.length - 1;

			while (j < k) {
				if (num[i] + num[j] + num[k] > 0) {
					--k;
				} else if (num[i] + num[j] + num[k] < 0) {
					++j;
				} else {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[j]);
					tmp.add(num[k]);

					result.add(tmp);
					
					--k;
					++j;
					
					while (j < k && num[j] == num[j - 1]) {
						++j;
					}
					while (j < k && num[k] == num[k + 1]) {
						--k;
					}
				}
			}
		}

		return result;
    }
}