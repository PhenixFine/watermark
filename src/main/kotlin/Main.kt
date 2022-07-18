import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
    val fileName = getFileName()

    if (File(fileName).isFile) printInfo(fileName) else println("The file $fileName doesn't exist.")
}

private fun getFileName(): String {
    println("Input the image filename:")
    return readln()
}

private fun printInfo(fileName: String) {
    getBufferedImage(fileName)?.let { image ->
        println("Image file: $fileName")
        println("Width: " + image.width)
        println("Height: " + image.height)
        println("Number of components: " + image.colorModel.numComponents)
        println("Number of color components: " + image.colorModel.numColorComponents)
        println("Bits per pixel: " + image.colorModel.pixelSize)
        println("Transparency: " + listOf("OPAQUE", "BITMASK", "TRANSLUCENT")[image.transparency - 1])
    } ?: println("Error reading $fileName")
}

private fun getBufferedImage(fileName: String): BufferedImage? {
    return try {
        ImageIO.read(File(fileName))
    } catch (e: Exception) {
        null
    }
}