package com.logistics.packaging.runner

import com.logistics.packaging.model.Input
import com.logistics.packaging.model.Output
import com.logistics.packaging.service.PackagingService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.io.File
import java.util.*

@Component
class CommandLineAppStartupRunner : CommandLineRunner {

    @Autowired
    lateinit var packagingService: PackagingService

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        val fileName: String = args[0]
        File(fileName).forEachLine {
            var output: Output = this.packagingService.pack(Input(it));
            logger.info("{}", output.toString())
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CommandLineAppStartupRunner::class.java)
    }
}