class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    // <-least used  most recent ->
    int capacity;
    HashMap<Integer, ListNode> cacheMap; // key -> node
    // doubly linked list
    ListNode left; // before the least recently used node
    ListNode right; // after the most recently used node

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>(capacity);
        // dummy nodes   
        this.left = new ListNode(0,0);
        this.right = new ListNode(0,0); 
        // connect nodes to form list
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(ListNode node){
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insert(ListNode node){
        ListNode lastRecent = this.right.prev;
        lastRecent.next = node;
        node.prev = lastRecent;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            // get value and then move to most recent side
            ListNode node = cacheMap.get(key); // gets node
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            remove(cacheMap.get(key));
        }
        ListNode node = new ListNode(key,value);
        cacheMap.put(key, node); // insert into hashmap
        insert(node); // insert in linked list

        if(cacheMap.size() > capacity){
            ListNode lru = this.left.next;
            remove(lru); // remove from linked list
            cacheMap.remove(lru.key); // remove from hashmap
        } 

    }
}
