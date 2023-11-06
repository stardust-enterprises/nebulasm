package enterprises.stardust.kosmos

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.testing.Test
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.*
import javax.inject.Inject

/**
 * @author xtrm
 * @since 0.0.1
 */
open class KosmosExtension
@Inject constructor(
    private val project: Project,
) {
    fun javaDefaults() = with(project) {
        repositories {
            mavenCentral()
        }

        dependencies {
            val implementation by configurations
            implementation("org.jetbrains:annotations:24.0.1")

            val testImplementation by configurations
            testImplementation(kotlin("test"))
            testImplementation(platform("org.junit:junit-bom:5.9.1"))
            testImplementation("org.junit.jupiter:junit-jupiter")
        }

        configure<JavaPluginExtension> {
            withJavadocJar()
            withSourcesJar()

            toolchain {
                languageVersion.set(JavaLanguageVersion.of(8))
            }
        }

        tasks {
            withType<Jar> {
                from(project.file("LICENSE").takeIf { it.exists() } ?: project.rootProject.file("LICENSE"))
            }

            withType<Test> {
                useJUnitPlatform()
            }
        }
    }

    fun createSourceSet(name: String, configureBlock: SourceSet.() -> Unit = {}): SourceSet {
        val sourceSets: SourceSetContainer by project.extensions
        return sourceSets.create(name) {
            java.srcDir("src/$name/java")
            resources.srcDir("src/$name/resources")

            val main by sourceSets
            compileClasspath += main.compileClasspath
            runtimeClasspath += main.runtimeClasspath

            configureBlock()
        }
    }

    fun createJarTask(sourceSet: SourceSet): Jar =
        project.tasks.create<Jar>(sourceSet.jarTaskName) {
            archiveClassifier.set(sourceSet.name)
            from(sourceSet.output)
            from(project.file("LICENSE").takeIf { it.exists() } ?: project.rootProject.file("LICENSE"))
        }
}