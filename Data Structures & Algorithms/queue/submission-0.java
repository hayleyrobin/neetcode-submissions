class Node{
    int val;
    Node next;
    Node prev;
    Node(int value){val = value; next=null; prev=null;}
}
class Deque {
    Node head;
    Node tail;
    public Deque() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        if(head.next == tail) return true;
        return false;    
    }

    public void append(int value) {
       Node newNode = new Node(value);
       Node lastNode = tail.prev; // ref last node before dummynode

       lastNode.next = newNode; //  make new last node
       newNode.prev = lastNode; // point to previous last node
       newNode.next = tail; // point to dummynode
       tail.prev = newNode; // refer to new last node
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
       Node firstNode = head.next; // ref first node after dummynode

       firstNode.prev = newNode; // make new first node
       newNode.next = firstNode;// point to previous head node
       newNode.prev = head; // point to dummy head node
       head.next = newNode;// refer to new head node
        
    }

    public int pop() {
        // if empty
        if(isEmpty() ) return -1;
        
        Node targetNode = tail.prev; // ref last node
        int value = targetNode.val;

        Node prevNode = targetNode.prev; // get node before last
        prevNode.next = tail; // new last node before dummynode
        tail.prev = prevNode; // point to new last node

        return value;
    }

    public int popleft() {
        // if empty
        if(isEmpty() ) return -1;
        
        Node targetNode = head.next; // ref first node
        int value = targetNode.val;

        Node nextNode = targetNode.next; // get node before last
        nextNode.prev = head; // new last node before dummynode
        head.next = nextNode; // point to new last node

        return value;
        
    }
}
