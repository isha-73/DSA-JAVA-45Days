import java.util.Stack;

public class PostFixToPrefix {
        public static void main(String[] args) {
        Stack <String> st=new Stack<>();
        String str="264*8/+3-";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int ascii=(int)ch;
            if(ascii>=48 && ascii<=57){
                st.push(ch+"");
            }else{
                
                String v2=st.pop();
                String v1=st.pop();
                st.push(ch+v1+v2);
            }
        }
        System.out.println(st.peek());
    }
}
