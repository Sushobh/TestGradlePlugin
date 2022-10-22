import org.gradle.internal.impldep.org.testng.Assert
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MethodCallGradlePluginTest {

    @Test
    fun hello(){
        Assert.assertEquals(1,2)
    }

}