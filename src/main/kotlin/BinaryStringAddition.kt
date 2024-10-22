package org.example

class BinaryStringAddition {
    // TODO Horrible code implementation, yuckkkkk
//    fun addBinary(a: String, b: String): String {
//        var sanitisedA = a
//        var sanitisedB = b
//        if(b.length > a.length) {
//            val diff: Int = b.length - a.length
//            val newA = "0".repeat(diff)
//            sanitisedA = newA + a
//        } else if(a.length > b.length){
//            val diff: Int = a.length - b.length
//            val newB = "0".repeat(diff)
//            sanitisedB = newB + b
//        }
//
//        val output = buildString {
//            var carryOne = 0
//            for(i in sanitisedA.lastIndex downTo 0) {
//                if(sanitisedA[i] == sanitisedB[i] && sanitisedA[i] == '1'){
//                    if(carryOne == 0) {
//                        append("0")
//                        carryOne = 1
//                    } else {
//                        append("1")
//                        carryOne = 1
//                    }
//                } else if(sanitisedA[i] == sanitisedB[i] && sanitisedA[i] == '0') {
//                    if (carryOne == 0) {
//                        append("0")
//                    } else {
//                        append("1")
//                        carryOne = 0
//                    }
//                } else {
//                    if(carryOne == 0) {
//                        append("1")
//                    } else {
//                        append("0")
//                        carryOne = 1
//                    }
//                }
//            }
//            if(carryOne > 0){
//                append("1")
//            }
//            // Reverse as really we want to prepend
//            reverse()
//        }
//
//        return output
//    }

    fun addBinary(a: String, b: String): String {
        val (sanitisedA, sanitisedB) = sanitiseInput(a, b)

        return buildString {
            var carryOne = 0
            for (i in sanitisedA.lastIndex downTo 0) {
                when {
                    bothEqualOne(sanitisedA, sanitisedB, i) && carryOne == 0 -> {
                        append("0")
                        carryOne = 1
                    }

                    bothEqualOne(sanitisedA, sanitisedB, i) && carryOne == 1 -> {
                        append("1")
                        carryOne = 1
                    }

                    bothEqualZero(sanitisedA, sanitisedB, i) && carryOne == 0 -> {
                        append("0")
                    }

                    bothEqualZero(sanitisedA, sanitisedB, i) && carryOne == 1 -> {
                        append("1")
                        carryOne = 0
                    }

                    !isEqual(sanitisedA, sanitisedB, i) && carryOne == 0 -> {
                        append("1")
                    }

                    else -> {
                        append("0")
                        carryOne = 1
                    }
                }
            }
            // If all calculations are done and there's still a carry over, add one.
            if (carryOne > 0) {
                append("1")
            }

            // Reverse as really we want to prepend
            reverse()
        }
    }

    private fun bothEqualZero(sanitisedA: String, sanitisedB: String, i: Int) =
        isEqual(sanitisedA, sanitisedB, i) && sanitisedA[i] == '0'

    private fun bothEqualOne(sanitisedA: String, sanitisedB: String, i: Int) =
        isEqual(sanitisedA, sanitisedB, i) && sanitisedA[i] == '1'

    private fun isEqual(sanitisedA: String, sanitisedB: String, i: Int) = sanitisedA[i] == sanitisedB[i]

    private fun sanitiseInput(
        a: String,
        b: String
    ): Pair<String, String> {
        var sanitisedA1 = a
        var sanitisedB1 = b
        if (b.length > a.length) {
            val diff: Int = b.length - a.length
            val newA = "0".repeat(diff)
            sanitisedA1 = newA + a
        } else if (a.length > b.length) {
            val diff: Int = a.length - b.length
            val newB = "0".repeat(diff)
            sanitisedB1 = newB + b
        }
        return Pair(sanitisedA1, sanitisedB1)
    }
}

