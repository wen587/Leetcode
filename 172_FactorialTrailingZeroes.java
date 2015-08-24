// My Submissions Question Solution 
// Given an integer n, return the number of trailing zeroes in n!.

// Note: Your solution should be in logarithmic time complexity.


return n/5 == 0 ? 0 : n/5 + trailingZeroes(n/5);