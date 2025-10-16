#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> lastIndex; 
        int maxLen = 0, start = 0;

        for (int end = 0; end < s.length(); ++end) {
            char c = s[end];
            if (lastIndex.find(c) != lastIndex.end()) {
                start = max(start, lastIndex[c] + 1); 
            }
            lastIndex[c] = end; 
            maxLen = max(maxLen, end - start + 1); 
        }

        return maxLen;
    }
};
