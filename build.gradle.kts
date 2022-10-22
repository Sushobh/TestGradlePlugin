plugins {
    kotlin("jvm") version "1.6.10"
    java
    id("com.vanniktech.maven.publish").version("0.20.0")
    `java-gradle-plugin`

}

val kotlinVersion = "1.7.0"
group = "org.sushobh"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:${kotlinVersion}")
}

gradlePlugin {
    plugins {
        create("helloPlugin") {
            id = "org.sushobh.helloplugin"
            implementationClass = "MethodCallGradlePlugin"
            displayName = "Sushobh's hello plugin"
        }
    }
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}