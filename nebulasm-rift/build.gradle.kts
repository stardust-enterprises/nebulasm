import enterprises.stardust.kosmos.util.requires

version = "0.0.1"

kosmos.createSourceSet("api") {
    sourceSets["main"] requires this
    kosmos.createJarTask(this)
}

dependencies {
    //TODO: abstract into :nebulasm-codegen
    implementation("org.ow2.asm:asm:9.6")
}