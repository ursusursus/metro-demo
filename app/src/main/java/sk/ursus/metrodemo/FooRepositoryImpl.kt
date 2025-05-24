package sk.ursus.metrodemo

import android.content.Context
import android.util.Log
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import sk.ursus.base.HttpClient
import sk.ursus.base.QualifierFor

interface FooRepository {
    fun foo()
}

@Inject
@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
class FooRepositoryImpl(
    private val context: Context,
    @QualifierFor(AppScope::class) private val httpClient: HttpClient
) : FooRepository {

    override fun foo() {
        val x = context.getString(R.string.app_name)
        Log.d("Default", "x=$x, httpClient=$httpClient")
    }
}