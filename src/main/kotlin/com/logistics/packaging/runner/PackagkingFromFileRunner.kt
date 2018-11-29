package com.logistics.packaging.runner

import com.logistics.packaging.model.Input
import com.logistics.packaging.model.Output
import com.logistics.packaging.service.PackagingService
import com.mobiquityinc.packer.Packer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.io.File
import java.util.*

@Component
class CommandLineAppStartupRunner : CommandLineRunner {

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        val fileName: String = args[0]
        CommandLineAppStartupRunner.logger.info("{}", Packer.pack(fileName));
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CommandLineAppStartupRunner::class.java)
    }
}