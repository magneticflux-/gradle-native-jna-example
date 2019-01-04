plugins {
    java
    idea
}

group = "com.skaggsm"
version = "0.1.0"

repositories {
    jcenter()
}

dependencies {
    implementation("net.java.dev.jna", "jna", "5.2.0")
    implementation("net.java.dev.jna", "jna-platform", "5.2.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks.test {
    useJUnitPlatform()
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
}