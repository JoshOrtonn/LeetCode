import org.example.ListNode
import org.example.MergeTwoSortedLists
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNull

/*
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

 */
class ListNodeTest {
    val mergeTwoSortedLists = MergeTwoSortedLists()

    @Test
    fun isExpectedOutcome() {
        val listOneNodeOne = ListNode(1)
        val listOneNodeTwo = ListNode(2)
        val listOneNodeThree = ListNode(4)

        listOneNodeOne.next = listOneNodeTwo
        listOneNodeTwo.next = listOneNodeThree

        val listTwoNodeOne = ListNode(1)
        val listTwoNodeTwo = ListNode(3)
        val listTwoNodeThree = ListNode(4)
        listTwoNodeOne.next = listTwoNodeTwo
        listTwoNodeTwo.next = listTwoNodeThree


        val expectedOutput = listOneNodeOne
        val actualOutput = mergeTwoSortedLists.mergeTwoLists(listOneNodeOne, listTwoNodeOne)
        assertEquals(expectedOutput.`val`, actualOutput?.`val`)

    }

    @Test
    fun isExpectedOutcomeWithEmptyListNodes() {
        assertNull(mergeTwoSortedLists.mergeTwoLists(null, null))
    }

    @Test
    fun isExpectedOutccomeWithComplexList(){
        val listTwoNodeOne = ListNode(0)
        assertEquals(listTwoNodeOne.`val`, mergeTwoSortedLists.mergeTwoLists(null, listTwoNodeOne)?.`val`)
    }
}