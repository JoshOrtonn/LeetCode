package intervals

class Intervals {
    fun insertInterval(existingIntervals: List<List<Int>>, newInterval: MutableList<Int>): List<List<Int>> {
        // Given list of existing is already sorted, and non-overlapping
        val outputList = mutableListOf<List<Int>>()
        var i = 0
        // PreIntervals, so while existing intervals size of list is greater than i,
        // And last existingInterval at i is less than the first new interval
        // I.e all of the preintervals get added to the output list.
        while(i < existingIntervals.lastIndex && existingIntervals[i][1] < newInterval[0]) {
            outputList.add(existingIntervals[i])
            i++
        }


        // Merge interval.
        while(i < existingIntervals.size && existingIntervals[i][0] <= newInterval[1]){
            newInterval[0] = minOf(existingIntervals[i][0], newInterval[0])
            newInterval[1] = maxOf(existingIntervals[i][1], newInterval[1])
            i += 1
            outputList.add(newInterval)
        }


        // Merge the last ones too.
        for(j in i..existingIntervals.lastIndex){
            outputList.add(existingIntervals[j])
        }
        return outputList
    }

    /**
    Write a function to check if a person can attend all the meetings scheduled without any time conflicts.
    Given an array intervals, where each element [s1, e1] represents a meeting starting at time s1 and ending at time e1, determine if there are any overlapping meetings.
    If there is no overlap between any meetings, return true; otherwise, return false.
    Note that meetings ending and starting at the same time, such as (0,5) and (5,10), do not conflict.

    EXAMPLES
    Input:
    intervals = [(1,5),(3,9),(6,8)]
    Output:
    false
    Explanation: The meetings (1,5) and (3,9) overlap.

    Input:

    intervals = [(10,12),(6,9),(13,15)]
    Output:

    true
    Explanation: There are no overlapping meetings, so the person can attend all.


    // Firstly sort the meetings by the first number, and create an IntRange between the two numbers
    // Then compare neighbouring meetings
    // i compare to -> i+1
    // if i.end is within i+1 range, return false


     **/
    fun canAttendAllMeetings(meetings: List<List<Int>>): Boolean {
        val intRanges = mutableListOf<IntRange>()
        meetings.sortedBy {
            it[0]
        }
        meetings.forEach {
            intRanges.add(IntRange(it[0], it[1]))
        }

        intRanges.forEach {
            println("${it.first} to ${it.last}")
        }

        for(i in 1..intRanges.lastIndex){
            if(intRanges[i-1].last in intRanges[i]){
                return false
            }
        }
        return true
    }
}
