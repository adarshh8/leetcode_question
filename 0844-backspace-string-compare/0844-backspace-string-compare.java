import java.util.*;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(!ss.isEmpty()){
                    ss.pop();
                }
            } else {
                ss.push(s.charAt(i));
            }
        }

        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                if(!st.isEmpty()){
                    st.pop();
                }
            } else {
                st.push(t.charAt(i));
            }
        }

        return ss.equals(st);
    }
}
