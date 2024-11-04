package lca

import org.example.lca.LowestCommonAncestorBinaryTree
import org.example.lca.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LowestCommonAncestorBinaryTreeTest {
    val lca = LowestCommonAncestorBinaryTree()

    val treeNode7 = TreeNode(7)
    val treeNode0 = TreeNode(0)
    val treeNode4 = TreeNode(4)
    val treeNode8 = TreeNode(8)
    val treeNode2 = TreeNode(2).apply {
        left = treeNode7
        right = treeNode4
    }
    val treeNode6 = TreeNode(6)
    val treeNode5 = TreeNode(5).apply {
        left = treeNode6
        right = treeNode2
    }

    val treeNode1 = TreeNode(1).apply {
        left = treeNode0
        right = treeNode8
    }
    val treeNode3 = TreeNode(3).apply {
        left = treeNode5
        right = treeNode1
    }


    val input = treeNode3

    @Test
    fun shouldFindLCAEx1() {
        val p = treeNode5
        val q = treeNode1
        assertEquals(treeNode3, lca.lowestCommonAncestor(input, p, q))

    }

    @Test
    fun shouldFindLCAEx2() {
        val p = treeNode5
        val q = treeNode4
        assertEquals(treeNode5, lca.lowestCommonAncestor(input, p, q))
    }

    @Test
    fun shouldFindLCAEx3() {
        val treeNode2 = TreeNode(2)
        val treeNode1 = TreeNode(1).apply { left = treeNode2 }
        val p = treeNode1
        val q = treeNode2

        assertEquals(treeNode1, lca.lowestCommonAncestor(treeNode1, p, q))
    }

    @Test
    fun shouldFindLCAEx4() {
        val treeNode3 = TreeNode(3)
        val treeNode4 = TreeNode(4)
        val treeNode2 = TreeNode(2).apply {
            right = treeNode4
        }
        val treeNode1 = TreeNode(1).apply {
            left = treeNode2
            right = treeNode3
        }
        val p = treeNode4
        val q = treeNode3

        assertEquals(treeNode1, lca.lowestCommonAncestor(treeNode1, p, q))
    }

    @Test
    fun shouldFindLCAEx5() {
        //[-1,0,3,-2,4,null,null,8]
        val treeNode8 = TreeNode(8)
        val treeNode3 = TreeNode(3)

        val treeNode4 = TreeNode(4)
        val treeNodeMinus2 = TreeNode(-2).apply {
            left = treeNode8
        }
        val treeNode0 = TreeNode(0).apply {
            left = treeNodeMinus2
            right = treeNode4
        }
        val treeNodeMinus1 = TreeNode(-1).apply {
            left = treeNode0
            right = treeNode3
        }
        val p = treeNode8
        val q = treeNode4

        assertEquals(treeNode0, lca.lowestCommonAncestor(treeNodeMinus1, p, q))
    }
}