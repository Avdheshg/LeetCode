class MyCircularQueue {

    int spaceLeft; // after enQ, this will reduce and after dQ, will increase
	ListNode left;
	ListNode right;

    public MyCircularQueue(int k) {
        spaceLeft = k;
		left = new ListNode(0, null, null);
		right = new ListNode(0, left, null);
		left.next = right;
    }
    
    public boolean enQueue(int val) {
        if (isFull()) {
			return false;
		}
		ListNode newNode = new ListNode(val, right.prev, right);
		// newNode.prev.next = newNode;
		// newNode.next.prev = newNode;
		right.prev.next = newNode;   // this code is faster than above commented code ie connecting the pointers using the new node but here V R connecting the nodes using the prev nodes
		right.prev = newNode;
		spaceLeft--;
		return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
			return false;
		}
		// ListNode curr = left.next;
		// left.next = curr.next;
		// curr.next.prev = left;
		left.next = left.next.next;
		left.next.prev = left;
		spaceLeft++;
		return true;
    }
    
    public int Front() {
        if (isEmpty()) {
			return -1;
		}
		return left.next.val;
    }
    
    public int Rear() {
        if (isEmpty()) {
			return -1;
		}
		return right.prev.val;
    }
    
    public boolean isEmpty() {
        return left.next == right;
    }
    
    public boolean isFull() {
        return spaceLeft == 0;
    }
}

class ListNode {
	ListNode prev, next;
	int val;

	public ListNode(int _val, ListNode _prev, ListNode _next) {
		val = _val;
		prev = _prev;
		next = _next;
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