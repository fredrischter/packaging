package com.logistics.packer

import com.logistics.packaging.exception.NoSuitablePackageException
import com.logistics.packaging.model.Input
import com.logistics.packaging.model.Package
import com.logistics.packaging.model.Thing
import java.io.File
import java.lang.StringBuilder
import kotlin.streams.toList

class Packer {

    class MostValuablePackageLookupContext {
        var capacity: Double
        var things: List<Thing>
        var mostValuablePackage: Package? = null

        constructor(capacity: Double, things: List<Thing>) {
            this.capacity = capacity
            this.things = things
            lookup(things)
        }

        fun isViableAndApply(pack: Package): Boolean {
            if (pack.weight() > capacity) {
                println(" Rejecting because is out of capacity: "+pack)
                return false
            }

            if (mostValuablePackage != null &&
                    (mostValuablePackage!!.cost() > pack.cost() ||
                            (mostValuablePackage!!.weight() < pack.weight() && mostValuablePackage!!.cost() == pack.cost()))) {
                println(" Rejecting "+pack+" because is less valuable than the choosen one: "+ mostValuablePackage + ": " + mostValuablePackage!!.cost() + " >= " + pack.cost())
                return true
            }

            mostValuablePackage = pack;
            println("  Most valuable: "+pack)
            return true
        }

        inner class MostValuablePackageLookup {

            constructor(things: List<Thing>) {
                things.forEach {
                    var other = things.toMutableList()
                    other.remove(it)
                    println("Lookup "+it+" "+other)
                    var pack = Package.emptyPackage()
                    MostValuablePackageLookup(pack, it, other)
                }
            }

            constructor(pack: Package, thing: Thing, other: List<Thing>) {
                var pack = pack.withThing(thing)

                if (isViableAndApply(pack)) {
                    other.forEach {
                        var otherLessThisOne = other.toMutableList()
                        otherLessThisOne.remove(it)
                        MostValuablePackageLookup(pack, it, otherLessThisOne)
                    }
                }
            }
        }

        fun lookup(things: List<Thing>) {
            val mostValuablePackageLookup = MostValuablePackageLookup(things)
        }
    }

    companion object {
        fun pack(input: Input): Package {
            if (input.things.isEmpty()) {
                throw NoSuitablePackageException()
            }

            println("Original items "+input.things)
            var orderedThings = input.things.stream().toList().sortedBy { -it.cost }

            println("Ordered items "+orderedThings)

            var mostValuablePackageLookupContext = MostValuablePackageLookupContext(input.capacity, orderedThings)

            if (mostValuablePackageLookupContext.mostValuablePackage == null) {
                throw NoSuitablePackageException()
            }

            mostValuablePackageLookupContext.mostValuablePackage!!.sort()

            return mostValuablePackageLookupContext.mostValuablePackage!!
        }

        fun pack(fileName: String): String {
            val sb = StringBuilder()

            File(fileName).forEachLine {
                try {
                    sb.append(pack(Input(it)).toString() + "\n")
                } catch (nspe: NoSuitablePackageException) {
                    sb.append("-\n")
                }
            }

            return sb.toString()
        }
    }
}