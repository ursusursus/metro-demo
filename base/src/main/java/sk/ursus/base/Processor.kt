package sk.ursus.base

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoSet
import dev.zacsweers.metro.Inject

interface Processor {
    fun process()
}

@Inject
@ContributesIntoSet(AppScope::class)
class FirstProcessor : Processor {
    override fun process() {
    }
}

@Inject
@ContributesIntoSet(AppScope::class)
class SecondProcessor : Processor {
    override fun process() {
    }
}