class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        vector<vector<int>> intervals;
        bool left_covered = false, right_covered = false;
        for (int i = 0; i < ranges.size(); i++) {
            int left = max(0, i - ranges[i]);
            int right = min(n,  i + ranges[i]);
            intervals.push_back({left, right});
            if (left == 0) left_covered = true;
            if (right == n) right_covered = true;
        }
        if (!left_covered || !right_covered) return -1;
        
        sort(intervals.begin(), intervals.end(), [](auto& i1, auto& i2) {
            if (i1[0] - i2[0] != 0) return i1[0] < i2[0];
            else {
                return (i1[1] - i1[0]) > (i2[1] - i2[0]);
            }
        });
        
        //for (auto& v: intervals) cout << v[0] << " " << v[1] << endl;
        
        int curr_end = intervals[0][1], num_intervals = 1;
        int i = 1;
        
        while (i < intervals.size() && curr_end < n) {
            int new_end = curr_end;
            while (i < intervals.size() && intervals[i][0] <= curr_end) {
                new_end = max(new_end, intervals[i][1]);
                i++;
            }   
            if (curr_end == new_end) return -1;
            curr_end = new_end;
            num_intervals++;
        }
        
        return curr_end == n ? num_intervals : -1;
    }
};