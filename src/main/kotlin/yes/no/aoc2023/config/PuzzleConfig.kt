package yes.no.aoc2023.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import yes.no.aoc2023.puzzles.Puzzle
import yes.no.aoc2023.puzzles.day01.Trebuchet
import yes.no.aoc2023.puzzles.day02.CubeConundrum
import yes.no.aoc2023.service.FileReader

@Configuration
class PuzzleConfig {


    private fun getDirectoryName(day: Int): String {
        val dayString = day.toString().padStart(2, '0')
        return "./input/day$dayString/input.txt"
    }

    @Bean
    fun getPuzzles(fileReader: FileReader): List<Puzzle> {
        return listOf(
            Trebuchet(getDirectoryName(1), fileReader),
            CubeConundrum(getDirectoryName(2), fileReader)
        )
    }

}