package com.sushobh.gradle.exampleplugin


import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels


class MethodCallGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val fileLocation ="${target.buildDir}\\np1.jar"
        val file = File(fileLocation)
        val url = URL("https://firebasestorage.googleapis.com/v0/b/firebase-someproject.appspot.com/o/np1.jar?alt=media&token=538f9bb1-7f33-4c5c-a2f1-45da7e7080d5")
        if(!file.exists()){
            try {
                println("Build dir is ${target.buildDir}")
                println("Trying to download from ${fileLocation}")
                println("Downloading jar for Method all plugin")
                file.createNewFile()
                downloadFile(url,file)
            } catch (e: Exception) {
                print("Method Call gradle plugin failed because could not download jar file ${e.printStackTrace()}")
            }
        }
        target.tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java)
            .configureEach {
                it.kotlinOptions {
                    val pluginFolder = "-Xplugin=${target.buildDir}\\np1.jar"
                    freeCompilerArgs = freeCompilerArgs + pluginFolder
                    freeCompilerArgs = freeCompilerArgs + "-P"
                    freeCompilerArgs = freeCompilerArgs + "plugin:arrow.meta.plugin.compiler:generatedSrcOutputDir=${target.buildDir}"
                }
            }
    }

    companion object {
        fun downloadFile(url: URL, file : File) {
            url.openStream().use {
                Channels.newChannel(it).use { rbc ->
                    FileOutputStream(file).use { fos ->
                        fos.channel.transferFrom(rbc, 0, Long.MAX_VALUE)
                    }
                }
            }
        }
    }
}

