import java.util.Stack;

class Solution { //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder sb= new StringBuilder(s);
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<sb.length();i++){

            char ch= sb.charAt(i);
            if(ch=='('){
                st.push(i);
            }else if(ch==')'){
                if(st.isEmpty()){
                     sb.setCharAt(i, '*');
                }else {
                    st.pop();
                }
            }
        }
        System.out.println(sb);
        System.out.println(st);

        while(!st.isEmpty()){
            int c=st.pop();
            System.out.println(st);
             sb.setCharAt(c, '*');
        }
        return sb.toString().replaceAll("\\*", "");

    }
}