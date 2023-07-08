package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInteger {
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long [] ans = new long [N-K+1];
        Queue <Integer> q = new LinkedList<>();
        
        for(int i=0;i<N;i++){
            if(A[i]<0)
            {q.add(i);}
        }
        
        for(int i=0;i<N-K+1;i++){
            if(q.size()>0 && q.peek()<i) 
                q.remove();
         
            if(q.size()>0 && q.peek()<=i+K-1){
                ans[i]=A[q.peek()];
            }
            else if(q.size()==0){
                ans[i]=0;
            }
            else ans[i]=0;
        }
        return ans;
    }
}
