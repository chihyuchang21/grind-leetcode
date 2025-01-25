import java.util.HashMap;

class LRUCache {
    // 雙向鏈表的節點類
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private HashMap<Integer, Node> cache; // 用於儲存鍵與節點的映射
    private Node head; // 假頭節點
    private Node tail; // 假尾節點
    private int capacity; // 緩存容量

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0); // 假頭
        tail = new Node(0, 0); // 假尾
        head.next = tail;
        tail.prev = head;
    }

    // 獲取值
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node); // 將該節點移動到鏈表的頭部
            return node.value;
        }
        return -1; // 未找到
    }

    // 插入/更新值
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // 更新值
            moveToHead(node); // 移動到頭部
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode); // 添加到緩存中
            addNode(newNode); // 添加到鏈表頭部
            if (cache.size() > capacity) {
                Node tailNode = removeTail(); // 刪除尾部節點
                cache.remove(tailNode.key); // 從緩存中刪除
            }
        }
    }

    // 將節點添加到頭部
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 移動節點到頭部
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    // 刪除節點
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // 刪除尾部節點
    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}