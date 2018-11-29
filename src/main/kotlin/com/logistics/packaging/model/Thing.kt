package com.logistics.packaging.model

class Thing {

    var index: Long
    var weight: Double
    var cost: Double

    constructor(fields: List<String>) {
        this.index = fields[0].toLong()
        this.weight = fields[1].toDouble()
        this.cost = Regex("[^\\d.]").replace(fields[1], "").toDouble()
    }
}