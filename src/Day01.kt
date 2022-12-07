fun main() {
    fun groupLines(input: List<String>): List<Int> {
        return input.fold(listOf(0)) { array, element ->
            if (element.isEmpty()) {
                array + listOf(0)
            } else {
                array.dropLast(1) + listOf(array.last() + element.toInt())
            }
        }
    }

    fun part1(input: List<String>): Int {
        return groupLines(input).max()
    }

    fun part2(input: List<String>): Int {
        return groupLines(input)
            .sortedDescending()
            .take(3)
            .sum()
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
