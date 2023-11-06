package enterprises.stardust.kosmos

if (project == rootProject) {
    throw RuntimeException("This plugin can only be applied to subprojects")
}

group = parent.run { "$group.$name" }
version = parent?.version ?: version

apply(plugin = "java-library")
apply(plugin = "org.jetbrains.kotlin.jvm")
val kosmos = extensions.create("kosmos", KosmosExtension::class.java)
kosmos.javaDefaults()