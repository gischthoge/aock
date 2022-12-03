fun main() {
    fun part1(input: List<String>): Int {
        return input.splitByBlank().maxOf { elf -> elf.sumOf { it.toInt() } } }

    fun part2(input: List<String>): Int {
        return input.splitByBlank().map { elf -> elf.sumOf { it.toInt() } }
                .sortedDescending()
                .take(3)
                .sum()
    }

    val input = readInput("Day01")

    println(part1(input))
    println(part2(input))
}

fun List<String>.splitByBlank(): List<List<String>> {
    // https://stackoverflow.com/questions/65248942/how-to-split-a-list-into-sublists-using-a-predicate-with-kotlin
    return this.flatMapIndexed { index: Int, s: String ->
        when {
            index == 0 || index == this.lastIndex -> listOf(index)
            s.isEmpty() || s.isBlank() -> listOf(index - 1, index + 1)
            else -> emptyList()
        }
    }.windowed(size = 2, step = 2) {(from, to) ->
        this.slice(from..to)
    }
}