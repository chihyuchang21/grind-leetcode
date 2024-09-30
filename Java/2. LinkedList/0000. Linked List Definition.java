public class ListNode {
    int val;    // store the value of the current node
    ListNode next; // pointers to the next node;

    // default no-argument constructor
    ListNode() {}

    // single-argument constructor
    ListNode(int val) {
        this.val = val;
    }

    // two-argument constructor
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}