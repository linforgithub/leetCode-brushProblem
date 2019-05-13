class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return 0;
        }
        boolean isOutInt = (dividend == Integer.MAX_VALUE || dividend == Integer.MIN_VALUE) && divisor == -1;
        if(isOutInt){
            return Integer.MAX_VALUE;
        }
        int result = 0;
        long dend = dividend > 0 ? dividend : -Long.valueOf(dividend);
        long sor = divisor > 0 ? divisor : -Long.valueOf(divisor);
        if(sor == 1){
            return divisor > 0 ? dividend : - dividend;
        }
        for(int i = 31;i >= 0;i--){
            // 除数除以2的N次方，此时大于被除数，说明结果大于2的N次方
            if((dend >> i) >= sor){
                result += (1 << i);
                dend -= (sor << i);
            }
        }
        return (dividend ^ divisor) >= 0 ? result : -result;
    }
}
