/*
Create dummy head node to simplify edge cases like:
    1. inserting at beginning or deleting 1st element
    2. dummy head always exists, so never has to handle null head pointer
Track Size to quickly validate indices WITHOUT travsering entire list
*/
class ListNode {
    int value;
    ListNode next;
    ListNode(int value){
        this.value = value;
        this.next = null;
    }
}
class MyLinkedList {
    ListNode head;
    int size;
    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }
    
    public int get(int index) {
        if(index >= size) return -1;
        ListNode current = head.next; // actual head not dummy head
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.value;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next; // actual head not dummy head
        head.next = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode curNode = head;
        while(curNode.next != null){ // get to last node before null
            curNode = curNode.next;
        }
        curNode.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        ListNode cur = head;
        // go to node just before index (starting from dummy node)
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        ListNode cur = head; // at dummy node

        // traverse List
        for(int i = 0; i < index; i++){ // node right before target
            cur = cur.next;
        }
        cur.next = cur.next.next;
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