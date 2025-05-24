package sk.ursus.base

import dev.zacsweers.metro.Qualifier
import kotlin.reflect.KClass

abstract class UserScope private constructor()

@Qualifier
annotation class QualifierFor(val scope: KClass<*>)