import java.util.Stack;

class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int insertion = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(ch);
            }
            else {  // ch == ')'
                
                // Case 1: we found "))"
                if(i + 1 < s.length() && s.charAt(i + 1) == ')'){
                    
                    if(!st.isEmpty()){
                        st.pop();     
                    } else {
                        insertion++;  
                    }
                    i++;  
                }

                else {
                    insertion++;  
                    
                    if(!st.isEmpty()){
                        st.pop(); 
                    } else {
                        insertion++;  
                    }
                }
            }
        }

        insertion += st.size() * 2;

        return insertion;
    }
}
