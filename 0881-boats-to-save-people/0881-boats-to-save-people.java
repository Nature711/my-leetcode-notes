class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0, high = people.length - 1, numBoats = 1, currBoatRem = limit, currBoatLoad = 0;
        boolean canAdd = false;
        while (low <= high) {
            canAdd = false;
            if (people[high] <= currBoatRem && currBoatLoad < 2) {
                currBoatRem -= people[high];
                high--;
                currBoatLoad++;
                canAdd = true;
            }
            if (people[low] <= currBoatRem && currBoatLoad < 2) {
                currBoatRem -= people[low];
                low++;
                currBoatLoad++;
                canAdd = true;
            }  
            if (low > high) break;
            if (currBoatRem <= 0 || currBoatLoad == 2 || !canAdd) {
                numBoats++;
                currBoatRem = limit;
                currBoatLoad = 0;
            }
        }
        return numBoats;
    }
}