package sk.ursus.metrodemo

import android.content.Context
import android.util.Log
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import sk.ursus.base.HttpClient
import sk.ursus.base.LOG
import sk.ursus.base.QualifierFor
import sk.ursus.base.UserScope

interface FooRepository {
    fun foo()
}

@Inject
@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
class FooRepositoryImpl(
    private val context: Context,
    @param:QualifierFor(AppScope::class) private val httpClient: HttpClient
) : FooRepository {

    override fun foo() {
        val x = context.getString(R.string.app_name)
        Log.d("Default", "x=$x, httpClient=$httpClient")
    }
}

@Inject
class UserRepository(
    private val logger: LOG,
    @param:QualifierFor(UserScope::class) private val httpClient: HttpClient
) {
    fun whatever() {
        logger.d(message = "whatever=$httpClient")
    }
}