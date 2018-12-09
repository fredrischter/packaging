package com.logistics.packaging.runner

import com.logistics.packer.Packer
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

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