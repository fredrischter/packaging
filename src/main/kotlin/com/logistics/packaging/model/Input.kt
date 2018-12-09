package com.logistics.packaging.model

import com.logistics.packaging.exception.WrongParametersException
import java.lang.Exception
import java.util.regex.Matcher
import java.util.regex.Pattern

class Input {

    var capacity: Double
    var things : Set<Thing>

    constructor(input: String) {
        try {
            this.capacity = input.split(":")[0].trim().toDouble()
            val thingsString = input.split(":")[1].trim()
            val partsMatcher = Pattern.compile("\\((.*?)\\)").matcher(thingsString);
            this.things = emptySet()
            while (partsMatcher.find()) {
                this.things = this.things.plus(Thing(partsMatcher.group(1).trim().split(",")))
            }
        } catch (e: Exception) {
            throw WrongParametersException(e)
        }
    }
}
