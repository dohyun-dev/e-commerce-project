package com.dohyundev.ecommerceproject.domain.master

import BaseEntity
import com.dohyundev.ecommerceproject.common.exception.BusinessException
import jakarta.persistence.*

@Entity
@Table(
    name = "master_data",
    uniqueConstraints = [UniqueConstraint(name = "uc_master_code", columnNames = ["code"])]
)
class Master (
    @Column(nullable = false, updatable = false, length = 100)
    val code: String,
    var value: String,
    @Column(name = "value_type")
    var valueType: ValueType,
    ) : BaseEntity() {
    @Version
    protected var version: Long = 0L

    enum class ValueType {
        NUMBER, STRING
    }

    @PrePersist
    @PreUpdate
    fun validateValue() {
        if (valueType == ValueType.NUMBER) {
            try {
                value.toBigDecimal()
            } catch (e: NumberFormatException) {
                throw BusinessException("숫자 타입은 숫자만 입력해주세요. (입력값 : $value)")
            }
        }
    }

    fun update(
        valueType: ValueType,
        value: String,
    ) {
        this.valueType = valueType
        this.value = value
    }
}