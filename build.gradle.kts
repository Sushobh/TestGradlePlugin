

plugins {
    kotlin("jvm") version "1.7.10"
    java
    id("com.vanniktech.maven.publish").version("0.20.0")
    `java-gradle-plugin`

}

val kotlinVersion = "1.7.0"


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
        create("helloSushobh") {
            id = "com.sushobh"
            implementationClass = "com.sushobh.gradle.exampleplugin.MethodCallGradlePlugin"
            displayName = "Sushobh's hello plugin"
        }
    }
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}