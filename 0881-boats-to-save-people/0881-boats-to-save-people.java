class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0, high = people.length - 1, numBoats = 0, currBoatRem = 0, currBoatLoad = 0;
       
        while (low <= high) {
            if (currBoatRem < people[low] || currBoatLoad == 2) {
                numBoats++;
                currBoatRem = limit;
                currBoatLoad = 0;
            }
            
            if (people[high] <= currBoatRem) {
                currBoatRem -= people[high];
                high--;
                currBoatLoad++;
            }
            
            if (people[low] <= currBoatRem) {
                currBoatRem -= people[low];
                low++;
                currBoatLoad++;
            }  
        }
        return numBoats;
    }
}