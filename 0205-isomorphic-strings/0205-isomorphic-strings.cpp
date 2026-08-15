class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.length() != t.length()){
            return false;
        }
        vector<int> mapST(256, -1);
        vector<int> mapTS(256, -1);

        for(int i=0;i<s.length();i++){
            if(mapST[s[i]] != -1 && mapST[s[i]] != t[i]){
                return false;
            }
            if(mapTS[t[i]] != -1 && mapTS[t[i]] != s[i]){
                return false;
            }
            mapST[s[i]]=t[i];
            mapTS[t[i]]=s[i];
        }
        return true;
    }
};