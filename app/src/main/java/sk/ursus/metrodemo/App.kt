package sk.ursus.metrodemo

import android.app.Application
import android.util.Log
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import dev.zacsweers.metro.createGraphFactory
import sk.ursus.base.Graphs
import sk.ursus.base.LOG
import sk.ursus.base.blabla

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val appGraph = createGraphFactory<AppGraph.Factory>().create(context = this)
        Graphs.graphs += appGraph

        val x = appGraph.repository
        val y = appGraph.repository
        Log.d("Default", "x=$x, y=$y")

//        val processors = appGraph.processors
//        Log.d("Default", "processors=$processors")
        val p = appGraph.processors
        Log.d("Default", "p=$p")

        val syncer = appGraph.omgSyncer
        syncer.setup()
        Log.d("Default", "syncer=$syncer")
        val syncer2 = appGraph.omgSyncer
        Log.d("Default", "syncer2=$syncer2")

        blabla()
    }
}

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
@Inject
class LOGImpl : LOG {
    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}