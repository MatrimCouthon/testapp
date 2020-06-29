import java.net.URI

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(Dependencies.Plugins.android)
        classpath(Dependencies.Plugins.kotlin)
        classpath(Dependencies.gms)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url = URI.create("https://jitpack.io")
            url = URI.create("https://dl.bintray.com/terrakok/terramaven/")
        }
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}