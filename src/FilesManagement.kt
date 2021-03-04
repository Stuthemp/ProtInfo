import java.io.File
import java.io.RandomAccessFile

class FilesManagement(val direct: String?, val fName: String? ){

    var len: Int  = 0
    var file: File? = null

    fun length() {
        val reader = RandomAccessFile(file,"r")
        while (true){
            if(reader.read()==-1)
                break;
            len++
        }
        reader.close()
    }

    fun calculateRelativeRate(){
        var relRate = 0.0
        var rate = 0
        var byte = 0
        val  reader = RandomAccessFile(file,"r")
        for(i in 0..255) {
        while (true){
                byte = reader.read()
                if (byte.toByte() == i.toByte()) rate++
                if (byte == -1) break
            }
            println("$i : $rate")
        }
    }

    init {
        file = File(direct,fName)
    }

}