fun main() {
    val costs = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun part1(input: List<String>): Int {
        return input
            .map {
                val halfSize = it.length / 2
                val leftHalf = it.subSequence(0, halfSize)
                val rightHalf = it.subSequence(halfSize, it.lastIndex + 1)
                val commonChar = leftHalf.toSet().intersect(rightHalf.toSet()).first()
                return@map costs.indexOf(commonChar)
            }
            .sum()
    }

    fun part2(input: List<String>): Int {
        return input
            .chunked(3)
            .map {
                val commonChar = it[0].toSet() intersect it[1].toSet() intersect it[2].toSet()
                return@map costs.indexOf(commonChar.first())
            }
            .sum()
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
