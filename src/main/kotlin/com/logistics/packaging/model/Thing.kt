package com.logistics.packaging.model

class Thing {

    val index: Long
    val weight: Double
    val cost: Double

    constructor(fields: List<String>) {
        this.index = fields[0].toLong()
        this.weight = fields[1].toDouble()
        this.cost = Regex("[^\\d.]").replace(fields[2], "").toDouble()
    }

    override fun toString(): String {
        return "index " + index + " weight " + weight + " cost " + cost //String(SerializationUtils.serialize(this)!!)
    }
}