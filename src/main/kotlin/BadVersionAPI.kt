package org.example

/* The isBadVersion API is defined in the parent class VersionControl.
  fun isBadVersion(version: Int) : Boolean {} */

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var low = 0
        var high = n

        // In case of bad input, say n = 5, but bad version = 8, not possible but...
        // Low will continue being mid + 1, given isBad(mid) will not be true, until it becomes higher than high
        // and drop out of while looop
        while (low <= high) {
            // 1. Calculate range, of where answer should lie (high - low)
            // 2. Halve that range,
            // 3. And then add back in the low index, to push it along to where the mid point should be.
            // So we can continue halving the search space
            // required because if we instead did (low+high)/2 it could cause an integer overflow if low and high were 2^32.
            val mid = low + (high - low) / 2

            if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
                return mid
            }

            if (isBadVersion(mid)) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return -1
    }
}

abstract class VersionControl {
    var badVersioning: Int = 4
    fun setBadVersion(newBadVersion: Int) {
        badVersioning = newBadVersion
    }

    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(version: Int): Boolean {
        return version >= badVersioning
    }
}
