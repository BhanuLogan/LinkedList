/*
    Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        return solution2(head);
    }
    
    /*
        Intuition: 
            If we know the middle index, we can traverse 
            and return the value at that position.
        Appoarch: 
            1. Find the length of the linkedlist
            2. Find the middle index
            3. Traverse till middle index and return the value
            
        TC: O(N + N/2) = O(N) - Two pass
        SC: O(1)
    */
    private ListNode solution1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        int n = 0;
        ListNode ptr = head;
        while(ptr != null) {
            n++;
            ptr = ptr.next;
        }
        int pos = n/2;
        while(pos-- > 0) {
            head = head.next;
        }
        return head;
    }
    
    /*
        Intuition: 
            Let's say, you and your friend are in running race, 
            if your friend's speed is x km/hr, and your speed is x km/hr,
            then by the time you reach destination, your friend completes 
            exactly half of the race.
            This is exactly what we are using in this approach.
            
        Approach:
            1. Have slow and fast pointer
            2. In each iteration, move slow pointer by one step ahead and fast pointer by 2 steps ahead.
            3. return the node that was pointed by slow pointer

        TC: O(N) - One pass
        SC: O(1)
    */
    private ListNode solution2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
