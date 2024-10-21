package org.example

class LongestPalindrome {
    fun solve(s: String): Int {
        var palindromeCounter = 0
        val setOfChars = buildSet<Char> {
            s.forEach {
                // If it's already present,
                // remove it kinda as a way to ensure we can easily deal with multiples of twos
                if (this.contains(it)) {
                    this.remove(it)
                    palindromeCounter += 2
                } else {
                    this.add(it)
                }
            }
        }

        return if (setOfChars.isNotEmpty()) {
            palindromeCounter + 1
        } else {
            palindromeCounter
        }
    }
}