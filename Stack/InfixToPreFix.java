import java.util.*;

public class InfixToPreFix  {
    public static void main(String[] args) {
        String str="9-(5+3)*4/6";
        Stack <Character> op=new Stack<>();
        Stack <String> val=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int ascii=(int)ch;
            if(ascii>=48 && ascii<=57){
              String s =" "+ch;
                val.push(s);
            }else if(op.size()==0 || ch=='(' || op.peek()=='('){
                        op.push(ch);
            }
            else if(ch==')'){
                while(op.peek()!='('){
                    String v2=val.pop();
                    String v1=val.pop();
                    char o=op.pop();
                    String t = o+v1+v2;
                    val.push(t);
                }
                op.pop(); //to remove the opening bracket
            }
            else{
                if(ch=='+' || ch=='-'){
                         String v2=val.pop();
                    String v1=val.pop();
                    char o=op.pop();
                    String t = o+v1+v2;
                    val.push(t);
                        //in case of + and -  we can operate on the top two values 
                       
            }
            if(ch=='*' || ch=='/'){
                if(op.peek()=='*' || op.peek()=='/'){
                     String v2=val.pop();
                    String v1=val.pop();
                    char o=op.pop();
                    String t = o+v1+v2;
                    val.push(t);
                }else{
                    op.push(ch);
                }
            } 
        }

    }
    while(op.size()!=0){
        String v2=val.pop();
                    String v1=val.pop();
                    char o=op.pop();
                    String t = o+v1+v2;
                    val.push(t);
    }
    System.out.println(val.peek());
}

}


