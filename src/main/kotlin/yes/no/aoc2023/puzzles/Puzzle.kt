package yes.no.aoc2023.puzzles

interface Puzzle {
    fun init()
    fun solve(): Pair<String, String>
}