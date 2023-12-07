package yes.no.aoc2023.service

import org.springframework.stereotype.Service
import java.io.File

@Service
class FileReader {
    fun read(file: String): List<String> = File(file).useLines { it.toList() }
}