package org.project.portfolio.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Email

@Entity
@Table(name = "Users")
class User(
    @Column(nullable = false, unique = true)
    val name: String,
    
    @Column(nullable = false)
    var phone: String,
    
    @Column(nullable = false)
    @field: Email // https://unluckyjung.github.io/kotlin/spring/2022/06/06/kotlin-validation-annotation/
    @param: Email
    // @Email 이렇게만 어노테이션 추가 시 동작 x
    var email: String,
    
    @Column(nullable = false)
    var password: String,
    
    @Id
    @GeneratedValue
    val id: Long? = null
)