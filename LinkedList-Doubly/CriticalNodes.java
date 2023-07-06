class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int []ans=new int [2];
        ans[0]=Integer.MAX_VALUE;;
        ans[1]=Integer.MIN_VALUE;;

        ArrayList <Integer> cric=new ArrayList<>();
        ListNode prev=null;
        ListNode curr=head;
        ListNode after=null;
        int count=0;
        while(curr!=null){
        after=curr.next;
        if(prev!=null && after!=null){
            if( (curr.val>prev.val && curr.val>after.val)
             || (curr.val<prev.val && curr.val<after.val)){

                cric.add(count);

            }
        }
            prev=curr;
            curr=after;
            count++;
        }

        if(cric.size()<2){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
            }

       
        System.out.println(cric);
      

        for(int i=0;i<cric.size()-1;i++){
             int distance = cric.get(i + 1) - cric.get(i);
            ans[0] = Math.min(ans[0], distance); // Update minDistance
            
        }
        ans[1]=cric.get(cric.size()-1)-cric.get(0);
        return ans;

    }
}
