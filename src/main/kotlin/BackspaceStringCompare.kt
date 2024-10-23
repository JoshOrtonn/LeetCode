package org.example

/**
 * Backspace String Compare
 * Easy
 * Topics
 * Companies
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 *
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 *
 *
 *
 */
class BackspaceStringCompare {
    // Good for runtime, less for memory.
    // TODO tomorrow solve for memory
    fun backspaceCompare(s: String, t: String): Boolean {
        val sStack = ArrayDeque<Char>()
        val tStack = ArrayDeque<Char>()

        s.forEach {
            if(it == '#'){
                sStack.removeFirstOrNull()
            } else {
                sStack.addFirst(it)
            }
        }
        t.forEach {
            if (it == '#') {
                tStack.removeFirstOrNull()
            } else {
                tStack.addFirst(it)
            }
        }
        while(sStack.isNotEmpty() || tStack.isNotEmpty()){
            val charAtS = sStack.removeFirstOrNull()
            val charAtT = tStack.removeFirstOrNull()
            if(charAtS !== charAtT){
                return false
            }
        }

        return true
    }

    // Slightly better than a stack, but still not O(1)
    fun backspaceCompareSolvedForMemory(s: String, t: String): Boolean {
        val sString = buildString {
            s.forEach { sChar ->
                if(sChar == '#') {
                    if(this.lastIndex > -1){
                        deleteCharAt(this.lastIndex)
                    }
                } else {
                    append(sChar)
                }
            }
        }
        val tString = buildString {
            t.forEach { tChar ->
                if(tChar == '#'){
                    deleteCharAt(this.lastIndex)
                } else {
                    append(tChar)
                }
            }
        }

        return tString == sString
    }

    // For O(1) memory should use two pointers for each string, checking each incrementally I think.
    // Perhaps working from back to front, and if see a hash we can skip over.
    // TODO: Continue this two pointer work.
    fun backspaceCompareSolvedForMemoryV2(s: String, t: String): Boolean {
        var sIndex = s.lastIndex
        var tIndex = t.lastIndex
        var sHashes = 0
        var tHashes = 0

        while (sIndex >= 0 && tIndex >=0) {
            if(s[sIndex] != t[tIndex] && (tHashes == 0 && sHashes == 0)){
                return false
            }
            if(s[sIndex] == '#'){
                sHashes++
            } else {
                sHashes--
                sIndex--
            }
            if(t[tIndex] == '#'){
                tHashes++
            } else {
                tHashes--
                tIndex--
            }
            // working way down past
            sIndex -= 1
            tIndex -= 1
        }

        return sIndex == tIndex
    }
}