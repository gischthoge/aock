fun main() {
    fun findMarker(input: String, size: Int): Int {
        return input
            .windowed(size = size, step = 1)
            .indexOfFirst { it.toSet().size == size } + size
    }

    fun part01(input: List<String>): Int {
        return findMarker(input.first(), 4)
    }

    fun part02(input: List<String>): Int {
       return findMarker(input.first(), 14)
    }

    val input = readInput("Day06")
    println(part01(input))
    println(part02(input))
}