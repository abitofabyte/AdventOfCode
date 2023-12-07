package yes.no.aoc2023.puzzles

import yes.no.aoc2023.service.FileReader

abstract class PuzzleBase(val file: String, val fileReader: FileReader) : Puzzle {

    protected lateinit var data : List<String>

    abstract fun solvePart1(): String
    abstract fun solvePart2(): String

    override fun init() {
        data = fileReader.read(file)
    }

    override fun solve(): Pair<String, String> {
        init()
        return Pair(solvePart1(), solvePart2())
    }
}