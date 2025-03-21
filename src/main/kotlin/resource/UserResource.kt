package resource

import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong
import dto.UserDTO
import entity.User

@RestController
@RequestMapping("/users")
class UserResource {

    private val users = mutableListOf<User>()
    private val idCounter = AtomicLong()

    // POST endpoint to create a new user
    @PostMapping
    fun createUser(@RequestBody userRequest: UserDTO): User {
        val newUser = User(
            id = idCounter.incrementAndGet(),
            name = userRequest.name,
            email = userRequest.email
        )
        users.add(newUser)
        return newUser
    }

    // GET endpoint to retrieve all users
    @GetMapping
    fun getAllUsers(): List<User> {
        return users
    }

    // GET endpoint to retrieve a user by ID
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User {
        return users.find { it.id == id }
            ?: throw RuntimeException("entity.User not found with id: $id")
    }

    // DELETE endpoint to delete a user by ID
    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: Long): String {
        val user = users.find { it.id == id }
            ?: throw RuntimeException("entity.User not found with id: $id")
        users.remove(user)
        return "entity.User with id $id deleted successfully"
    }
}