class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has only one node, return null
        }

        // Initialize slow and fast pointers
        ListNode slow = head;//this is the pointer which moves only one step while iteration
        ListNode fast = head;//this is the pointer which moves double step than slow while iteration
        ListNode prev = null;

        // Move slow pointer one step and fast pointer two steps
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //the above part we doing it because when fast reaches end our slow reaches at middle.
        
        // Delete the middle node
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }
}