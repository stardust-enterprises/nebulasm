import org.gradle.internal.service.DefaultServiceRegistry
import org.gradle.invocation.DefaultGradle

rootProject.name = "nebulasm"

includeBuild("build-logic")

val services = ((gradle as DefaultGradle).services as DefaultServiceRegistry)
arrayOf("codegen").forEach { module ->
    include(":${rootProject.name}-$module")
}
include("nebulasm-rift")
