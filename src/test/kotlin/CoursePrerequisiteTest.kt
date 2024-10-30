import org.example.CoursePrerequisite
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CoursePrerequisiteTest{
    val coursePrerequisite = CoursePrerequisite()

    @Test
    fun canFinishCourseOne(){
        val numOfCourses = 2
        val prerequisites = arrayOf(intArrayOf(1,0), intArrayOf(0,1))

        assertFalse(coursePrerequisite.canFinish(numOfCourses, prerequisites))

    }

    @Test
    fun canFinishCourseTwo(){
        val numOfCourses = 2
        val prerequisites = arrayOf(intArrayOf(1,0))

        assertTrue(coursePrerequisite.canFinish(numOfCourses, prerequisites))

    }

    @Test
    fun canFinishCourseThree(){
        val numOfCourses = 3
        val prerequisites = arrayOf(intArrayOf(1,0), intArrayOf(2,0), intArrayOf(1,2), intArrayOf(0, 2))

        assertFalse(coursePrerequisite.canFinish(numOfCourses, prerequisites))
    }

//    @Test
//    fun canFinishCourseFourEx1(){
//        val numOfCourses = 4
//        val prerequisites = arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4, 2))
//
//        assertFalse(coursePrerequisite.canFinish(numOfCourses, prerequisites))
//    }
//    @Test
//    fun canFinishCourseFour(){
//        val numOfCourses = 4
//        val prerequisites = arrayOf(intArrayOf(1,4), intArrayOf(2,4), intArrayOf(3,1), intArrayOf(3, 2))
//
//
//        assertTrue(coursePrerequisite.canFinish(numOfCourses, prerequisites))
//    }

    @Test
    fun canFinishCourseEight(){
        val numOfCourses = 8
        val prerequisites = arrayOf(intArrayOf(1,0), intArrayOf(2,6), intArrayOf(1,7), intArrayOf(6, 4), intArrayOf(7, 0),intArrayOf(0, 5))

        assertTrue(coursePrerequisite.canFinish(numOfCourses, prerequisites))
    }

    @Test
    fun canFinishCourseSeven(){
        val numOfCourses = 7
        val prerequisites = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 3),
            intArrayOf(0, 2),
            intArrayOf(3, 2),
            intArrayOf(2, 5),
            intArrayOf(4, 5),
            intArrayOf(5, 6),
            intArrayOf(2, 4)
        )


        assertTrue(coursePrerequisite.canFinish(numOfCourses, prerequisites))
    }
}