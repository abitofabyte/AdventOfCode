package yes.no.aoc2023.puzzles.day01

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import yes.no.aoc2023.service.FileReader

class TrebuchetTest {
    private lateinit var fileReader: FileReader
    private lateinit var trebuchet: Trebuchet

    @BeforeEach
    fun setUp() {
        fileReader = mock(FileReader::class.java)
        trebuchet = Trebuchet(fileReader)
    }

    @Test
    fun convert() {

        assert(trebuchet.convert("1") == "1")
        assert(trebuchet.convert("one") == "1")
        assert(trebuchet.convert("one1") == "11")
        assert(trebuchet.convert("1one") == "11")
        assert(trebuchet.convert("oneone") == "11")
        assert(trebuchet.convert("zeroonetwothreefourfivesixseveneightnine") == "0123456789")
        assert(trebuchet.convert("twozerotwothree") == "2023")
        assert(trebuchet.convert("twoandfourissix") == "2and4is6")
    }

    @Test
    fun extractNumber() {

        val results = listOf(
            Pair(trebuchet.extractNumber("one1"), 11),
            Pair(trebuchet.extractNumber("1234"), 14),
            Pair(trebuchet.extractNumber("1two3four"), 13),
            Pair(trebuchet.extractNumber(trebuchet.convert("1two3four")), 14)
        )

        results.forEach { r -> assert(r.first == r.second) }

    }

    @Test
    fun solve() {
        `when`(fileReader.read("./input/day01/input.txt")).thenReturn(
            listOf(
                "four2tszbgmxpbvninebxns6nineqbqzgjpmpqr",      //26 ,49
            )
        )

        trebuchet.init()

        val (resultA, resultB) = trebuchet.solve();

        assert(resultA == "26")
        assert(resultB == "49")
    }
}