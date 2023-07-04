/**
 * url: https://leetcode.com/problems/merge-two-sorted-lists
 * Approach : Without using extra space
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list2;

        ListNode head=new ListNode();
        ListNode temp=head;

        while(temp1!=null && temp2!=null){

            if(temp1.val<temp2.val){
                temp.next=temp1;
                temp=temp1;
                temp1=temp1.next;
            }else{
                 temp.next=temp2;
                temp=temp2;
                temp2=temp2.next;
            }
          
        }

        if(temp1==null){
            temp.next=temp2;
        }else{
            temp.next=temp1;
        }

        return head.next;
    }
}
/**
 * Approach : Using extra space
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list2;

        ListNode head=new ListNode();
        ListNode temp=head;

        while(temp1!=null && temp2!=null){

            if(temp1.val>temp2.val){
                ListNode n = new ListNode(temp2.val);
                temp.next=n;
                temp=n;
                temp2=temp2.next;
            }else{
                ListNode n = new ListNode(temp1.val);
                temp.next=n;
                temp=n;
                temp1=temp1.next;
            }
        }

        if(temp1==null){
            temp.next=temp2;
        }else{
            temp.next=temp1;
        }

        return head.next;
    }
}