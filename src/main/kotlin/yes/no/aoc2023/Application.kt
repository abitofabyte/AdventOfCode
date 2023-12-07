package yes.no.aoc2023

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import yes.no.aoc2023.puzzles.Puzzle

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@SpringBootApplication
class Application : CommandLineRunner {

    @Autowired
    lateinit var days: List<Puzzle>

    private fun printSeperator() {
        println("-------------------------------------------------------------\n")
    }

    override fun run(vararg args: String?) {

        println("\nDay ${days.size}")
        printSeperator()

        days.forEach(::printDay)
    }

    fun printDay(puzzle: Puzzle) {
        val (solutionA, solutionB) = puzzle.solve()
        println(solutionA)
        println(solutionB)
        printSeperator()
    }
}
