class Solution {
public:
    bool isAnagram(string s, string t) {
        int freq1[26]={0};
        int freq2[26]={0};

        for(int i=0;i<s.length();i++){
            freq1[s[i]-'a']++;
        }

        for(int i=0;i<t.length();i++){
            freq2[t[i]-'a']++;
        }

        for(int i=0;i<26;i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }

        if(s.length() != t.length()){
            return false;
        }else{
            return true;
        }
    }
};