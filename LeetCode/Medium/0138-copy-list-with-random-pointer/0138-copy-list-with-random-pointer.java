/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) {
            return null;
        }
        Node temp=head;
        while(temp!=null) {
            Node newNode=new Node(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=newNode.next;
        }
        temp=head;
        while(temp!=null) {
            temp.next.random=(temp.random!=null)?temp.random.next:null;
            temp=temp.next.next;
        }
        Node copyHead=head.next;
        Node curr=head;
        Node copy=copyHead;
        while(curr!=null) {
            curr.next=curr.next.next;
            if(copy.next!=null) {
                copy.next=copy.next.next;
            }
            curr=curr.next;
            copy=copy.next;
        }
        return copyHead;
    }
}