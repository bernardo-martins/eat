package dto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserDTOTest {

    @Test
    fun `test UserDTO properties are correctly initialized`() {
        // Given
        val userDTO = UserDTO(name = "John Doe", email = "john.doe@example.com")

        // Then
        assertEquals("John Doe", userDTO.name)
        assertEquals("john.doe@example.com", userDTO.email)
    }

    @Test
    fun `test equals and hashCode methods`() {
        // Given
        val userDTO1 = UserDTO(name = "John Doe", email = "john.doe@example.com")
        val userDTO2 = UserDTO(name = "John Doe", email = "john.doe@example.com")
        val userDTO3 = UserDTO(name = "Jane Doe", email = "jane.doe@example.com")

        // Then
        assertEquals(userDTO1, userDTO2) // Equality check
        assertEquals(userDTO1.hashCode(), userDTO2.hashCode()) // HashCode check
        assertNotEquals(userDTO1, userDTO3) // Inequality check
    }

    @Test
    fun `test toString method`() {
        // Given
        val userDTO = UserDTO(name = "John Doe", email = "john.doe@example.com")

        // Then
        val expectedToString = "UserDTO(name=John Doe, email=john.doe@example.com)"
        assertEquals(expectedToString, userDTO.toString())
    }

    @Test
    fun `test copy method`() {
        // Given
        val userDTO = UserDTO(name = "John Doe", email = "john.doe@example.com")

        // When
        val copiedUserDTO = userDTO.copy(name = "Jane Doe")

        // Then
        assertEquals("Jane Doe", copiedUserDTO.name)
        assertEquals("john.doe@example.com", copiedUserDTO.email)
    }
}