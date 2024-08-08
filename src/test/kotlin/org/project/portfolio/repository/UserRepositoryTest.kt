package org.project.portfolio.repository

import jakarta.validation.ConstraintViolationException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.project.portfolio.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull
import kotlin.test.assertEquals

@DataJpaTest
class UserRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository
) {

    @Test
    fun `When findByIdOrNull then return User`() {
        val user = User("James", "010-1234-5678", "abc@abc.com", "somepassword")
        entityManager.persist(user)
        entityManager.flush()
        entityManager.clear()
        val result = userRepository.findByIdOrNull(user.id)
        assertEquals(user.id, result!!.id)
        assertEquals(user.name, result!!.name)
        assertEquals(user.phone, result!!.phone)
        assertEquals(user.email, result!!.email)
        assertEquals(user.password, result!!.password)
    }

    @Test
    fun `When invalid email then throw exception`() {
        val user = User("James", "010-1234-5678", "----", "somepassword")
        assertThrows<ConstraintViolationException> { 
            userRepository.save(user)
            entityManager.flush() 
        }
    }
}