import org.example.AccountsMerge
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class AccountsMergeTest {
    val accountsMerge = AccountsMerge()
    @Test
    fun shouldMergeAccountEx1() {
        val inputs = listOf(
            listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            listOf("John", "johnsmith@mail.com", "john00@mail.com"),
            listOf("John", "johnnybravo@mail.com"),
            listOf("Mary", "mary@mail.com")
        )

        val expectedOutcome = listOf(
            listOf("John", "johnsmith@mail.com", "john00@mail.com", "john_newyork@mail.com"),
            listOf("John", "johnnybravo@mail.com"),
            listOf("Mary", "mary@mail.com")
        )

        assertContentEquals(expectedOutcome, accountsMerge.accountsMerge(inputs))
    }

    @Test
    fun shouldMergeAccountEx2() {
        val inputs = listOf(
            listOf("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),
            listOf("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"),
            listOf("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"),
            listOf("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"),
            listOf("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co")
        )
        assertContentEquals(inputs, accountsMerge.accountsMerge(inputs))
    }

}