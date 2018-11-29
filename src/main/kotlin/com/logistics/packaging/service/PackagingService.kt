package com.logistics.packaging.service

import com.logistics.packaging.model.Input
import com.logistics.packaging.model.Output
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class PackagingService {

    fun pack(input: Input): Output {
        // TODO actual logic
        var output: Output = Output()
        output.things = input.things.stream().collect(Collectors.toList())
        return output
    }

}
