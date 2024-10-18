package lca

import org.example.lca.LowestCommonAncestoryBinarySearchTree
import org.example.lca.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LowestCommonAncestoryBinarySearchTreeTest{
    val lca = LowestCommonAncestoryBinarySearchTree()
    val treeNode3 = TreeNode(3)
    val treeNode5 = TreeNode(5)
    val treeNode9 = TreeNode(9)
    val treeNode7 = TreeNode(7)
    val treeNode0 = TreeNode(0)
    val treeNode4 = TreeNode(4).apply {
        left = treeNode3
        right = treeNode5
    }
    val treeNode8 = TreeNode(8).apply {
        left = treeNode7
        right = treeNode9
    }
    val treeNode2 = TreeNode(2).apply {
        left = treeNode0
        right = treeNode4
    }
    val treeNode6 = TreeNode(6).apply {
        left = treeNode2
        right = treeNode8
    }


    val input = treeNode6

    @Test
    fun shouldFindLCAEx1(){
        val p = treeNode2
        val q = treeNode8
        assertEquals(treeNode6, lca.solve(input, p, q))

    }

    @Test
    fun shouldFindLCAEx2(){
        val p = treeNode2
        val q = treeNode4
        assertEquals(treeNode2, lca.solve(input, p, q))

    }

    @Test
    fun shouldFindLCAEx3(){
        val p = treeNode2
        val q = treeNode9
        assertEquals(treeNode6, lca.solve(input, p, q))
    }

}