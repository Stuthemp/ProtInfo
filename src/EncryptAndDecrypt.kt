import java.io.IOException
import java.io.RandomAccessFile

class EncryptAndDecrypt(
    sourseFile: String?,
    encryptionFile: String?,
    dir: String?,
    keyDir: String?
) {
    var key: AccessFiles
    var keyBytes: IntArray
    var initialFile: AccessFiles
    var secretFile: AccessFiles

    fun Encryption(): Boolean {
        try {
            val reader = RandomAccessFile(initialFile.file, "r")
            val writer = RandomAccessFile(secretFile.file, "rw")
            var pointer = 0
            while (true) {
                pointer = reader.read()
                if (pointer == -1) break
                writer.write(keyBytes[pointer])
            }
            reader.close()
            writer.close()
        } catch (e: IOException) {
            return false
        }
        return true
    }

    fun Decryption(): Boolean {
        try {
            val reader = RandomAccessFile(secretFile.file, "r")
            val writer = RandomAccessFile(initialFile.file, "rw")
            var pointer = 0
            while (true) {
                pointer = reader.read()
                if (pointer == -1) break
                for (i in 0..255) {
                    if (keyBytes[i] == pointer) {
                        writer.write(i)
                        break
                    }
                }
            }
            reader.close()
            writer.close()
        } catch (e: IOException) {
            return false
        }
        return true
    }

    init {
        this.initialFile = AccessFiles(dir,sourseFile)
        this.secretFile = AccessFiles(dir, encryptionFile)
        key = AccessFiles(keyDir, "key.txt")
        keyBytes = IntArray(256)
        val reader = RandomAccessFile(key.file, "r")
        for (i in 0..255) {
            keyBytes[i] = reader.read()
        }
        reader.close()
    }
}