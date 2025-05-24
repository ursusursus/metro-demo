package sk.ursus.metrodemo

import android.content.Context
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides
import sk.ursus.base.OmgSyncer
import sk.ursus.base.Processor

@DependencyGraph(AppScope::class)
interface AppGraph {
    val repository: FooRepository
    val processors: Set<Processor>
    val omgSyncer: OmgSyncer

    @DependencyGraph.Factory
    interface Factory {
        fun create(@Provides context: Context): AppGraph
    }
}