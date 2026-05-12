class LinkedNode{
    int val;
    LinkedNode next;
    LinkedNode(){val=-1; next = null;}
    LinkedNode(int value) { val = value; next = null;}
}
class LinkedList {
    private LinkedNode head; // Dummy Node
    private LinkedNode tail;
    public LinkedList() {
        head = new LinkedNode(-1);
        tail = this.head;
    }

    public int get(int index) {
       LinkedNode cur = head.next;
       while(cur!=null && index != 0){
            cur = cur.next;
            index--;
       }
       if(cur != null && index == 0){
        return cur.val;
       }
       return -1;
    }

    public void insertHead(int val) {
        LinkedNode newNode = new LinkedNode(val);
        newNode.next = head.next; //1st node after dummynode
        head.next = newNode;
        if (newNode.next == null) {  // If list was empty before insertion
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        LinkedNode newNode = new LinkedNode(val);
        tail.next = newNode; //last node
        tail = tail.next;
    }

    public boolean remove(int index) {
        LinkedNode cur = head; // at dummy node
        int i=0;
        while(i < index && cur != null) {
            i++;
            cur= cur.next;
        }
        if(cur!=null && cur.next != null){ //if prev & index node existsa
            if (cur.next == tail){ // if index node is last node
                 tail = cur; // make previous the last node
            } 
            cur.next = cur.next.next; // previous node point to index's next node
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> nums = new ArrayList<>();

        LinkedNode cur = head.next;
        while(cur != null){
            nums.add(cur.val);
            cur = cur.next;
        }
        return nums;
    }
}
