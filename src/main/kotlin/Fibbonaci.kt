package org.example

class Fibbonaci {

    // Beats optimisation.
    fun solve(n: Int): Int {
        if(n == 0) return 0
        if(n == 1) return 1

        return solve(n-1) + solve(n-2)
    }

    // Beats runtime but memory not so.
    fun solveWithMemoization(n: Int): Int {
        val memoMap = HashMap<Int,Int>()
        memoMap[1] = 1
        memoMap[2] = 1

        (3..n).forEach { x ->
            memoMap[x] = memoMap[x - 1]!! + memoMap[x - 2]!!
        }
        return memoMap[n]!!
    }
}