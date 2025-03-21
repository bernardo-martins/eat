package entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserTest {

    @Test
    fun `test User properties are correctly initialized`() {
        // Given
        val user = User(id = 1, name = "John Doe", email = "john.doe@example.com")

        // Then
        assertEquals(1, user.id)
        assertEquals("John Doe", user.name)
        assertEquals("john.doe@example.com", user.email)
    }

    @Test
    fun `test equals and hashCode methods`() {
        // Given
        val user1 = User(id = 1, name = "John Doe", email = "john.doe@example.com")
        val user2 = User(id = 1, name = "John Doe", email = "john.doe@example.com")
        val user3 = User(id = 2, name = "Jane Doe", email = "jane.doe@example.com")

        // Then
        assertEquals(user1, user2) // Equality check
        assertEquals(user1.hashCode(), user2.hashCode()) // HashCode check
        assertNotEquals(user1, user3) // Inequality check
    }

    @Test
    fun `test toString method`() {
        // Given
        val user = User(id = 1, name = "John Doe", email = "john.doe@example.com")

        // Then
        val expectedToString = "User(id=1, name=John Doe, email=john.doe@example.com)"
        assertEquals(expectedToString, user.toString())
    }

    @Test
    fun `test copy method`() {
        // Given
        val user = User(id = 1, name = "John Doe", email = "john.doe@example.com")

        // When
        val copiedUser = user.copy(name = "Jane Doe")

        // Then
        assertEquals(1, copiedUser.id)
        assertEquals("Jane Doe", copiedUser.name)
        assertEquals("john.doe@example.com", copiedUser.email)
    }
}