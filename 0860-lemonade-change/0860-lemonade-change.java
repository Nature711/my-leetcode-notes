class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        
        HashMap<Integer, Integer> wallet = new HashMap<>();
        
        for (int bill: bills) {
            wallet.put(bill, wallet.getOrDefault(bill, 0) + 1);
            int change = bill - 5;
             System.out.println(change);
             System.out.println(wallet);
            if (change == 0) continue;
            if (change == 15) {
                if (wallet.containsKey(5) && wallet.get(5) > 0) {
                    
                    if (wallet.containsKey(10) && wallet.get(10) > 0) {
                        wallet.put(5, wallet.get(5) - 1);
                        wallet.put(10, wallet.get(10) - 1);
                    } else if (wallet.get(5) > 2) wallet.put(5, wallet.get(5) - 3);
                    else return false;
                } else return false;
            } else {
                if (wallet.containsKey(change) && wallet.get(change) > 0) {
                    wallet.put(change, wallet.get(change) - 1);
                } else return false;
            }
         
           
        }
        
        return true;
    }
}