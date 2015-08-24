/*
 * Implement pow(x, n).
 */


public class Solution {
    public double pow(double x, int n) {
        if(n == 0) return 1;
        
        double half = pow(x, n/2);
        double res = half * half;
        if(n % 2 != 0) {
            if(n > 0) res *= x;
            else res /= x;
        }
        return res;
    }
}

//elegant
public double pow(double x, int n) {
  double result = 1.0;
  for(int i = n; i != 0; i /= 2, x *= x) {
      if( i % 2 != 0 ) {
          result *= x;
      }
  }
  return n < 0 ? 1.0 / result : result;
}