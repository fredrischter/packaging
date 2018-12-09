package com.logistics.packaging.runner

import com.logistics.packaging.exception.WrongParametersException
import com.logistics.packer.Packer
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.io.File

@Component
class CommandLineAppStartupRunner : CommandLineRunner {

    @Throws(WrongParametersException::class)
    override fun run(vararg args: String) {
        if (args == null) {
            throw WrongParametersException()
        }
        if (args[0] == null) {
            throw WrongParametersException()
        }

        val fileName: String = args[0]

        if (!File(fileName).exists() || !File(fileName).isFile()) {
            throw WrongParametersException()
        }

        CommandLineAppStartupRunner.logger.info("{}", Packer.pack(fileName));
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CommandLineAppStartupRunner::class.java)
    }
}