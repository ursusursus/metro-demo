package sk.ursus.base

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.ContributesIntoSet
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@Inject
@ContributesIntoSet(AppScope::class)
class ThirdProcessor : Processor {
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