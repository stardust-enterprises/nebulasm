import enterprises.stardust.kosmos.util.requires

kosmos.createSourceSet("api") {
    sourceSets["main"] requires this
    kosmos.createJarTask(this)
}

dependencies {
    implementation("org.ow2.asm:asm:9.6")
}