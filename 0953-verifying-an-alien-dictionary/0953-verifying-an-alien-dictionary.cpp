class Solution {
public:
    std::unordered_map<char, int> map; 
    bool isAlienSorted(vector<string>& words, string order) {
        for (int i = 0; i < order.size(); i++) {
            map[order[i]] = i;
        }
        for (int i = 0; i < words.size() - 1; i++) {
            if (!isSmaller(words[i], words[i + 1])) return false;
        }
        return true;
    }
    
    bool isSmaller(string& word1, string& word2) {
        int end = min(word1.length(), word2.length());
        for (int i = 0; i < end; i++) {
            int o1 = map.at(word1[i]);
            int o2 = map.at(word2[i]);
            if (o1 < o2) return true;
            if (o1 > o2) return false;
        }
        if (word1.length() > word2.length()) return false;
        return true;
    }
};