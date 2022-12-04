fun main() {
    fun part1(input: List<String>): Int {
        return input.map { pair ->
            pair.split(",")
                .map { range ->
                    val (from, to) = range.split("-").map { it.toInt() }
                    (from..to).toSet()
                }
        }.filter { (first, second) ->
            val duplicates = first.intersect(second)
            duplicates == first || duplicates == second
        }.size
    }

    fun part2(input: List<String>): Int {
        return input.map { pair ->
            pair.split(",")
                .map { range ->
                    val (from, to) = range.split("-").map { it.toInt() }
                    from..to
                }
        }.filter { (first, second) -> first.intersect(second).isNotEmpty() }
            .size
    }

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}