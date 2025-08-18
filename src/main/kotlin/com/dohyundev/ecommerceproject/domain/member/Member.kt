package com.dohyundev.ecommerceproject.domain.member

import BaseEntity
import jakarta.persistence.*

@Entity
class Member(
    var username: String,

    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "password"))
    var password: Password,

    var name: String? = null,

    var phoneNumber: String? = null,

    @Enumerated(EnumType.STRING)
    var role: MemberRole = MemberRole.NORMAL
) : BaseEntity() {

}