package org.example

import kotlin.collections.ArrayDeque

/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/



class ValidParenthesis {
    private val parenthesesMap = mapOf<Char, Char>(
        Pair('}', '{'),
        Pair(']', '['),
        Pair(')', '(')
    )
    //    20. Valid Parentheses
    fun isValidParenthesis(input: String): Boolean {
        // Each open should have a close
        // Nested within
        // Stack

        // Keep adding open brackets, and then the first close, we need to check the prior element
        // It should be a corresponding open, if so remove the open from the stack and never add the closes
        // If it is not a corresponding open, return false it's not valid.
        // Working inside out essentially.
        // So [ do nothing
        // ] check previous open is present, remove it

        // ([{}
        // Check previous one was a closer remove both
        // ([
        // ([{{}

        // Correct number, correct order.
        val stack = ArrayDeque<Char>()
        input.forEach { char: Char ->
            if (isOpeningParenthesis(char)) {
                stack.addFirst(char)
            } else {
                val topOfStack: Char? = stack.firstOrNull() // peek at the top, if it's corresponding opening
                // Then we are okay to remove them and continue
                if (topOfStack != null && topOfStack == parenthesesMap.getValue(char)) {
                    stack.removeFirstOrNull()
                } else {
                    // Otherwise we can consider it to be a failure
                    // Given closing parenthesis even nested should be next to it and don't add closing brackets ever.
                    return false
                }
            }
        }
        println(stack)

        // really if stack is left with only opens it should be false
        return stack.none { isOpeningParenthesis(it) }
    }

    private fun isOpeningParenthesis(char: Char): Boolean = parenthesesMap.values.any { it == char }

}