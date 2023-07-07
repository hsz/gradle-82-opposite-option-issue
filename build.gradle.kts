plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks {
    register<MyTask>("myTask")

    wrapper {
        gradleVersion = providers.gradleProperty("gradleVersion").get()
    }
}

abstract class MyTask : DefaultTask() {

    @get:Input
    @Option(
        option = "no-feature",
        description = "Disable the feature.",
    )
    var noFeature = false

    @TaskAction
    fun run() {
        println("noFeature = $noFeature")
    }
}
