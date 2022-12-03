fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            val (a,b) = it.chunked(it.length/2)
            val char = a.toSet().intersect(b.toSet()).first()
            if (char.isUpperCase()) 27 + (char - 'A') else 1 + (char - 'a')
        }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf {(a,b,c) ->
            val char = a.toSet()
                    .intersect(b.toSet())
                    .intersect(c.toSet())
                    .first()
            if (char.isUpperCase()) 27 + (char - 'A') else 1 + (char - 'a')
        }
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}