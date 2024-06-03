class MyHashMap {

    private static final CAPACITY = 1000000;
    private int[] keys;
    private int[] values;


    public MyHashMap() {
        keys = new int[CAPACITY];
        values = new int[CAPACITY];
        Arrays.fill(keys, -1); // -1 來標記 empty
    }

    public void put(int key, int value) {
        int index = hash(key);
        keys[index] = key;
        values[index] = value;
    }

    public int get(int key) {
        int index = hash(key);
        if (keys[index] == key) {
            return values[index];
        } else {
            return - 1
        }
    }

    public void remove(int key) {
        int index = hash(key);
        if (keys[index] == key) {
            keys[index] = -1;
            values[index] = 0;
        }
    }

    public void hash(int key) {
        return key % CAPACITY;
    }
}














































/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */