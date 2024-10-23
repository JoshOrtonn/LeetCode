package org.example

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */

// Good for runtime, not for memory obvs
class MiddleLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun middleNode(head: ListNode?): ListNode? {
        val list = buildList<ListNode> {
        var currentHead = head
            while(currentHead != null){
                add(currentHead)
                currentHead = currentHead.next
            }
        }

        return list[list.size/2]
    }

    // No need for memory storage, using two pointers instead.
    // 2 Pointers, whereby one moves twice as fast as the other
    // hence when fast is at the end.
    // The slow pointer should be at the middle, in theory.
    fun middleNodeTwoPointer(head: ListNode?): ListNode? {
            var fast = head
            var slow = head
            while(fast?.next != null) {
                fast = fast.next?.next
                slow = slow?.next
            }

        return slow
    }
}