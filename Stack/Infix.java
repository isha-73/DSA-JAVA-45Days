import java.util.Stack;

public class Infix {
    public static void main(String[] args) {
        String str="9-(5+3)*4/6";
        Stack <Character> op=new Stack<>();
        Stack <Integer> val=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int ascii=(int)ch;
            if(ascii>=48 && ascii<=57){
                val.push(ascii-48);
            }else if(op.size()==0 || ch=='(' || op.peek()=='('){
                        op.push(ch);
            }
            else if(ch==')'){
                while(op.peek()!='('){
                    int v2=val.pop();
                    int v1=val.pop();
                    if(op.peek()=='+') val.push(v1+v2);
                    if(op.peek()=='-') val.push(v1-v2);
                    if(op.peek()=='*') val.push(v1*v2);
                    if(op.peek()=='/') val.push(v1/v2);
                    op.pop();
                }
                op.pop(); //to remove the opening bracket
            }
            else{
                if(ch=='+' || ch=='-'){
                        int v2=val.pop();
                        int v1=val.pop();
                        if(op.peek()=='+') val.push(v1+v2);
                        if(op.peek()=='-') val.push(v1-v2);
                        if(op.peek()=='*') val.push(v1*v2);
                        if(op.peek()=='/') val.push(v1/v2);
                       
                        op.pop();
                        op.push(ch);
                        //in case of + and -  we can operate on the top two values 
                       
            }
            if(ch=='*' || ch=='/'){
                if(op.peek()=='*' || op.peek()=='/'){
                    int v2=val.pop();
                    int v1=val.pop();
                    if(op.peek()=='*') val.push(v1*v2);
                    if(op.peek()=='/') val.push(v1/v2);
                    op.pop();
                    op.push(ch);
                }else{
                    op.push(ch);
                }
            } 
        }

    }
    while(op.size()!=0){
        int v2=val.pop();
        int v1=val.pop();
        if(op.peek()=='+') val.push(v1+v2);
        if(op.peek()=='-') val.push(v1-v2);
        if(op.peek()=='*') val.push(v1 * v2);
        if(op.peek()=='/') val.push(v1/v2);
        op.pop();
    }
    System.out.println(val.peek());
}

}
