package org.example

/***
 * Given the`head` of a singly linked list, reverse the list, and return the reversed list*.
 *
 * **Example 1:**
 *
 * !https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg
 *
 * ```
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * ```
 *
 * **Example 2:**
 *
 * !https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg
 *
 * ```
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * ```
 *
 * **Example 3:**
 *
 * ```
 * Input: head = []
 * Output: []
 *
 * ```
 */
class ReverseLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    // Good runtime, but not good memory optimised given the stack
    fun reverse(head: ListNode?): ListNode? {
        var composableHead = head
        // Could push all to a stack, then pop off one by one
        // 1,2,3,4,5
        // Stack: 5, 4, 3, 2, 1
        // First one just present, then each subsequent node will have next as previous.
        val stack = ArrayDeque<ListNode>()
        while(composableHead != null) {
            stack.addFirst(ListNode(composableHead.`val`).apply { next = stack.firstOrNull() })
            composableHead = composableHead.next
        }

        return stack.firstOrNull()
    }

    fun reverseMemoryOptimised(head: ListNode?): ListNode? {
        // With h three pointers:
        // 1. prev: To track the previous node we processed (starts as null).
        // 2. next: This will keep track of the next node to process.
        // 3. curr: This is the current node we are processing (starts as the head of the list).
        var prev: ListNode? = null
        var next: ListNode? = null
        var curr: ListNode? = head


        // We loop through the linked list until we reach the end (when curr is null).
        while (curr != null) {
            // Store the next node in the list.
            // Need to do this because we will change the current node's next pointer.
            next = curr.next

            // Reverse the link, instead of pointing to the next node, the current node now points to the previous node.
            // Note val remains the same
            curr.next = prev

            // Move the previous pointer to the current node (since the current node is now processed).
            prev = curr

            // Move the current pointer to the next node (to continue processing the rest of the list).
            curr = next
        }


        // When we've processed all nodes, the prev pointer will be at the new head of the reversed list.
        return prev
    }
}