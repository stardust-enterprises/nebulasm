package enterprises.stardust.kosmos.util

import org.gradle.api.tasks.SourceSet

infix fun SourceSet.requires(other: SourceSet) {
    this.compileClasspath += other.output
    this.runtimeClasspath += other.output
}

/*
context(DependencyHandlerScope)
operator fun String.unaryPlus() {
    "implementation"(this)
}
*/