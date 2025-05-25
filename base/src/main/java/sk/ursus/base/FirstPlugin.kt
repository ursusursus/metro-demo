package sk.ursus.base

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoSet
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn

@Inject
@SingleIn(AppScope::class)
@ContributesIntoSet(AppScope::class)
@QualifierFor(AppScope::class)
class FirstPlugin(
    private val logger: LOG
) : Plugin {
    override fun initialize() {
        logger.d(message = "Hello I'm FirstPlugin")
    }
}