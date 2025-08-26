package sk.ursus.base

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.ContributesIntoSet
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@Inject
@ContributesIntoSet(AppScope::class)
class ThirdProcessor(
    @param:QualifierFor(AppScope::class) private val httpClient: HttpClient
) : Processor {
    override fun process() {
    }
}

interface OmgSyncer {
    fun setup()
}

@Inject
@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
@OptIn(ExperimentalEncodingApi::class)
class OmgSyncerImpl(
    private val thirdProcessor: ThirdProcessor,
    private val logger: LOG
) : OmgSyncer {
    override fun setup() {
        val x = Base64.encode(byteArrayOf(1, 2, 3, 4, 5, 6))
        logger.d(message = "base64=$x")
    }
}

fun blabla() {
    val httpClientGraph = Graphs.graphs.firstOrNull { it is HttpClientGraph } as? HttpClientGraph
    val logger = httpClientGraph!!.logger
    val x = httpClientGraph.httpClient
    logger.d(message = "httpClientGraph=$httpClientGraph")
}

@ContributesTo(AppScope::class)
interface HttpClientGraph {
    val logger: LOG

    @QualifierFor(AppScope::class)
    val httpClient: HttpClient
}