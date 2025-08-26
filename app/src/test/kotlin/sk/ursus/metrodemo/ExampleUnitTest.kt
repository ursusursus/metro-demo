package sk.ursus.metrodemo

import kotlin.test.Test


class ExampleUnitTest {
    @Test
    fun testFunction() {
        val hello = "Hello"
        val world = "world!"
        assert(hello.length == world.length)
    }
}