import java.io.File
import java.io.RandomAccessFile

class AccessFiles(dir: String?, name: String?) {
    var file: File
    var dir: String?
    var name: String?
    var length: Int

    fun countFileLength(): Int {
        var length = 0
        val reader = RandomAccessFile(file, "r")
        while (true) {
            if (reader.read() == -1) break
            length++
        }
        reader.close()
        return length
    }

    fun BytesFrequency(): Double {
        var relativeRate = 0.0
        var rate = 0
        var readByte = 0
        val reader = RandomAccessFile(file, "r")
        for(i in 0..255) {
            while (true) {
                readByte = reader.read()
                if (readByte.toByte() == i.toByte()) rate++
                if (readByte == -1) break
            }
            relativeRate = rate.toDouble() / length
            println("$i : $relativeRate")
            rate = 0
            reader.seek(0)
        }
        reader.close()


        return relativeRate
    }

    init {
        file = File(dir, name)
        this.dir = dir
        this.name = name
        length = countFileLength()
    }
}
