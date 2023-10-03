class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        unordered_map<int, int> map;
        for (int num: nums) {
            if (map.count(num) == 0) map[num] = 0;
            map[num]++;
        }
        int res = 0;
        for (auto& p: map) {
            res += p.second * (p.second - 1) / 2;
        }
        return res;
    }
};