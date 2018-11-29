package com.logistics.packaging.model

import java.util.ArrayList
import java.util.stream.Collectors

class Output {

    var things: List<Thing> = emptyList()

    public override fun toString(): String {
        return this.things.map(Thing::index).joinToString(",")
    }

}