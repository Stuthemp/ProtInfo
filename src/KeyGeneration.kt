import java.io.File
import java.io.IOException
import java.io.RandomAccessFile
import java.util.*

class KeyGeneration{
    @Throws(IOException::class)
     fun randomKey(Key: File) {
        val bytes = ByteArray(256)
        val generator = Random()
        for (i in 0..255) {
            bytes[i] = i.toByte()
        }
        val numberOfPermutation = generator.nextInt(255)
        for (i in 0 until numberOfPermutation) permutation(bytes, generator)
        val Writer = RandomAccessFile(Key, "rw")
        Writer.write(bytes)
        Writer.close()
    }

     fun permutation(bytes: ByteArray, generator: Random): ByteArray? {
        val randomInt1 = generator.nextInt(255)
        val randomInt2 = generator.nextInt(255)
        val buff = bytes[randomInt1].toInt()
        bytes[randomInt1] = bytes[randomInt2]
        bytes[randomInt2] = buff.toByte()
        return bytes
    }
}