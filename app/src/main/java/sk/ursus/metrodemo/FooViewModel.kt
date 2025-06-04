package sk.ursus.metrodemo

import dev.zacsweers.metro.Assisted
import dev.zacsweers.metro.AssistedFactory
import dev.zacsweers.metro.Inject

@Inject
class FooViewModel(
    private val initialState: State = State(),
    private val repository: FooRepository,
    @Assisted val id: String
) {
    override fun toString(): String {
        return "FooViewModel(initialState=$initialState, repository=$repository, id='$id')"
    }

    data class State(val counter: Int = 42)
}

@AssistedFactory
interface FooViewModelFactory {
    fun create(id: String): FooViewModel
}