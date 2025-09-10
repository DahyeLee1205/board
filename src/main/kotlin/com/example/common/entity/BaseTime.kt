package com.example.common.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTime {
    @CreatedDate
    @Column(updatable = false, name = "create_date")
    var createDate: LocalDateTime? = LocalDateTime.now()
        protected set

    @LastModifiedDate
    @Column(name = "modify_date")
    var modifyDate: LocalDateTime? = null
        protected set

    @PrePersist
    protected fun prePersist() {
        this.createDate = LocalDateTime.now()
    }

    @PreUpdate
    protected fun preUpdate() {
        this.modifyDate = LocalDateTime.now()
    }
}
