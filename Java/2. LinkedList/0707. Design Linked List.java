// Definition
public class ListNode {
    int value;
    ListNode val;

    // No Para
    public ListNode (){
    }

    // 1 Para (value)
    public ListNode (int val) {
        this.val = val;
    }

    // 2 Para (value, next pt)
    public ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}




//單鏈表
class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
        //size儲存element amount
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        //if index illegal, return -1
        if (index < 0 || index > size){
            return - 1;
        }
        ListNode currentNode = head;
        //including first 虛擬ListNode, so search index + 1 node
        for (int i = 0; i <= index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    //在鏈表最前面插入一個節點 = 在第0個元素前添加
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在鏈表最後面插入一個節點 = 在第(末尾+1)個元素前添加
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 個節點之前插入一個新節點，例如 index 為 0，那麼新插入的節點為鏈表的新頭節點。
    // 如果 index 等於鏈表的長度，則說明是新插入的節點為鏈表的尾結點。
    // 如果 index 大於鏈表的長度，則返回空
    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index <  0){
            index = 0;
        }
        size++;
        //找到要插入節點的前驅
        ListNode pred = head;
        for (int i = 0; i < index; i++){
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //刪除第index個節點
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        size--;
        if (index == 0){
            head = head.next;
        return;
        }
        ListNode pred = head;
        for (int i = 0; i < index; i++){
            pred = pred.next;
        }
        pred.next = pred.next.next;
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