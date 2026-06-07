/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode dumNe = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                dumNe.next = new ListNode(list1.val);
                dumNe = dumNe.next;
                list1 = list1.next;
            }
            else{
                dumNe.next = new ListNode(list2.val);
                dumNe = dumNe.next;
                list2=list2.next;
            }
        }
        while(list1!=null){
            dumNe.next = new ListNode(list1.val);
            dumNe = dumNe.next;
            list1 = list1.next;
        }
        while(list2!=null){
            dumNe.next = new ListNode(list2.val);
            dumNe = dumNe.next;
            list2=list2.next;
        }
        return dummy.next;
    }
}