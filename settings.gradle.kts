pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net") { name = "Fabric" }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        val loomVersion: String by settings
        id("fabric-loom").version(loomVersion)
        val kotlinVersion: String by System.getProperties()
        kotlin("jvm").version(kotlinVersion)
        val cursegradleVersion: String by settings
        id("com.matthewprenger.cursegradle").version(cursegradleVersion)
    }
}