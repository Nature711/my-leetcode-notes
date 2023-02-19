import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        
        BigInteger aa = new BigInteger(a, 2);
        BigInteger bb = new BigInteger(b, 2);
        BigInteger sum = aa.xor(bb);
        BigInteger carry = aa.and(bb).shiftLeft(1);
        
        while (!carry.equals(BigInteger.ZERO)) {
            BigInteger temp = sum;
            sum = sum.xor(carry);
            carry = temp.and(carry).shiftLeft(1);
        }
        
        return sum.toString(2);
    }
}