package org.example

import org.example.FloodFill.*

/**
 * 733. Flood Fill
 * Easy Beat 100% other's runtime... Didn't like recursive nature, harder for me to visualise.
 *
 * You are given an image represented by an `m x n` grid of integers image,
 * where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color.
 * Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill:
 *
 * 1. Begin with the starting pixel and change its color to `color`.
 * 2. Perform the same process for each pixel that is "directly adjacent"
 *    (pixels that share a side with the original pixel, either horizontally or vertically)
 *    and shares the same color as the starting pixel.
 * 3. Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color
 *      if it matches the original color of the starting pixel.
 * 4. The process stops when there are no more adjacent pixels of the original color to update.
 * Return the modified image after performing the flood fill.
 *
 *
 *
 * Example 1:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr (row) = 1, sc (column) = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 *
 * Explanation:
 * resources/BinarySearchTree.png
 * From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
 * all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.
 *
 * Example 2:
 *
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 *
 * Explanation:
 *
 * The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.
 */
class FloodFill {

    /*

    Task is kinda to visit all neighbours of sr,sc of the same colour as the starting pixel,
    and then visit all their neighbours either horizontally or vertically and update their colours to be the new colour
    If sr,sc isn't already the same colour.


        So look at starting pixel, add to stack, note starting colour
            while stack is not empty,
                pop off stack,
                check node is not null, not already been visited, within bounds of the image, and colour matches the expected starting colour
                    if so:
                        add to visited
                        change colour
                        push all neighbours to stack

     */

    data class Coordinates(val row: Int, val column: Int)
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {

        if(image[sr][sc] == color) return image
        val startingColour = image[sr][sc]

        val stack = ArrayDeque<Coordinates>() // LIFO
        val visited = mutableSetOf<Coordinates>()
        // Add starting one.
        stack.addFirst(Coordinates(sr,sc))

        while(stack.isNotEmpty()){
            // Remove first node
            val node = stack.removeFirstOrNull()

            // check it's not been visited, ensure it's not null, check bounds and that the colour matches the starting colour
            if(!visited.contains(node) && node != null && node.isWithinBounds(image) && image[node.row][node.column] == startingColour){
                visited.add(node)
                println("$node added to the node")
                // Change colour
                image[node.row][node.column] = color

                // Add all, regardless if in bounds as all will happen it'll be added to stack, then checked against in if condition
                // To improve, could just check here, before adding out of bounds to stack, and assume everything works, given in bounds sr/sc
                stack.addFirst(Coordinates(node.row+1, node.column))
                stack.addFirst(Coordinates(node.row-1, node.column))
                stack.addFirst(Coordinates(node.row, node.column+1))
                stack.addFirst(Coordinates(node.row, node.column-1))
            }
        }
        return image
    }
    private fun Coordinates.isWithinBounds(image: Array<IntArray>): Boolean {
//       return this.row <= image.lastIndex && this.row > 0 && this.column > 0 && this.column <= image[0].lastIndex

        return this.row in image.indices && this.column in image[0].indices
    }

}

