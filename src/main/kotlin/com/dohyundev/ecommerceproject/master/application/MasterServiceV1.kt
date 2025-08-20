package com.dohyundev.ecommerceproject.master.application

import com.dohyundev.ecommerceproject.master.domain.Master
import com.dohyundev.ecommerceproject.master.domain.MasterRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MasterServiceV1(
    private val masterRepository: MasterRepository
) {

    @Transactional
    fun register(code: String, valueType: Master.ValueType, value: String) {
        val existing = findIfExists(code)
        if (existing != null) {
            updateMaster(existing, valueType, value)
        } else {
            createMaster(code, valueType, value)
        }
    }

    private fun findIfExists(code: String): Master? {
        return masterRepository.findByCode(code).orElse(null)
    }

    private fun updateMaster(master: Master, valueType: Master.ValueType, value: String) {
        master.valueType = valueType
        master.value = value
    }

    private fun createMaster(code: String, valueType: Master.ValueType, value: String) {
        val newMaster = Master(
            valueType = valueType,
            code = code,
            value = value
        )
        masterRepository.save(newMaster)
    }
}
