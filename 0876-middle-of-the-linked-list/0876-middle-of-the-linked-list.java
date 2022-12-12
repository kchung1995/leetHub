/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int nodeCount = 1;
        
        ListNode now = head;
        while(true) {
            if (Objects.equals(now.next, null)) {
                break;
            }
            now = now.next;
            nodeCount++;
        }
        nodeCount /= 2;

        now = head;
        while(nodeCount > 0) {
            now = now.next;
            nodeCount--;
        }
        
        return now;
    }
}