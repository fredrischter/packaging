package com.logistics.packaging.model

import java.util.ArrayList
import java.util.stream.Collectors
import kotlin.streams.toList

class Package {

    var things: List<Thing> = emptyList()

    public override fun toString(): String {
        return this.things.map(Thing::index).joinToString(",")
    }

    fun cost(): Double {
        return things.sumByDouble { it.cost }
    }

    fun weight(): Double {
        return things.sumByDouble { it.weight }
    }

    fun withThing(thing: Thing): Package {
        val pack = Package()
        pack.things = things.toMutableList()
        pack.things += thing
        return pack
    }

    fun sort() {
        things = things.stream().sorted( compareBy { it.index } ).toList()
    }

    companion object {
        public fun emptyPackage(): Package {
            return Package()
        }
    }

}