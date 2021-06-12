public class PalindromeLinkedList {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode n1, n2, prev=null, next=null;
            
            // get the midpoint of LL(in case of even count 2nd one)
            n1 = head;
            n2 = head;
            while (n2.next != null && n2.next.next != null) {       // use double pointer to get midpoint and reverse the 1st half
                n2 = n2.next.next;

                // reverse the first half
                next = n1.next;
                n1.next = prev;
                prev = n1;
                n1 = next;
            }
            
            if (n2.next == null) {          // odd, n1 is at mid node, prev is the start of 1st half
                next = n1.next;
            }
            else if (n2.next.next == null) {    // even, n1 is on 1st mid node
                next = n1.next;
                n1.next = prev;
                prev = n1;
            }
            
            // compare both the halves
            for (n1=prev, n2=next; n1!=null && n2!=null; n1=n1.next, n2=n2.next) {
                if (n1.val != n2.val)
                    return false;
            }
            if (n1!=null || n2!=null)
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        ListNode head, n;
        n = head = new ListNode(1);
        // n = n.next = new ListNode(1);
        // n = n.next = new ListNode(3);
        // n = n.next = new ListNode(2);
        // n = n.next = new ListNode(1);

        System.out.println(new Solution().isPalindrome(head));
    }
}
