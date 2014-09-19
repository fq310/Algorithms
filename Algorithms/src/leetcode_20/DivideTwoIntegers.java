package leetcode_20;

public class DivideTwoIntegers {
   public int divide(int dividend, int divisor) {
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        long result=0;
        
        while (a>=b){
            long c=b;
            int i=0;
            while(c<=a){
                a=a-c;
                c=c<<1;
                result+=1<<i;
                i++;
            }
            
        }
        if (dividend<0&&divisor>0||dividend>0&&divisor<0){
            result=-result;
        }
        return (int)result;
    }
    
    public int divide2(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0) return 0;
        boolean isResultNegative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) 
        	isResultNegative = true;
        if (dividend < 0) dividend *= -1;
        if (divisor < 0) divisor *= -1;
        if (dividend < divisor) return 0;
        int buffer = divisor, count = 1;
        while (buffer < dividend) {
        	buffer += divisor;
        	++count;
        }
        if (buffer > dividend) count = count - 1;
        if (isResultNegative) return -1 * count;
        else return count;
    }
}
