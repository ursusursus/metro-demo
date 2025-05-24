package sk.ursus.base

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Provides

@ContributesTo(AppScope::class)
interface HttpClientProvider {
    @QualifierFor(AppScope::class)
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient(name = "App")
    }
}

class HttpClient(
    private val name: String
) {
    override fun toString(): String {
        return "HttpClient($name)"
    }
}