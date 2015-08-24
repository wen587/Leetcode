/*
 * There are N gas stations along a circular route, 
 * where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it 
 * costs cost[i] of gas to travel from station i to 
 * its next station (i+1). You begin the journey 
 * with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you 
 * can travel around the circuit once, otherwise 
 * return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */


//O(n) solution
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int res = 0;
        int preCost = 0;
        for(int i=0; i<gas.length; i++) {
            cur = gas[i] - cost[i] + cur;
            if(cur < 0) {
                preCost += cur;
                res = i + 1;
                cur = 0;
            }
        }
        return cur + preCost >= 0 ? res : -1;
    }
}


//O(n^2) slt time exceed
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        for(int i=0; i<gas.length; i++) {
            int sum = 0;
            int j = i;
            for(j = i; j < i + gas.length; j++) {
                int k = j % gas.length;
                sum += gas[k] - cost[k];
                if(sum < 0) break;
            }
            if(j == i + gas.length) {
                res = i;
                return res;
            }
        }
        return res;
    }
}
//time exceed limit
