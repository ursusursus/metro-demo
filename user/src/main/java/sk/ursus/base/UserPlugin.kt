package sk.ursus.base

import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.IntoSet
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.SingleIn

@Inject
@SingleIn(UserScope::class)
@AutoInitializedPlugin
class UserPlugin(
    private val logger: LOG
) : Plugin {
    override fun initialize() {
        logger.d(message = "Hello I'm UserPlugin")
    }
}

//@Inject
//@SingleIn(UserScope::class)
//@QualifierFor(UserScope::class)
//@ContributesIntoSet(UserScope::class)
//class UserPluginWrapperToBeGenerated(
//    private val userPlugin: UserPlugin
//) : Plugin by userPlugin

annotation class AutoInitializedPlugin // Hook codegen here

@ContributesTo(UserScope::class)
interface UserPluginProvider {
    @Provides
    @QualifierFor(UserScope::class)
    @IntoSet
    fun provideUserPlugin(userPlugin: UserPlugin): Plugin {
        return userPlugin
    }
}