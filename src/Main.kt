import java.io.File
import java.util.*



fun main() {
        println("To generate new key enter \"1\"")
        println("If you don`t want to generate new key enter any other symbol")
        println("!!!If u Encrypted smth with another key u wont be able to decrypt it anymore, if you create new one!!!")
        val read = Scanner(System.`in`)
        var bool = read.nextLine()
        if (bool == "1") {
                val keyGeneration = KeyGeneration()
                keyGeneration.randomKey(File("C:\\pi\\", "key.txt"))
        }
        val encryptionDecryption = EncryptAndDecrypt("Source.docx", "Encryption.docx", "C:\\pi\\", "C:\\pi\\")
        println("To encrypt information enter \"1\"")
        println("To decrypt enter any symbol")
        var choice = read.nextLine()
        if (choice == "1") {
            encryptionDecryption.Encryption()
        } else {
            encryptionDecryption.Decryption()
        }
        println("Initial file length: ${encryptionDecryption.initialFile.length}")
        println("Bytes frequency: ")
        println(encryptionDecryption.initialFile.BytesFrequency())
        read.close()
    }