plugins {
    id("enterprises.stardust.kosmos")
}

group = "enterprises.stardust"
version = "0.1.0"

subprojects {
    dependencies {
        val implementation by configurations
        implementation("org.jetbrains:annotations:24.0.1")

        val testImplementation by configurations
        //testImplementation(kotlin("test"))
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
            from(rootProject.file("LICENSE"))
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }
}