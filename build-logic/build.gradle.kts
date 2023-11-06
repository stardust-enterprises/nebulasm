import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { `kotlin-dsl` }

repositories { mavenCentral() }
dependencies { implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10") }

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-receivers")
    }
}
