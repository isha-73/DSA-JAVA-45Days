import java.util.Stack;

public class PostfixToInfix {
      public static void main(String[] args) {
        String str="264*8/+3-";
        Stack <String> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int ascii=(int)ch;
            if(ascii>=48 && ascii<=57){
                st.push(ch+"");
            }else{
                String v2=st.pop();
                String v1=st.pop();
                st.push("("+v1+ch+v2+")");
            }
        }
        System.out.println(st.peek());
    }
}
