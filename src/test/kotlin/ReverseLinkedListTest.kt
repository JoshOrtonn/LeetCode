import org.example.ReverseLinkedList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ReverseLinkedListTest{
    val reverseLinkedList = ReverseLinkedList()

    @Test
    fun shouldReverseSimpleList() {
        val inputLeaf = ReverseLinkedList.ListNode(1)
        val inputHead = ReverseLinkedList.ListNode(2).apply { next = inputLeaf }

        val expectedOutputLeaf = ReverseLinkedList.ListNode(2)
        val expectedOutputHead = ReverseLinkedList.ListNode(1).apply { next = expectedOutputLeaf }

        assertEquals(expectedOutputHead.`val`, reverseLinkedList.reverse(inputHead)?.`val`)
//        assertEquals(expectedOutputHead.next?.`val`, reverseLinkedList.reverse(inputHead)?.next?.`val`)
    }

    //Input: head = [1,2,3,4,5]
    //Output: [5,4,3,2,1]
    @Test
    fun shouldReverseComplexList() {
        val input5 = ReverseLinkedList.ListNode(5)
        val input4 = ReverseLinkedList.ListNode(4).apply { next = input5 }
        val input3 = ReverseLinkedList.ListNode(3).apply { next = input4 }
        val input2 = ReverseLinkedList.ListNode(2).apply { next = input3 }
        val input1 = ReverseLinkedList.ListNode(1).apply { next = input2 }

        val output1 = ReverseLinkedList.ListNode(1)
        val output2 = ReverseLinkedList.ListNode(2).apply { next = output1 }
        val output3 = ReverseLinkedList.ListNode(3).apply { next = output2}
        val output4 = ReverseLinkedList.ListNode(4).apply { next = output3 }
        val output5 = ReverseLinkedList.ListNode(5).apply { next = output4 }


        assertEquals(output5.`val`, reverseLinkedList.reverse(input1)?.`val`)
    }

    @Test
    fun shouldWorkForNull() {
        assertNull(reverseLinkedList.reverse(null))
    }

    @Test
    fun shouldWorkForSingleItem() {
        val output1 = ReverseLinkedList.ListNode(1)


        assertEquals(output1.`val`, reverseLinkedList.reverse(output1)?.`val`)
        assertNull(reverseLinkedList.reverse(output1)?.next)
    }

    //Input: head = [1,2,3,4,5]
    //Output: [5,4,3,2,1]
    @Test
    fun shouldReverseComplexListMem() {
        val input5 = ReverseLinkedList.ListNode(5)
        val input4 = ReverseLinkedList.ListNode(4).apply { next = input5 }
        val input3 = ReverseLinkedList.ListNode(3).apply { next = input4 }
        val input2 = ReverseLinkedList.ListNode(2).apply { next = input3 }
        val input1 = ReverseLinkedList.ListNode(1).apply { next = input2 }

        val output1 = ReverseLinkedList.ListNode(1)
        val output2 = ReverseLinkedList.ListNode(2).apply { next = output1 }
        val output3 = ReverseLinkedList.ListNode(3).apply { next = output2}
        val output4 = ReverseLinkedList.ListNode(4).apply { next = output3 }
        val output5 = ReverseLinkedList.ListNode(5).apply { next = output4 }


        assertEquals(output5.`val`, reverseLinkedList.reverseMemoryOptimised(input1)?.`val`)
    }
}