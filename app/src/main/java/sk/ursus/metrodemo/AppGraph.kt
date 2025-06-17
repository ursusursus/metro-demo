package sk.ursus.metrodemo

import android.content.Context
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Extends
import dev.zacsweers.metro.Provides
import sk.ursus.base.OmgSyncer
import sk.ursus.base.PluggableGraph
import sk.ursus.base.Plugin
import sk.ursus.base.Processor
import sk.ursus.base.QualifierFor
import sk.ursus.base.UserScope

@DependencyGraph(AppScope::class, isExtendable = true)
interface AppGraph : PluggableGraph {
    override val name: String get() = "AppGraph"

    @QualifierFor(AppScope::class)
    override val plugins: Set<Plugin>

    val repository: FooRepository
    val processors: Set<Processor>
    val omgSyncer: OmgSyncer
    val fooViewModelFactory: FooViewModelFactory

    @DependencyGraph.Factory
    interface Factory {
        fun create(@Provides context: Context): AppGraph
    }
}

@DependencyGraph(UserScope::class)
interface UserGraph : PluggableGraph {
    override val name: String get() = "UserGraph($userId)"

    @QualifierFor(UserScope::class)
    override val plugins: Set<Plugin>

    val userId: String
    val userRepository: UserRepository

    @DependencyGraph.Factory
    interface Factory {
        fun create(@Extends appGraph: AppGraph, @Provides userId: String): UserGraph
    }
}