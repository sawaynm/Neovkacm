
import com.machiav3lli.backup.handler.ShellHandler
import org.junit.Assert
import org.junit.Test

class ShellHandlerTest {
    @Test
    fun test_fromLsOOutput_handlesDoubleSpace() {
        val fileInfo = ShellHandler.FileInfo.fromLsOOutput(
                "-rw------- 1 user0_a247 group0_a247 15951095 2021-01-19 01:03:29.000000000 +0100 Schlichte\\ Galerie\\ Pro\\ -\\ Foto\\ Manager\\ \\ Editor-6.18.0.apk",
                "/data/data/org.fdroid.fdroid/files"
        )
        Assert.assertEquals(fileInfo.filePath, "Schlichte\\ Galerie\\ Pro\\ -\\ Foto\\ Manager\\ \\ Editor-6.18.0.apk")
        Assert.assertEquals(fileInfo.fileSize, 15951095)
        Assert.assertEquals(fileInfo.owner, "user0_a247")
        Assert.assertEquals(fileInfo.group, "group0_a247")
        Assert.assertEquals(fileInfo.fileModTime.time, 1611014609000)
        Assert.assertEquals(fileInfo.fileMode, 0b0_110_000_000)
    }
}