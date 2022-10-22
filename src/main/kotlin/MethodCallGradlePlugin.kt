
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption



class MethodCallGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
         target.task("HelloTask") {
               print("Hello from Sushobh's plugin")
         }
    }
}

