class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return; // Since we know the node is not the last, this check is for safety.
        }
        node.val = node.next.val;// Copy the value of the next node to the current node
        node.next = node.next.next;// Bypass the next node= adjusts the next pointer to skip the next node.
    }
}
//By copying the value of the next node into the current node and bypassing the next node, we effectively delete the current node's original value and remove one node from the list. This approach works under the constraints given (i.e., the node to be deleted is not the last node and all node values are unique).