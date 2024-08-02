package org.project.portfolio.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Users")
class User(
    val name: String,
    var phone: String,
    var email: String,
    var password: String,
    @Id @GeneratedValue val id: Long? = null
)