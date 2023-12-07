package yes.no.aoc2023.puzzles.day01

import yes.no.aoc2023.puzzles.PuzzleBase
import yes.no.aoc2023.service.FileReader


class Trebuchet(file: String, fileReader: FileReader) : PuzzleBase(file, fileReader) {

    private val numberLiterals = mapOf(
        "zero" to "0",
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )

    fun convert(input: String) : String {
        var current = input
        numberLiterals.forEach {
            current.replace(it.key, it.value, true).also { current = it }
        }
        return current
    }

    fun extractNumber(input: String): Int {
        val index = input.indexOfFirst { c -> c.isDigit() }
        val lastIndex = input.indexOfLast { c -> c.isDigit() }

        val n1 = input[index]
        val n2 = input[lastIndex]

        return "$n1$n2".toInt()
    }

    override fun solvePart1(): String {
        return data.sumOf { line -> extractNumber(line) }.toString()
    }

    override fun solvePart2(): String {
        return data.map(::convert).sumOf { line -> extractNumber(line) }.toString()
    }
}