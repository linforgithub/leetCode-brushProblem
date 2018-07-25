class Solution {
    public int reverse(int x) {
        long result = 0;
        int base = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while (x > 0) {
        	result = result * 10 + x % 10;
			x = x / 10;
		}
        if(result > Integer.MAX_VALUE){
        	return 0;
        }
		
		return (int) (result * base);
    }
}
