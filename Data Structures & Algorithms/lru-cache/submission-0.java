class LRUCache {

    private int capacity;
    private Map<Integer,Node> cache;
    Node head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        Node headNext = this.head.next;
        node.prev = head;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
    }

    public int get(int key) {
        // check if the element is present in the cache
            // if present then move the node to the head
            // return the value
            // else - return -1

        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //check if present in the cache
            // if present - update the value and move it to the head
            // else add it to the cache at the front
        //check the capacity - if exceeds - then remove the element from the tail

        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node node = new Node(key,value);
        cache.put(key,node);
        insert(node);
        if(cache.size()>capacity){
            Node lru = this.tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
        return;        
    }
}
class Node{
    Node next,prev;
    int key,val;
    Node(int key, int val){
        this.val = val;
        this.key = key;
        this.prev=null;
        this.next=null;
    }
}