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
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Return the head of the merged linked list.
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 *
 * // Take list one, look at val,
 * // Take List two look at val, take whichever is smallest, else first list if the same
 * // Then compare list one to listOne Next, vs ListTwo Next
 * // Then add whichever is smallest to new next.
 * // Then compare that val with listOneNext vs ListTwoNext
 * // Add whichever is smallest as new next.
 * // But need to keep order
 * // Seems much like a recursive problem, but first node needs to be returned.
 * // ListOne is null or not null
 * // ListTwo is null or not null
 * // When null we don't wanna go down the tree anymore
 */
class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        val result = ListNode(0)
        var l1 = list1
        var l2 = list2
        var current = result

        // While both not null, traverse the tree
        while (l1 != null && l2 != null) {
            // If list two val bigger, store list one tree as next one
            if (l1.`val` < l2.`val`) {
                current.next = l1
                l1 = l1.next
            } else {
                // Do the same but with list two
                current.next = l2
                l2 = l2.next
            }
            // Iterate the node along
            current = current.next!!
        }

        // In the case where one side of the list fails the precondition of nullability
        // we can finish the lists off here.
        if (l1 != null) current.next = l1
        if (l2 != null) current.next = l2

        return result.next
    }
}