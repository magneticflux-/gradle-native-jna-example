plugins {
    `cpp-library`
    `maven-publish`
}

group = "com.skaggsm"
version = "0.1.0"


library {
    targetMachines.set(listOf(
            machines.windows.x86_64,
            machines.windows.x86,
            machines.linux.x86_64,
            machines.linux.x86,
            machines.macOS.x86_64,
            machines.macOS.x86
    ))
}
