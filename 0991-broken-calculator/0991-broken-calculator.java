class Solution {
    
    HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int brokenCalc(int startValue, int target) {
        
        if (target <= startValue) return startValue - target; 
        
        if (target % 2 == 0) return 1 + brokenCalc(startValue, target / 2);
        
        return 1 + brokenCalc(startValue, target + 1);
    }
}