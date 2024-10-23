import org.example.MiddleLinkedList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MiddleLinkedListTest{
    val middleLinkedList = MiddleLinkedList()
    @Test
    fun shouldReturnSecondMiddleLinkedListGivenEven() {
        val node5 = MiddleLinkedList.ListNode(5)
        val node4 = MiddleLinkedList.ListNode(4).apply { next = node5 }
        val node3 = MiddleLinkedList.ListNode(3).apply { next = node4 }
        val node2 = MiddleLinkedList.ListNode(2).apply { next = node3 }
        val headNode = MiddleLinkedList.ListNode(1).apply { next = node2 }

        assertNotNull(middleLinkedList.middleNode(headNode)?.next)
        assertEquals(node3.`val`, middleLinkedList.middleNode(headNode)?.`val`)
        assertEquals(node3.next?.`val`, middleLinkedList.middleNode(headNode)?.next?.`val`)
    }

    @Test
    fun shouldReturnMiddleLinkedListOdd() {
        val node6 = MiddleLinkedList.ListNode(6)
        val node5 = MiddleLinkedList.ListNode(5).apply { next = node6 }
        val node4 = MiddleLinkedList.ListNode(4).apply { next = node5 }
        val node3 = MiddleLinkedList.ListNode(3).apply { next = node4 }
        val node2 = MiddleLinkedList.ListNode(2).apply { next = node3 }
        val headNode = MiddleLinkedList.ListNode(1).apply { next = node2 }

        assertNotNull(middleLinkedList.middleNode(headNode)?.next)
        assertEquals(node4.`val`, middleLinkedList.middleNode(headNode)?.`val`)
        assertEquals(node4.next?.`val`, middleLinkedList.middleNode(headNode)?.next?.`val`)
    }

    @Test
    fun shouldReturnSecondMiddleLinkedListGivenEvenTwoPointers() {
        val node5 = MiddleLinkedList.ListNode(5)
        val node4 = MiddleLinkedList.ListNode(4).apply { next = node5 }
        val node3 = MiddleLinkedList.ListNode(3).apply { next = node4 }
        val node2 = MiddleLinkedList.ListNode(2).apply { next = node3 }
        val headNode = MiddleLinkedList.ListNode(1).apply { next = node2 }

        assertNotNull(middleLinkedList.middleNodeTwoPointer(headNode)?.next)
        assertEquals(node3.`val`, middleLinkedList.middleNodeTwoPointer(headNode)?.`val`)
        assertEquals(node3.next?.`val`, middleLinkedList.middleNodeTwoPointer(headNode)?.next?.`val`)
    }

    @Test
    fun shouldReturnMiddleLinkedListOddNodeTwoPointer() {
        val node6 = MiddleLinkedList.ListNode(6)
        val node5 = MiddleLinkedList.ListNode(5).apply { next = node6 }
        val node4 = MiddleLinkedList.ListNode(4).apply { next = node5 }
        val node3 = MiddleLinkedList.ListNode(3).apply { next = node4 }
        val node2 = MiddleLinkedList.ListNode(2).apply { next = node3 }
        val headNode = MiddleLinkedList.ListNode(1).apply { next = node2 }

        assertNotNull(middleLinkedList.middleNodeTwoPointer(headNode)?.next)
        assertEquals(node4.`val`, middleLinkedList.middleNodeTwoPointer(headNode)?.`val`)
        assertEquals(node4.next?.`val`, middleLinkedList.middleNodeTwoPointer(headNode)?.next?.`val`)
    }
}