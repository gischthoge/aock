fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.toCharArray().first().lowercaseChar() to it.toCharArray().last().lowercaseChar() }
                .sumOf { (a, b) -> b - 'x' + 1 + ((b + ('a' - 'x') - a + 1).mod(3)) * 3 }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.toCharArray().first() to it.toCharArray().last() }
                .sumOf { (a,b) -> (b - 'X') * 3 + ((a + (b - 'Y') - 'A').mod(3) + 1) }
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}