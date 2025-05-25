package sk.ursus.base

import dev.zacsweers.metro.ContributesIntoSet
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn

@Inject
@SingleIn(UserScope::class)
@ContributesIntoSet(UserScope::class)
@QualifierFor(UserScope::class)
class SecondPlugin(
    private val logger: LOG
) : Plugin {
    override fun initialize() {
        logger.d(message = "Hello I'm SecondPlugin")
    }
}