fun main() {
    fun moveCratesAndGetTop(input: List<String>, reverse: Boolean): String {
        val cratesInput = input
            .filter { it.contains("[") }
            .map { row -> row.chunked(4).map { it.replace(Regex("[\\s\\[\\]]"), "") }}
        val maxSize = cratesInput.maxOf { it.size }

        val stacks = (0 until maxSize).map { stack ->
            cratesInput.mapNotNull { it.getOrNull(stack) }
                .filter { it.isNotEmpty()  }
        }

        return input.mapNotNull {
            Regex("move (\\d+) from (\\d+) to (\\d+)")
                .find(it)
                ?.groupValues?.drop(1)
                ?.map { s -> s.toInt() } }
            .fold(stacks.toMutableList()) { acc, (take, from, to) ->
                val crates = if (reverse) acc[from - 1].take(take).reversed() else acc[from - 1].take(take)
                acc[from - 1] = acc[from - 1].drop(take)
                acc[to - 1] = crates + acc[to - 1]
                acc
            }.joinToString("") { it.firstOrNull() ?: "" }
    }

    fun part1(input: List<String>): String {
        return moveCratesAndGetTop(input, reverse = true)
    }

    fun part2(input: List<String>): String {
        return moveCratesAndGetTop(input, reverse = false)

    }

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}