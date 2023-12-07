package yes.no.aoc2023.puzzles.day02

import yes.no.aoc2023.puzzles.PuzzleBase
import yes.no.aoc2023.service.FileReader

class CubeConundrum(file: String, fileReader: FileReader) : PuzzleBase(file, fileReader) {

    private val target = mapOf("red" to 12, "blue" to 14, "green" to 13)

    private fun mapCubes(pick: String): Pair<String, Int> {
        val kvp = pick.trim().split(" ")
        return kvp[1].trim() to kvp[0].trim().toInt()
    }
    private fun mapRound(round: String): Map<String, Int> = round.trim().split(",").associate(::mapCubes)
    private fun isValidRound(round: Map<String, Int>) : Boolean = round.all { e -> target[e.key]!! >= e.value }

    private fun mapGame(input: String): Pair<Int, List<Map<String, Int>>> {
        val game = Regex("\\bGame\\s+(\\d+)\\b").find(input)!!.groups[1]!!.value.toInt()
        val round = Regex("\\bGame\\s+\\d+:\\s*").replace(input, "").split(";").map(::mapRound)

        return game to round
    }

    override fun solvePart1(): String {
        return data.map(::mapGame).map { round -> if(round.second.all(::isValidRound)) round.first else 0 }.sum().toString()
    }

    override fun solvePart2(): String {
        return "Part 2"
    }
}