package com.logistics.packaging.service

import com.logistics.packaging.model.Input
import com.logistics.packaging.model.Output
import org.springframework.stereotype.Service

@Service
class PackagingService {

    fun pack(input: Input): Output {
        // TODO actual logic
        return Output()
    }

}
