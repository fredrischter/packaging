package com.mobiquityinc.packer

import com.logistics.packaging.model.Input
import com.logistics.packaging.model.Output
import com.logistics.packaging.runner.CommandLineAppStartupRunner
import java.io.File
import java.lang.StringBuilder
import java.util.stream.Collectors

class Packer {

    companion object {
        fun pack(input: Input): Output {
            // TODO actual logic
            val output: Output = Output()
            output.things = input.things.stream().collect(Collectors.toList())
            return output
        }

        fun pack(fileName: String): String {
            val sb = StringBuilder();

            File(fileName).forEachLine {
                val output = pack(Input(it));
                sb.append(output.toString() + "\n")
            }

            return sb.toString();
        }
    }
}