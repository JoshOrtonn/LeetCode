package org.example

class ColourSort {
    // Insertion sort, whereby:
    // Start at index 1 as elementToInsert and compare
    // with all indices before hand where:
    //  -- j > 0 and nums[j] > elementToInsert
    // shift the previous index up by one, replacing the value nums[j+1] = nums[j]
    // and move j pointer back one, j = j-1
    // Then once the while condition is not met, we assume either j is at -1 or found a smaller value
    // We insert the currentElementToCompare in this place.
    // We shouldn't worry about inserting in place, as we should have
    // moved each element greater than the current along by one as we've done it.
    fun insertionSortColors(nums: IntArray): IntArray {
        for(i in 1 .. nums.lastIndex){
            val elementToInsert = nums[i]

            var backwardsPointer = i - 1

            while(backwardsPointer >= 0 && nums[backwardsPointer] > elementToInsert){
                // Replace the elementToInsert (on first run) or just shift previous value up by one
                // Not stressing as we know,  that we will also insert elementToInsert soon
                nums[backwardsPointer+1] = nums[backwardsPointer]

                // Move backwards pointer back one, looking for next element, such that conditions will still be met
                // BackwardsPointer > 0 && nums[backwardsPointer-1] > nums[elementToInsert]
                // so we will continue to shift the values up until we've found an element less than or we hit -1, and hence put at 0.
                backwardsPointer -= 1
            }
            // If out of while loop, means we've either found an element less than, or we have hit -1.
            // Hence add the eleemnt to insert at the position to right of current.
            nums[backwardsPointer+1] = elementToInsert
        }


        return nums
    }

    // Bubble Sort: O(n^2) worst case, if all elements incorrectly placed to begin with.
    fun bubbleSortColors(array: IntArray) {
        // Iterate through the array from the last element to the first
        // with each iteration of i reducing the window to solve.
        for (i in array.lastIndex downTo 0) {
            // Iterate through the unsorted portion of the array
            for (j in 0 until i) {
                // Compare adjacent elements and swap if necessary
                // Going along whole array if required.
                // But swapping until it's found a place whereby the next element is greater than it
                if (array[j] > array[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    val temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
    }
    // Most sorting algos use quicksort built in anyway.

}