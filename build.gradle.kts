plugins {
    java
    idea
    id("com.github.ben-manes.versions").version("0.20.0")
}

group = "com.skaggsm"
version = "0.1.0"

repositories {
    jcenter()
}

dependencies {
    implementation("net.java.dev.jna", "jna", "5.2.0")
    implementation("net.java.dev.jna", "jna-platform", "5.2.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.2")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("jna.debug_load", true)
    testLogging {
        showStandardStreams = true
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

val nativeLib = project(":native-lib")

tasks.processResources {
    nativeLib.tasks.findByName("linkReleaseWindowsX86")?.also {
        from(it) {
            include("**/*.dll")
            into("win32-x86")
        }
    }
    nativeLib.tasks.findByName("linkReleaseWindowsX86-64")?.also {
        from(it) {
            include("**/*.dll")
            into("win32-x86-64")
        }
    }
    nativeLib.tasks.findByName("linkReleaseLinuxX86")?.also {
        from(it) {
            include("**/*.so")
            into("linux-x86")
        }
    }
    nativeLib.tasks.findByName("linkReleaseLinuxX86-64")?.also {
        from(it) {
            include("**/*.so")
            into("linux-x86-64")
        }
    }
    nativeLib.tasks.findByName("linkReleaseMacosX86-64")?.also {
        from(it) {
            include("**/*.dylib")
            into("darwin")
        }
    }
}