class MyLinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data=data;
        }
    }
    Node head;
    int size;
    public MyLinkedList() {
        head=null;
        size=0;
    }
    
    public int get(int index) {
        if(head==null || index<0 || index>=size) {
            return -1;
        }
        int count=0;
        Node temp=head;
        while(count!=index) {
            temp=temp.next;
            count++;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        Node newNode=new Node(val);
        newNode.next=head;
        head=newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode=new Node(val);
        if(head==null) {
            head=newNode;
        }
        else {
            Node temp=head;
            while(temp.next!=null) {
                temp=temp.next;
            }
            temp.next=newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>size) {
            return;
        }
        if(index==0) {
            addAtHead(val);
            return;
        }
        int count=0;
        Node temp=head;
        Node newNode=new Node(val);
        while(count<index-1) {
            temp=temp.next;
            count++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(head==null || index<0 || index>=size) {
            return;
        }
        if(index==0) {
            head=head.next;
        }
        else {
            int count=0;
            Node temp=head;
            while(count<index-1) {
                temp=temp.next;
                count++;
            }
            temp.next=temp.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */