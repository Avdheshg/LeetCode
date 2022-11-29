class MyCircularQueue {
    ListNode start, end;
    int spaceLeft;
    
    public MyCircularQueue(int k) {
        start = new ListNode(null, null, 0);
        end = new ListNode(start, null, 0);
        start.next = end;
        spaceLeft = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        ListNode newNode = new ListNode(end.prev, end, value);
        end.prev.next = newNode;
        end.prev = newNode;
        spaceLeft--;
        printDLL();
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        start.next = start.next.next;
        start.next.prev = start;
        spaceLeft++;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return start.next.val;
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return end.prev.val;
    }
    
    public boolean isEmpty() {
        return start.next == end;
    }
    
    public boolean isFull() {
        return spaceLeft == 0;
    }
    
    public void printDLL() {
        ListNode curr = start.next;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}

class ListNode {
    ListNode next, prev;
    int val;
    
    ListNode(ListNode p, ListNode n, int v) {
        prev = p;
        next = n;
        val = v;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */