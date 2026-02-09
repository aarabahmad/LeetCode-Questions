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
    public int findGCD(int num1, int num2) {
        int divisor;
        int dividend;
        if(num1>num2) {
            dividend=num1;
            divisor=num2;
        }
        else {
            divisor=num1;
            dividend=num2;
        }
        int rem=-1;
        while(rem!=0) {
            rem=dividend%divisor;
            dividend=divisor;
            divisor=rem;
        }
        return dividend;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp1=head;
        ListNode temp2=head.next;
        while(temp2!=null) {
            int gcd=findGCD(temp1.val, temp2.val);
            ListNode node=new ListNode(gcd);
            temp1.next=node;
            node.next=temp2;
            temp1=temp1.next.next;
            temp2=temp2.next;
        }
        return head;
    }
}