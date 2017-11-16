tion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prevNode = null;
        ListNode currNode = head;
        int carryOver = 0;
        while (l1 != null || l2 != null){
            if(prevNode!=null){
                currNode = new ListNode(0);
                prevNode.next = currNode;
            }
            int l1val = l1 == null? 0 : l1.val;
            int l2val = l2 == null? 0 : l2.val;
            
            currNode.val = (l1val + l2val + carryOver)% 10;
            carryOver = (l1val + l2val +carryOver) / 10;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
            prevNode = currNode;
        }
        //handle the carryover from the last node.
        if(carryOver > 0){
            currNode = new ListNode(0);
            prevNode.next = currNode;
            currNode.val = carryOver; //should always be 1.
        } 
        
        return head;
    }
}
