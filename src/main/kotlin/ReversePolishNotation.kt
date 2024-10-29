package org.example

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
class ReversePolishNotation {
    // Push non-operation strings as their int counterparts to stack
    // Once operation found, pop first two ints off stack,
    // with first pop being the right hand side, and second pop being left hand side
    // And operation found, being the middle
    // Then push the result onto the stack
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        tokens.forEach {
            if(isOperation(it)) {
                // pop twice, first being right hand side
                // second being left hand side
                val rightHandSide = stack.removeFirstOrNull()
                val leftHandSide = stack.removeFirstOrNull()
                val output = computeOperation(leftHandSide, rightHandSide, it)
                output?.let { nonNullOutput ->
                    stack.addFirst(nonNullOutput)
                }
            } else {
                // push string as int onto stack
                stack.addFirst(it.toInt())
            }

        }

        // At this point, stack should just contain one element, and it's the resulted output
        return stack.first()

    }

    private fun computeOperation(leftHandSide: Int?, rightHandSide: Int?, operation: String): Int? {
        if(leftHandSide == null || rightHandSide == null) return null

        return when (operation) {
            "/" ->  leftHandSide / rightHandSide
            "*" ->  leftHandSide * rightHandSide
            "-" ->  leftHandSide - rightHandSide
            "+" ->  leftHandSide + rightHandSide
            else -> null // Never should be this case.
        }
    }

    private fun isOperation(input: String): Boolean {
        return when(input){
            "/" -> true
            "*" -> true
            "-" -> true
            "+" -> true
            else -> false
        }
    }
}