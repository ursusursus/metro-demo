package sk.ursus.base

interface PluggableGraph {
    val name: String
    val plugins: Set<Plugin>
}