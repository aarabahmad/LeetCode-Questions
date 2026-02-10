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
    public int getSum(List<Integer> nums, int start, int end) {
        int sum=0;
        for(int i=start+1;i<end;i++) {
            sum+=nums.get(i);
        }
        return sum;
    }
    public ListNode mergeNodes(ListNode head) {
        List<Integer> nums=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null) {
            nums.add(temp.val);
            temp=temp.next;
        }
        System.out.println(nums);
        List<Integer> zero=new ArrayList<>();
        for(int i=0;i<nums.size();i++) {
            if(nums.get(i)==0) {
                zero.add(i);
            }
        }
        System.out.println(zero);
        List<Integer> sums=new ArrayList<>();
        for(int i=1;i<zero.size();i++) {
            sums.add(getSum(nums, zero.get(i-1), zero.get(i)));
        }
        System.out.println(sums);
        ListNode dummy=new ListNode(0);
        ListNode ans=dummy;
        for(int i=0;i<sums.size();i++) {
            dummy.next=new ListNode(sums.get(i));
            dummy=dummy.next;
        } 
        return ans.next;
    }
}