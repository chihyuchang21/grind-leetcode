/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

class MyHashSet {

    private int[] data;
    private int capacity;

    /** Initialize your data structure here. */
    public MyHashSet() {
        capacity = 1000001; // 設置容量為 1000001，這是因為題目給定了鍵的範圍是 0 到 1000000
        data = new int[capacity];
    }

    public void add(int key) {
        data[hash(key)] = key + 1; // 將鍵值設置為 key + 1，這樣可以區別是否存在該鍵
    }

    public void remove(int key) {
        data[hash(key)] = 0; // 將鍵值設置為 0，表示該位置沒有任何鍵
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return data[hash(key)] != 0; // 如果鍵值不為 0，則表示存在該鍵
    }

    private int hash(int key) {
        return key % capacity; // 簡單的哈希函數，將鍵值對容量取模
    }
}


